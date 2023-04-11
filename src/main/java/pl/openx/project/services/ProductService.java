package pl.openx.project.services;

import com.google.gson.reflect.TypeToken;
import pl.openx.project.model.Product;
import pl.openx.project.model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ProductService extends JsonService {

    private static List<Product> products = null;
    public List<Product> getAll() {
        if (products == null) {
            String json = null;
            try {
                json = getJsonFromUrl("https://fakestoreapi.com/products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Type listType = new TypeToken<ArrayList<Product>>() {
            }.getType();

            products = gson.fromJson(json, listType);
        }

        return products;
    }

    public List<String> getAllCategories() {
        return getAll().stream()
                .map(Product::getCategory)
                .distinct()
                .toList();
    }

    public Map<String, BigDecimal> getCategoriesValue() {
        return getAll().stream()
                .collect(groupingBy(Product::getCategory, Collectors.reducing(
                        BigDecimal.ZERO,
                        Product::getPrice,
                        BigDecimal::add)));
    }

    public BigDecimal getPriceById(int id) {
        return getAll().stream().filter(e -> e.getId() == id).findFirst().map(Product::getPrice).orElse(null);
    }

}
