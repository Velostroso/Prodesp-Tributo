package br.com.itau.prodesp.exception;

public class TaxTypeNotFoundException extends RuntimeException {
  public TaxTypeNotFoundException() {
  }

  public TaxTypeNotFoundException(String message) {
    super(message);
  }
}
