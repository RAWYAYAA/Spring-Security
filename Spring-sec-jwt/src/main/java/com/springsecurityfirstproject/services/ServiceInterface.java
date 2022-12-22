package com.springsecurityfirstproject.services;

import com.springsecurityfirstproject.entities.Produit;

import java.util.List;

public interface ServiceInterface<T> {
    T save(T t);
    void delete(Long id);

    Produit update(Produit produit, Long id);

    List<T> findAll();
}
