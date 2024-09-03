package com.routeManagement.routeManagement_api.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVeiculo(
        @NotBlank
        String modelo,

        @NotNull
        Marca marca,

        @NotBlank
        String placa) {
}
