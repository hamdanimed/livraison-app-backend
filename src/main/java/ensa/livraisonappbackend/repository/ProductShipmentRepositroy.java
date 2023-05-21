package ensa.livraisonappbackend.repository;

import ensa.livraisonappbackend.entity.ProductShipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductShipmentRepositroy extends JpaRepository<ProductShipment,Long> {
    List<ProductShipment> findByShipmentCode(String code);
    List<ProductShipment> findByProductCode(String code);
}
