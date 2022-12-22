package com.springsecurityfirstproject.services.ServicesImpl;

import com.springsecurityfirstproject.dao.ProduitDao;
import com.springsecurityfirstproject.entities.Produit;
import com.springsecurityfirstproject.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProduitService implements ServiceInterface<Produit> {
    Produit produit=new Produit();
    @Autowired
    private ProduitDao produitDao;
    @Override
    public Produit save(Produit produit) {
        String produitName=produit.getName();
        Integer produitQuantité=produit.getQuantitie();
        Produit prod=produitDao.save(produit);
        if(prod==null){
            System.out.println("product error");
        }else if(produitName.isEmpty() || produitQuantité<=0){
            System.out.println("tu peux pas ajouter un produit sans nom ou sans quantité");
        }
        return prod;
    }

    @Override
    public void delete(Long id) {
        Optional<Produit> produit1=produitDao.findById(id);
        if(produit1.isPresent()){
            produitDao.deleteById(id);
        }else{
            System.out.println("id not found");
        }
    }

    @Override
    public Produit update(Produit produit, Long id) {
        Produit existingProduct=produitDao.findById(id).get();
        if(Objects.nonNull(produit.getName()) && !"".equalsIgnoreCase(produit.getName())){
            existingProduct.setName(produit.getName());
        }
        if (Objects.nonNull(produit.getQuantitie())) {
            existingProduct.setQuantitie(produit.getQuantitie());
        }

        if (Objects.nonNull(produit.getCategorie()) && !"".equalsIgnoreCase(produit.getCategorie())){
            existingProduct.setCategorie(produit.getCategorie());
        }

        return produitDao.save(existingProduct);
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }
}
