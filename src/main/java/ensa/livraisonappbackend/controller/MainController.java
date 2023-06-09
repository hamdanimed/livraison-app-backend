package ensa.livraisonappbackend.controller;

import ensa.livraisonappbackend.dto.ProductDto;
import ensa.livraisonappbackend.dto.ShipmentDto;
import ensa.livraisonappbackend.entity.*;
import ensa.livraisonappbackend.repository.*;
import ensa.livraisonappbackend.service.FakeDataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final
    FakeDataService fakeDataService;
    private final ShipmentRepository shipmentRepository;
    private final ShipmentTypeRepository shipmentTypeRepository;
    private final ProductShipmentRepositroy productShipmentRepositroy;
    private final PaiementRepository paiementRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final List<ProductShipmentRepositroy> productShipmentRepositroyList;


    @PostConstruct
    public void init(){
        fakeDataService.loadData();
    }

    @GetMapping("/categories")
    private List<Category> getCategories(){ return categoryRepository.findAll();}

    @GetMapping("/products")
    private List<Product> getProducts(){ return productRepository.findAll();}

    @GetMapping("/shipment-types")
    private List<ShipmentType> getShipmentTypes(){ return shipmentTypeRepository.findAll();}

//    @GetMapping("/shipments")
//    private List<Shipment> getShipment(){ return shipmentRepository.findAll();}

    @GetMapping("/shipments/{code}")
    private Shipment getShipment(@PathVariable("code") String code){
        return shipmentRepository.findByCode(code);
    }
    @PostMapping("/shipments/add")
    public ResponseEntity<Shipment> createShipment(
            @RequestBody ShipmentDto dto
            ) {
        System.out.println(dto);
        // Create a new shipment object
        Shipment shipment = new Shipment();
        shipment.setCode(dto.getCode());
        shipment.setFname(dto.getFname());
        shipment.setLname(dto.getLname());
        shipment.setTel(dto.getTel());
        shipment.setAddress(dto.getAddress());
        shipment.setCity(dto.getCity());
        shipment.setPostalCode(dto.getPostalCode());
        shipment.setEmail(dto.getEmail());
        shipment.setZip(dto.getZip());
        //shipment.setOrderDate(LocalDateTime.now());
        shipment.setStatus(dto.getStatus());
        shipment.setShipmentType(
                shipmentTypeRepository
                        .findById(dto.getShipmentType())
                        .orElse(null)
        );

        // Retrieve the product shipments by product IDs

        Shipment shipmentFinal = shipmentRepository.save(shipment);

        List<ProductShipment> productShipmentList = dto.getProducts().stream().map(
                productDto -> {
                    Product product = productRepository.findById(productDto.getId()).orElse(null);
                    if (product != null) {
                        ProductShipment productShipment = new ProductShipment();
                        productShipment.setProduct(product);
                        productShipment.setQuantity(productDto.getQuantity());
                        productShipment.setShipment(shipmentFinal);
                        return productShipment;
                    }
                    return null;
                }
        ).filter(Objects::nonNull).toList();


        productShipmentRepositroy.saveAll(productShipmentList);

        shipmentFinal.setProductShipmentList(productShipmentList);

        Paiement paiement = Paiement.builder()
                .code(dto.getPaiement().getCode())
                .productsTotal(dto.getPaiement().getProductsTotal())
                .discountValue(dto.getPaiement().getDiscountValue())
                .shipmentPrice(dto.getPaiement().getShipmentPrice())
                .shipment(shipmentFinal)
                .build();

        paiementRepository.save(paiement);

        shipmentFinal.setPaiement(paiement);

        return ResponseEntity.ok(
                shipmentFinal
        );
    }


//    @GetMapping("/product-shipments")
//    private List<ProductShipment> getProductShipment(){
//        return productShipmentRepositroy.findAll();
//    }
//    @GetMapping("/product-shipments/shipment-{code}")
//    private List<ProductShipment> getProductShipmentByShipmentId(@PathVariable(value = "code") String code){
//        return productShipmentRepositroy.findByShipmentCode(code);
//    }
//    @GetMapping("/product-shipments/product-{code}")
//    private List<ProductShipment> getProductShipmentByProductId(@PathVariable(value = "code") String code){
//        return productShipmentRepositroy.findByProductCode(code);
//    }
//    @GetMapping("/paiements")
//    private List<Paiement> getPaiements(){
//        return paiementRepository.findAll();
//    }
}
