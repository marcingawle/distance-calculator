package pl.openx.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MaxCartInfo {
    private BigDecimal price;
    private String userName;
}
