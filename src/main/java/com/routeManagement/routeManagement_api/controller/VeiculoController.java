package com.routeManagement.routeManagement_api.controller;

import com.routeManagement.routeManagement_api.veiculo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroVeiculo dados) {
        repository.save(new Veiculo(dados));
    }

    @GetMapping
    public Page<DadosListagemVeiculo> listar(@PageableDefault(size = 10, sort = {"modelo"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemVeiculo::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoVeiculo dados){
        var veiculo = repository.getReferenceById(dados.id());
        veiculo.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var veiculo = repository.getReferenceById(id);
        veiculo.excluir();
    }

}
