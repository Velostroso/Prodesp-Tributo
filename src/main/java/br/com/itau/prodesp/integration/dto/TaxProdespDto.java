package br.com.itau.prodesp.integration.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TaxProdespDto(
    BigDecimal amount,
    String type,
    LocalDateTime dueDate
) {
}
