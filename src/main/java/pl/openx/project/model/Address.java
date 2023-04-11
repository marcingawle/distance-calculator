package pl.openx.project.model;

import lombok.Data;

@Data
public class Address{
    public Geolocation geolocation;
    public String city;
    public String street;
    public int number;
    public String zipcode;
}