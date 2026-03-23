package com.mariage.springpetclinic.repository;

import com.mariage.springpetclinic.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository {

    public List<Owner> findAll() {
        return List.of(
                new Owner(1L, "Alice"),
                new Owner(2L, "Bob")
        );
    }
}