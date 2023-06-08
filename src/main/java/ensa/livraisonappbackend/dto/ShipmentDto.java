package ensa.livraisonappbackend.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@Builder
public class ShipmentDto {

    private String code;
    private String fname;
    private String lname;
    private String tel;
    private String address;
    private String city;
    private String postalCode;
    private String zip;
    private String status;
    private List<ProductDto> products;

    private Long shipmentType;

    private PaiementDto paiement;


}