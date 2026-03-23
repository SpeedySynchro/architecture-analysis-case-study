package com.mariage.springpetclinic.service;

import com.mariage.springpetclinic.model.Owner;
import com.mariage.springpetclinic.util.Helper;
import org.springframework.stereotype.Service;
import com.mariage.springpetclinic.repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final AuditService auditService;

    public OwnerService(OwnerRepository ownerRepository, AuditService auditService) {
        this.ownerRepository = ownerRepository;
        this.auditService = auditService;
    }

    public List<Owner> getAllOwners() {
        Helper.log("fetching owners");  // dépendance inutile
        auditService.logAccess();
        return List.of(
                new Owner(1L, "Alice"),
                new Owner(2L, "Bob")
        );
    }

    public String internalStatus() {
        return "owner-service-ok";
    }
}