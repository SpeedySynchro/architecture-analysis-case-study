package com.mariage.springpetclinic.architecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class ArchitectureTest {

    private final JavaClasses importedClasses =
            new ClassFileImporter().importPackages("com.mariage.springpetclinic");

    @Test
    void controllers_should_not_access_repositories_directly() {
        noClasses()
                .that().resideInAPackage("..controller..")
                .should().dependOnClassesThat().resideInAPackage("..repository..")
                .check(importedClasses);
    }

    @Test
    void services_should_not_depend_on_each_other_cyclically() {
        noClasses()
                .that().haveSimpleName("AuditService")
                .should().dependOnClassesThat().haveSimpleName("OwnerService")
                .check(importedClasses);
    }
}