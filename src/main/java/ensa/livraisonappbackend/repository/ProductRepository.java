package ensa.livraisonappbackend.repository;

import ensa.livraisonappbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
