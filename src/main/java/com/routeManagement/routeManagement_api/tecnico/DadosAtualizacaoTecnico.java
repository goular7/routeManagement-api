package com.routeManagement.routeManagement_api.tecnico;

import com.routeManagement.routeManagement_api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTecnico(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {
}
