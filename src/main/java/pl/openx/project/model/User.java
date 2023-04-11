package pl.openx.project.model;

import lombok.Data;

@Data
public class User {
    public Address address;
    public int id;
    public String email;
    public String username;
    public String password;
    public Name name;
    public String phone;
    public int __v;

    public double calculateDistance(User otherUser) {
        return this.getAddress().getGeolocation().calculateDistance(otherUser.getAddress().getGeolocation());
    }
}
