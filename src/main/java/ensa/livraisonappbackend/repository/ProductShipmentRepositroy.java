package ensa.livraisonappbackend.repository;

import ensa.livraisonappbackend.entity.ProductShipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductShipmentRepositroy extends JpaRepository<ProductShipment,Long> {
    List<ProductShipment> findByShipmentId(Long id);
    List<ProductShipment> findByProductId(Long id);
}
