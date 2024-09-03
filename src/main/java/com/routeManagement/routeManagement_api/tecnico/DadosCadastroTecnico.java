package com.routeManagement.routeManagement_api.tecnico;

import com.routeManagement.routeManagement_api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTecnico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        Setor setor,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
