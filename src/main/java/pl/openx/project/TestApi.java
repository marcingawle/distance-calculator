package pl.openx.project;

import pl.openx.project.model.Cart;
import pl.openx.project.model.Product;
import pl.openx.project.model.User;
import pl.openx.project.model.UserPair;
import pl.openx.project.services.CartService;
import pl.openx.project.services.ProductService;
import pl.openx.project.services.UserService;

import java.io.IOException;

public class TestApi {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();
        CartService cartService = new CartService();
        ProductService productService = new ProductService();

//        System.out.println(userService.getAll());

        System.out.println("USERS: ");
        for (User user: userService.getAll()) {
            System.out.println(user);
        }
//
//        System.out.println("Carts: ");
//        for (Cart cart: cartService.getAll()) {
//            System.out.println(cart);
//        }
//
//        System.out.println("Products: ");
//        for (Product product: productService.getAll()) {
//            System.out.println(product);
//        }
//
//        System.out.println("Kategorie: " + productService.getAllCategories());
//        System.out.println("Wartości dla kategorii: " + productService.getCategoriesValue());
        System.out.println("Maksymalny koszyk: " + cartService.getMaxCartInfo());

        UserPair userPair = userService.getUsersWithMaxDistance();

        System.out.println("Użytkownicy z największym dystansem to: " + userPair);
        System.out.println("Ich dystans to: " + (userPair.getUser1().calculateDistance(userPair.getUser2())));

    }
}
