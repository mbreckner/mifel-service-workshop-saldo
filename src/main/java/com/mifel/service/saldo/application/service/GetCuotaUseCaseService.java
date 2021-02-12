package com.mifel.service.saldo.application.service;

import com.mifel.service.saldo.application.port.in.GetCuotaUseCase;
import com.mifel.service.saldo.application.port.out.LoadCuotaPort;
import com.mifel.service.saldo.domain.model.CuotaMonetaria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCuotaUseCaseService implements GetCuotaUseCase {

  private final LoadCuotaPort loadCuotaPort;

  @Override
  public CuotaMonetaria get(String origen, String destino, String valor) {
    return loadCuotaPort.load(origen, destino, valor);
  }
}
