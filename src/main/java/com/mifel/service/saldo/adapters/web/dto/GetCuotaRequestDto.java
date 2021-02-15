package com.mifel.service.saldo.adapters.web.dto;

import com.mifel.service.saldo.adapters.web.ValidMoneda;
import com.modyo.ms.commons.core.dtos.Dto;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetCuotaRequestDto extends Dto {

    @ValidMoneda private String origen;
    @ValidMoneda private String destino;
    @NotNull private String valor;

}
