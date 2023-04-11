package pl.openx.project.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Cart {
    public int id;
    public int userId;
    public LocalDateTime date;

    @SerializedName("products")
    public List<ProductInfo> productInfos;
    public int __v;
}
