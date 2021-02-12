package com.mifel.service.saldo.domain.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CuotaMonetaria {

  private final LocalDateTime fecha;
  private final String moneda;
  private final String valor;

}
