package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentUpdate {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String location;
    private Date updateDate;
    private String status;
    @ManyToOne @JsonBackReference
    private Shipment shipment;
}
