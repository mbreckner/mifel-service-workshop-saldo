package com.mifel.service.saldo;

import com.mifel.service.saldo.archunit.HexagonalArchitecture;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;

public class DependencyRuleTests {

  private static final String rootPackageName = "com.mifel.service.saldo";
  private static final String domainPackage = "domain";
  private static final String applicationPackage = "application";
  private static final String adaptersPackage = "adapters";

  @Test
  public void validateRegistrationContextArchitecture() {
    HexagonalArchitecture.boundedContext(rootPackageName)
        .withDomainLayer(domainPackage)
        .withAdaptersLayer(adaptersPackage)
        .incoming("web")
        .outgoing("persistence")
        .outgoing("restclient")
        .and()
        .withApplicationLayer(applicationPackage)
        .services("service")
        .incomingPorts("port.in")
        .outgoingPorts("port.out")
        .and()
        .withConfiguration("configuration")
        .check(new ClassFileImporter()
            .importPackages(rootPackageName));
  }

}
