package com.mifel.service.saldo.adapters.restclient;

import com.mifel.service.saldo.application.port.out.LoadCuotaPort;
import com.mifel.service.saldo.domain.model.CuotaMonetaria;
import com.modyo.ms.commons.core.dtos.Dto;
import com.modyo.ms.commons.http.config.properties.RestProperties;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
@RequiredArgsConstructor
public class CuotaRestclientAdapter implements LoadCuotaPort {

  private final RestTemplate restTemplate;

  @Value("${datasources.web-services.cuota-services.get-cuota.url}") String url;
  @Value("${datasources.web-services.cuota-services.get-cuota.api-key}") String apiKey;

  @Override
  public CuotaMonetaria load(String origen, String destino, String valor) {

    DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
    defaultUriBuilderFactory.setEncodingMode(EncodingMode.NONE);
    restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

    UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(url)
        .queryParam("quantity", valor)
        .queryParam("key", apiKey);

    GetCuotaResponseDto getCuotaResponseDto = restTemplate.getForObject(
        urlBuilder.build().toUriString(),
        GetCuotaResponseDto.class,
        origen, destino
    );

    // https://api.cambio.today/v1/quotes/USD/COP/json?quantity=752&key=7615%7CDd2iv7QjrbHqzSTDg6m75uqn3p~OkG65
    // https://api.cambio.today/v1/quotes/USD/EUR/json?quantity=752&key=7615%7CDd2iv7QjrbHqzSTDg6m75uqn3p~OkG65

    return new CuotaMonetaria(
        getCuotaResponseDto.getResult().getUpdated(),
        getCuotaResponseDto.getResult().getTarget(),
        getCuotaResponseDto.getResult().getAmount()
    );


  }

  @Data
  public static class GetCuotaResponseDto extends Dto {

    private GetCuotaResultDto result;
    private String status;
  }

  @Data
  public static class GetCuotaResultDto extends Dto {
    private LocalDateTime updated;
    private String source;
    private String target;
    private String value;
    private String quantity;
    private String amount;
  }
}
