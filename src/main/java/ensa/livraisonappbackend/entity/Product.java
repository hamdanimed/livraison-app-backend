package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue @JsonBackReference
    private Long id;
    private String code;
    private String name;
    private Integer quantity;
    private Double price;
    private String img_url;
    @ManyToOne @JsonManagedReference
    private Category category;
    @OneToMany @JsonBackReference
    private List<ProductShipment> productShipmentList;
}
