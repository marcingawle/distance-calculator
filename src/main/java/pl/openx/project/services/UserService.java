package pl.openx.project.services;

import com.google.gson.reflect.TypeToken;
import pl.openx.project.model.User;
import pl.openx.project.model.UserPair;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserService extends JsonService {

    private static List<User> users = null;
    public List<User> getAll() {
        if (users == null) {
            String json = null;
            try {
                json = getJsonFromUrl("https://fakestoreapi.com/users");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            users = gson.fromJson(json, listType);
        }

        return users;
    }


    public User getUserById(int id)  {
        return getAll().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public UserPair getUsersWithMaxDistance() {
        return getAll().stream()
                .flatMap(user1 -> getAll().stream().map(user2 -> new UserPair(user1, user2)))
                .filter(pair -> !pair.pairEquals())
                .max(Comparator.comparingDouble(UserPair::calculateDistance))
                .orElse(null);
    }
}
