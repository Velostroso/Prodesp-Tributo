package br.com.itau.prodesp.model;

import br.com.itau.prodesp.exception.TaxTypeNotFoundException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Tributo {
  private TributoTipo tipo;
  private BigDecimal valor;
  private LocalDate dueDate;

  public Tributo(TributoTipo tipo, BigDecimal valor, LocalDate dueDate) {
    this.tipo = tipo;
    this.valor = valor;
    this.dueDate = dueDate;
  }

  public Tributo(String tipo, BigDecimal valor, LocalDate dueDate) {
    TributoTipo tipoTributo;
    try {
      tipoTributo = TributoTipo.valueOf(tipo);
    } catch (IllegalArgumentException e) {
      throw new TaxTypeNotFoundException(e.getMessage());
    }
    this.tipo = tipoTributo;
    this.valor = valor;
    this.dueDate = dueDate;
  }

}
