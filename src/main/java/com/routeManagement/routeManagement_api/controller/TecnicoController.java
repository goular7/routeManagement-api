package com.routeManagement.routeManagement_api.controller;

import com.routeManagement.routeManagement_api.tecnico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroTecnico dados) {
        repository.save(new Tecnico(dados));
    }

    @GetMapping
    public Page<DadosListagemTecnico> listar(@PageableDefault(size =10, sort = {"nome"})Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemTecnico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTecnico dados) {
        var tecnico = repository.getReferenceById(dados.id());
        tecnico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var tecnico = repository.getReferenceById(id);
        tecnico.excluir();
    }


}
