package br.com.itau.prodesp.resources;

import br.com.itau.prodesp.resources.dto.TributoResponse;
import br.com.itau.prodesp.service.TributoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tributo")
@RequiredArgsConstructor
public class TributoController {

  private final TributoService tributoService;

  @GetMapping
  public ResponseEntity<TributoResponse> consultarTributosPendentes(@RequestParam("tipo") List<String> tipos) {
    var tributos = tributoService.getTributoPorTipo(tipos);
    if (tributos != null && !tributos.isEmpty()) {
      return new ResponseEntity<>(new TributoResponse(tributoService.getTributoPorTipo(tipos)), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
