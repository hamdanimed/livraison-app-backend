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
public class ShipmentType {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private Double price;
    private String description;
    @OneToMany @JsonBackReference
    private List<Shipment> shipmentList;
}
