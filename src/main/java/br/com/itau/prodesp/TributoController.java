package br.com.itau.prodesp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TributoController {


    @GetMapping("/api/prodesp/tributo")
    public ResponseEntity<TributoResponse> consultarTributosPendentes(@RequestParam("tipo") List<String> tipos) {
        List<Tributo> tributos = new ArrayList<>();
        for (String tipo : tipos) {
            double valor = obterValorDoTributo(tipo);
            Tributo tributo = new Tributo(tipo, valor);
            tributos.add(tributo);
        }
        return new ResponseEntity<>(new TributoResponse(tributos), HttpStatus.OK);
    }


    private double obterValorDoTributo(String tipo) {
        switch (tipo) {
            case "IPVA":
                return 12323.123;
            case "DPVAT":
                return 100.0;
            case "Licenciamento":
                return 50.0;
            case "Multas":
                return 200.0;
            default:
                return 0.0;
        }
    }
}
