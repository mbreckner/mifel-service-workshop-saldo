package com.mifel.service.saldo.application.port.out;

import com.mifel.service.saldo.domain.model.CuotaMonetaria;

public interface LoadCuotaPort {

  CuotaMonetaria load(String origen, String destino, String valor);

}
