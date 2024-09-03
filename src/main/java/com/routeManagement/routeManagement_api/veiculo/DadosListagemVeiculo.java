package com.routeManagement.routeManagement_api.veiculo;

public record DadosListagemVeiculo(String modelo, Marca marca, String placa) {

    public DadosListagemVeiculo(Veiculo veiculo) {
        this(veiculo.getModelo(), veiculo.getMarca(), veiculo.getPlaca());
    }

}
