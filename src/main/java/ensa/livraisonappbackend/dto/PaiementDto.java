package ensa.livraisonappbackend.dto;

import lombok.Data;

@Data
public class PaiementDto {
    private long id;
    private String code;
    private Double productsTotal;
    private Double discountValue;
    private Double shipmentPrice;
}
