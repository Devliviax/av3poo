package com.av3poo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;
import com.av3poo.models.Turma;
import com.av3poo.services.TurmaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id) {
        Turma obj = this.turmaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/turmas")
    public ResponseEntity<List<Turma>> findAllTurmas() {
        List<Turma> objs = this.turmaService.findAll();
        return ResponseEntity.ok().body(objs);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Void> create(@Valid @RequestBody Turma obj) {

        Turma aluno = this.turmaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Void> update(@Valid @RequestBody Turma obj, @PathVariable Long id) {

        obj.setId(id);
        this.turmaService.update(obj);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.turmaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
