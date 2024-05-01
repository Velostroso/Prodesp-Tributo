package br.com.itau.prodesp.service;

import br.com.itau.prodesp.integration.ProdespIntegration;
import br.com.itau.prodesp.model.Tributo;
import br.com.itau.prodesp.model.TributoTipo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TributoServiceTest {

  @Mock
  private ProdespIntegration prodespIntegration;

  @InjectMocks
  private TributoService tributoService;

  @Test
  public void testGetTributoPorTipo() {
    // Arrange
    List<String> tipos = Arrays.asList(TributoTipo.IPVA.toString(), TributoTipo.MULTAS.toString());
    List<Tributo> tributosFromProdesp = Arrays.asList(
        new Tributo(TributoTipo.IPVA.toString(), BigDecimal.valueOf(100), LocalDate.now()),
        new Tributo(TributoTipo.MULTAS.toString(), BigDecimal.valueOf(200), LocalDate.now())
    );
    when(prodespIntegration.getTributos(tipos)).thenReturn(tributosFromProdesp);

    // Act
    List<Tributo> result = tributoService.getTributoPorTipo(tipos);

    // Assert
    assertEquals(2, result.size());
    assertEquals(TributoTipo.IPVA, result.get(0).getTipo());
    assertEquals(TributoTipo.MULTAS, result.get(1).getTipo());

    // Verify that prodespIntegration.getTributos was called with correct arguments
    verify(prodespIntegration, times(1)).getTributos(tipos);
  }
}