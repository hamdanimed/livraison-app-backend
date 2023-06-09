package ensa.livraisonappbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paiement {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private Double productsTotal;
    private Double discountValue;
    private Double shipmentPrice;
    @OneToOne @JsonBackReference
    private Shipment shipment;
}
