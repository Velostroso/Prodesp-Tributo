package br.com.itau.prodesp.integration;

import br.com.itau.prodesp.integration.dto.TaxProdespResponseDto;
import br.com.itau.prodesp.model.Tributo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProdespIntegration {

  private final WebClient webClient;

  @Value("${api.prodesp.tributo-path}")
  private String tributoPath;

  private Mono<TaxProdespResponseDto> getResponse(List<String> tributos) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .path(tributoPath)
            .queryParam("tipo", tributos)
            .build()
        )
        .accept(MediaType.APPLICATION_JSON)
        .exchangeToMono(res -> {
          if (res.statusCode().is2xxSuccessful()) {
            return res.bodyToMono(TaxProdespResponseDto.class);
          }
          return res.createError();
        });
  }

  public List<Tributo> getTributos(List<String> tributos) {
    TaxProdespResponseDto dtoTributoList = this.getResponse(tributos).block();
    Objects.requireNonNull(dtoTributoList);
    return dtoTributoList
        .tax().stream().map(dto -> new Tributo(dto.type(), dto.amount(), dto.dueDate().toLocalDate())).toList();
  }

}
