package pl.openx.project.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Geolocation{
    private static final double EARTH_RADIUS = 6371.01; //Kilometers
    public double lat;
    @SerializedName("long")
    public double mylong;

    public  double calculateDistance(Geolocation geo1) {
        double lat1 = Math.toRadians(geo1.getLat());
        double lon1 = Math.toRadians(geo1.getMylong());
        double lat2 = Math.toRadians(this.getLat());
        double lon2 = Math.toRadians(this.getLat());
        return EARTH_RADIUS * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));
    }
}