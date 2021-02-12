package com.mifel.service.saldo.adapters.web;

import com.mifel.service.saldo.adapters.web.dto.GetCuotaRequestDto;
import com.mifel.service.saldo.application.port.in.GetCuotaUseCase;
import com.mifel.service.saldo.domain.model.CuotaMonetaria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"getCuota"})
@RestController
@RequiredArgsConstructor
public class GetCuotaController {

  private final GetCuotaUseCase getCuotaUseCase;

  @ApiOperation(
      value = "Obtener la cuota monetaria",
      nickname = "getCuota",
      tags = {
        "getCuota"
      },
      response = CuotaMonetaria.class)
  @RequestMapping(
      value = "/cuota-monetaria",
      method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CuotaMonetaria> getCuota(
      @ApiParam(value = "")
      @RequestBody GetCuotaRequestDto request
  ) {

    CuotaMonetaria cuotaMonetaria = getCuotaUseCase.get(request.getOrigen(), request.getDestino(), request.getValor());

    return ResponseEntity.ok(cuotaMonetaria);
  }
}
