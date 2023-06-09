package ensa.livraisonappbackend.repository;

import ensa.livraisonappbackend.entity.Shipment;
import ensa.livraisonappbackend.entity.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentTypeRepository extends JpaRepository<ShipmentType,Long> {
    ShipmentType findByCode(String shipmentType);
}
