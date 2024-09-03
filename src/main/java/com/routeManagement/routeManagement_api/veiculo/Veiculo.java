package com.routeManagement.routeManagement_api.veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="veiculos")
@Entity(name="Veiculo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    @Enumerated(EnumType.STRING)
    private Marca marca;
    private String placa;
    private Boolean ativo;

    public Veiculo(DadosCadastroVeiculo dados){
        this.ativo = true;
        this.modelo = dados.modelo();
        this.placa = dados.placa();;
        this.marca = dados.marca();
    }


    public void atualizarInformacoes(DadosAtualizacaoVeiculo dados) {
        if (dados.placa() != null) {
            this.placa = dados.placa();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
