package com.mifel.service.saldo.adapters.web.dto;

import com.modyo.ms.commons.core.dtos.Dto;
import lombok.Data;

@Data
public class GetCuotaRequestDto extends Dto {

    private String origen;
    private String destino;
    private String valor;

}
