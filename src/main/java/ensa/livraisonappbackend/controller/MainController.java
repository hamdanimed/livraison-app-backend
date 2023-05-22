package ensa.livraisonappbackend.controller;

import ensa.livraisonappbackend.entity.*;
import ensa.livraisonappbackend.repository.*;
import ensa.livraisonappbackend.service.FakeDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    FakeDataService fakeDataService;
    @Autowired
    ShipmentRepository shipmentRepository;
    @Autowired
    ShipmentTypeRepository shipmentTypeRepository;
    @Autowired
    ProductShipmentRepositroy productShipmentRepositroy;
    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

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
    private Shipment getShipment(@PathVariable(value = "code") String code){
        return shipmentRepository.findByCode(code);
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
