package com.routeManagement.routeManagement_api.veiculo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVeiculo(
        @NotNull
        Long id,
        String placa) {
}
