package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue @JsonBackReference
    private Long id;
    private String code;
    private String fname;
    private String lname;
    private String tel;
    private String address;
    private String city;
    private String postalCode;
    private String zip;
    @CreationTimestamp
    private LocalDateTime orderDate;
    private String status;
    @ManyToOne @JsonManagedReference
    private ShipmentType shipmentType;
    @OneToMany(mappedBy = "shipment")
    private List<ProductShipment> productShipmentList;
    @OneToOne @JsonBackReference
    private Paiement paiement;
    @OneToMany @JsonBackReference
    private List<ShipmentUpdate> shipmentUpdateList;

}
