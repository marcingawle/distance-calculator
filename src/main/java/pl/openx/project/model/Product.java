package pl.openx.project.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    public int id;
    public String title;
    public BigDecimal price;
    public String description;
    public String category;
    public String image;
    public Rating rating;
}
