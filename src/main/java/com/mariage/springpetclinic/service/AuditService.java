package com.mariage.springpetclinic.service;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    
    private  final OwnerService ownerService;

    public AuditService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void logAccess() {
        System.out.println("Audit: " + ownerService.internalStatus());
    }
}
