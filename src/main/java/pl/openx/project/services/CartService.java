package pl.openx.project.services;

import com.google.gson.reflect.TypeToken;
import pl.openx.project.model.Cart;
import pl.openx.project.model.MaxCartInfo;
import pl.openx.project.model.Product;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CartService extends JsonService {

    private static List<Cart> carts = null;

    private final ProductService productService = new ProductService();
    private final UserService userService = new UserService();

    public List<Cart> getAll()  {
        if (carts == null) {
            String json = null;
            try {
                json = getJsonFromUrl("https://fakestoreapi.com/carts");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Type listType = new TypeToken<ArrayList<Cart>>() {
            }.getType();

            carts = gson.fromJson(json, listType);
        }

        return carts;
    }

    public MaxCartInfo getMaxCartInfo() {
        Comparator<Cart> cartComparator = (cart1, cart2) -> getCartPriceById(cart1.getId()).compareTo(getCartPriceById(cart2.getId()));
        return getAll().stream().max(cartComparator).map(c -> new MaxCartInfo(getCartPriceById(c.getId()), userService.getUserById(c.getUserId()).getUsername())).orElse(null);
    }

    public Cart getCartById(int id)  {
        return getAll().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public BigDecimal getCartPriceById(int id)  {
        Cart cart = getCartById(id);
        if (cart == null) {
            return null;
        }
        return cart.getProductInfos().stream()
                .map(productInfo -> productService.getPriceById(productInfo.getProductId()).multiply(BigDecimal.valueOf(productInfo.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
