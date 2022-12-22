package com.springsecurityfirstproject.dao;

import com.springsecurityfirstproject.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit,Long> {

       /* List<Produit> findByProductName(String name);
        long countByProductName(String name);*/
}
