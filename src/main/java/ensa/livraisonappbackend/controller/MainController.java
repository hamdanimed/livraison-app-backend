package ensa.livraisonappbackend.controller;

import ensa.livraisonappbackend.entity.Paiement;
import ensa.livraisonappbackend.entity.ProductShipment;
import ensa.livraisonappbackend.entity.Shipment;
import ensa.livraisonappbackend.entity.ShipmentType;
import ensa.livraisonappbackend.repository.PaiementRepository;
import ensa.livraisonappbackend.repository.ProductShipmentRepositroy;
import ensa.livraisonappbackend.repository.ShipmentRepository;
import ensa.livraisonappbackend.repository.ShipmentTypeRepository;
import ensa.livraisonappbackend.service.FakeDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
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

    @PostConstruct
    public void init(){
        fakeDataService.loadData();
    }

    @GetMapping("/shipment-list")
    private List<Shipment> getShipment(){

        return shipmentRepository.findAll();
    }

    @GetMapping("/shipment-type")
    private List<ShipmentType> getShipmentType(){

        return shipmentTypeRepository.findAll();
    }

    @GetMapping("/product-shipment")
    private List<ProductShipment> getProductShipment(){
        return productShipmentRepositroy.findAll();
    }
    @GetMapping("/product-shipment/shipment-{id}")
    private List<ProductShipment> getProductShipmentByShipmentId(@PathVariable(value = "id") Long id){
        return productShipmentRepositroy.findByShipmentId(id);
    }
    @GetMapping("/product-shipment/product-{id}")
    private List<ProductShipment> getProductShipmentByProductId(@PathVariable(value = "id") Long id){
        return productShipmentRepositroy.findByProductId(id);
    }

    @GetMapping("/paiement")
    private List<Paiement> getPaiements(){
        return paiementRepository.findAll();
    }
}
