package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue @JsonBackReference
    private Long id;
    private String code;
    private String name;
    @OneToMany @JsonBackReference
    private List<Product> product;
}
