package br.com.itau.prodesp.integration.dto;

import java.util.List;

public record TaxProdespResponseDto(
    List<TaxProdespDto> tax
) {
}
