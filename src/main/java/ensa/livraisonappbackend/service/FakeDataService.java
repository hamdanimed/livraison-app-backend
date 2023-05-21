package ensa.livraisonappbackend.service;

import ensa.livraisonappbackend.entity.*;
import ensa.livraisonappbackend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FakeDataService {
    private CategoryRepository categoryRepository;
    private PaiementRepository paiementRepository;
    private ProductRepository productRepository;
    private ProductShipmentRepositroy productShipmentRepositroy;
    private ShipmentRepository shipmentRepository;
    private ShipmentTypeRepository shipmentTypeRepository;
    private ShipmentUpdateRepository shipmentUpdateRepository;

    public void loadData(){
        Product product1=new Product(null,"1","adidas t-shirt",30,30.00,"https://placehold.co/400",null,null);
        Product product2=new Product(null,"2","lacost polo",10,20.00,"https://placehold.co/400",null,null);
        Product product3=new Product(null,"3","nike pants red",10,15.00,"https://placehold.co/400",null,null);
        Product product4=new Product(null,"4","samsung galaxy s21",10,15.00,"https://placehold.co/400",null,null);
        Product product5=new Product(null,"5","LG OLED TV 55 pouces",10,15.00,"https://placehold.co/400",null,null);
        productRepository.saveAllAndFlush(List.of(product1,product2,product3,product4,product5));

        Category category1=new Category(null,"1","vetement & chaussures",List.of(product1,product2,product3));
        Category category2=new Category(null,"3","telephone & tablette",List.of(product4));
        Category category3=new Category(null,"2","tv & hi tech",List.of(product5));
        categoryRepository.saveAllAndFlush(List.of(category1,category2,category3));

        product1.setCategory(category1);
        product2.setCategory(category1);
        product3.setCategory(category1);
        product4.setCategory(category2);
        product5.setCategory(category3);
        productRepository.saveAllAndFlush(List.of(product1,product2,product3,product4,product5));

        Shipment shipment1=new Shipment(null,"001","Mohamed","Hamdani","0676158822","Anza,Agadir","Agadir","80000","800",new Date(2023,04,1),"order processed",null,null,null,null);
        Shipment shipment2=new Shipment(null,"002","Hamza","Elgarai","0600158822","Mhamid,Marrakech","Marrakech","10000","310",new Date(2023,04,2),"order shipped",null,null,null,null);
        shipmentRepository.saveAllAndFlush(List.of(shipment1,shipment2));

        ShipmentType shipmentType1=new ShipmentType(null,"S-001","express delivery",50.00,null);
        ShipmentType shipmentType2=new ShipmentType(null,"S-002","post office",20.00,null);
        ShipmentType shipmentType3=new ShipmentType(null,"S-003","self pick-up",10.00,null);

        shipmentType1.setShipmentList(List.of(shipment1));
        shipmentType2.setShipmentList(List.of(shipment2));
        shipmentTypeRepository.saveAllAndFlush(List.of(shipmentType1,shipmentType2,shipmentType3));

        shipment1.setShipmentType(shipmentType1);
        shipment2.setShipmentType(shipmentType2);
        shipmentRepository.saveAllAndFlush(List.of(shipment1,shipment2));

        ProductShipment productShipment1=new ProductShipment(null,2,shipment1,product1);
        ProductShipment productShipment2=new ProductShipment(null,1,shipment1,product3);
        ProductShipment productShipment3=new ProductShipment(null,1,shipment1,product4);
        ProductShipment productShipment4=new ProductShipment(null,1,shipment2,product5);
        ProductShipment productShipment5=new ProductShipment(null,1,shipment2,product1);
        productShipmentRepositroy.saveAllAndFlush(List.of(productShipment1,productShipment2,productShipment3,productShipment4,productShipment5));

        product1.setProductShipmentList(List.of(productShipment1,productShipment5));
        product3.setProductShipmentList(List.of(productShipment2));
        product4.setProductShipmentList(List.of(productShipment3));
        product5.setProductShipmentList(List.of(productShipment4));
        productRepository.saveAllAndFlush(List.of(product1,product2,product3,product4,product5));

        shipment1.setProductShipmentList(List.of(productShipment1,productShipment2,productShipment3));
        shipment2.setProductShipmentList(List.of(productShipment4,productShipment5));
        shipmentRepository.saveAll(List.of(shipment1,shipment2));

        Paiement paiement1=new Paiement(null,"000001",90.0,0.0,50.00,shipment1);
        Paiement paiement2=new Paiement(null,"000002",45.0,0.0,20.00,shipment2);
        paiementRepository.saveAllAndFlush(List.of(paiement1,paiement2));

        shipment1.setPaiement(paiement1);
        shipment2.setPaiement(paiement2);
        shipmentRepository.saveAllAndFlush(List.of(shipment1,shipment2));

        //shipment 1
        ShipmentUpdate shipmentUpdate1=new ShipmentUpdate(null,"001","Casablanca",new Date(2023,04,2),"order shipped",shipment1);
        ShipmentUpdate shipmentUpdate2=new ShipmentUpdate(null,"002","Casablanca",new Date(2023,04,2),"order en route",shipment1);
        ShipmentUpdate shipmentUpdate3=new ShipmentUpdate(null,"003","Casablanca",new Date(2023,04,4),"order en arrived",shipment1);
        //shipment 2
        ShipmentUpdate shipmentUpdate4=new ShipmentUpdate(null,"004","Casablanca",new Date(2023,04,4),"order en shipped",shipment2);
        ShipmentUpdate shipmentUpdate5=new ShipmentUpdate(null,"004","Casablanca",new Date(2023,04,8),"order en route",shipment2);
        ShipmentUpdate shipmentUpdate6=new ShipmentUpdate(null,"003","Casablanca",new Date(2023,04,22),"order en arrived",shipment2);
        shipmentUpdateRepository.saveAllAndFlush(List.of(shipmentUpdate1,shipmentUpdate2,shipmentUpdate3,shipmentUpdate4,shipmentUpdate5,shipmentUpdate6));

        shipment1.setShipmentUpdateList(List.of(shipmentUpdate1,shipmentUpdate2,shipmentUpdate3));
        shipment2.setShipmentUpdateList(List.of(shipmentUpdate4,shipmentUpdate5,shipmentUpdate6));
        shipmentRepository.saveAllAndFlush(List.of(shipment1,shipment2));
    }
}
