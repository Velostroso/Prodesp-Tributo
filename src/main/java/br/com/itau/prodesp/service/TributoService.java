package br.com.itau.prodesp.service;


import br.com.itau.prodesp.integration.ProdespIntegration;
import br.com.itau.prodesp.model.Tributo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TributoService {

  private final ProdespIntegration prodespIntegration;

  public List<Tributo> getTributoPorTipo(List<String> tipos) {
    log.info("getting tax by types {}", tipos.toString());
    List<Tributo> tributos = prodespIntegration.getTributos(tipos);
    return tributos.stream().filter(t -> tipos.contains(t.getTipo().toString())).toList();
  }
}
