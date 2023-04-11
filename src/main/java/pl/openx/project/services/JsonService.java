package pl.openx.project.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pl.openx.project.json.BigDecimalAdapter;
import pl.openx.project.json.LocalDateAdapter;
import pl.openx.project.model.Cart;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class JsonService{
    protected Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter())
            .registerTypeAdapter(BigDecimal.class, new BigDecimalAdapter())
            .create();

    protected String getJsonFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        Scanner scanner = new Scanner(url.openStream());

        return scanner.nextLine();
    }
}
