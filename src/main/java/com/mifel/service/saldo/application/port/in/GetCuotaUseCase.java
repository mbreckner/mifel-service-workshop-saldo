package com.mifel.service.saldo.application.port.in;

import com.mifel.service.saldo.domain.model.CuotaMonetaria;

public interface GetCuotaUseCase {

  CuotaMonetaria get(String origen, String destino, String valor);

}
