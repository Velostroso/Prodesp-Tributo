package br.com.itau.prodesp.resources.dto;

import br.com.itau.prodesp.model.Tributo;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class TributoResponse implements Serializable {

  private List<Tributo> tributo;

  @Serial
  private static final long serialVersionUID = 1L;

  public TributoResponse(List<Tributo> tributo) {
    this.tributo = tributo;
  }

  public void setTributo(List<Tributo> tributo) {
    this.tributo = tributo;
  }

  public List<Tributo> getTributo() {
    return tributo;
  }
}
