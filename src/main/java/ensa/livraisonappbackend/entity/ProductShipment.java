package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ProductShipment {
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
    @ManyToOne @JsonManagedReference @JsonIgnore
    private Shipment shipment;
    @ManyToOne @JsonManagedReference
    private Product product;
}
