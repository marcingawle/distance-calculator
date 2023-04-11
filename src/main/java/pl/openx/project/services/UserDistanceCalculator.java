package pl.openx.project.services;

import pl.openx.project.model.Geolocation;
import pl.openx.project.model.User;
import pl.openx.project.model.UserPair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class UserDistanceCalculator {

    public static void main(String[] args) {
        // Stworzenie listy użytkowników z ich współrzędnymi geograficznymi
        List<User> users = new UserService().getAll();


        // Obliczenie największego dystansu między użytkownikami
        Optional<UserPair> maxDistancePair  = users.stream()
                .flatMap(user1 -> users.stream().map(user2 -> new UserPair(user1, user2)))
                .filter(pair -> !pair.getUser1().equals(pair.getUser2()))
                .max(Comparator.comparingDouble(pair -> pair.getUser1().calculateDistance(pair.getUser2())));

        if (maxDistancePair.isPresent()) {
            UserPair pair = maxDistancePair.get();
            System.out.println("Największy dystans między użytkownikami " + pair.getUser1().name + " i " + pair.getUser2().name +
                    ": " + pair.getUser1().calculateDistance(pair.getUser2()) + " metrów");
        } else {
            System.out.println("Nie udało się obliczyć dystansu między użytkownikami");
        }


    }


    // Reprezentacja pary użytkowników, potrzebna do obliczenia dystansu między nimi


    // Reprezentacja współrzędnych geograficznych





    }

