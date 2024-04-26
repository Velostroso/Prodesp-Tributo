package br.com.itau.prodesp;

import java.util.List;

public class TributoResponse {

    private List<Tributo> tributo;

    private static final long serialVersionUID = 1L;

    public TributoResponse(List<Tributo> tributo) {
        this.tributo = tributo;
    }

    public void setTributo (List<Tributo> tributo) {
        this.tributo = tributo;
    }

    public List<Tributo> getTributo() {
        return tributo;
    }
}
