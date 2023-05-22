package ensa.livraisonappbackend.repository;

import ensa.livraisonappbackend.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
    Shipment findByCode(String code);
}
