package com.av3poo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.av3poo.models.Professor;
import com.av3poo.repositories.ProfessorRepository;
import com.av3poo.services.exceptions.DataBindingViolationException;
import com.av3poo.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor findById(Long id) {
        Professor professor = this.professorRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Professor não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()
        ));

        return professor;
    }

    public List<Professor> findAll(){
        
        List<Professor> professores = this.professorRepository.findAll();
        return professores;
    }

    @Transactional
    public Professor create(Professor obj) {

        obj.setId(null);
        obj = this.professorRepository.save(obj);
        return obj;

    }

    @Transactional
    public Professor update(Professor obj) {

        Professor newObj = findById(obj.getId());
        newObj.setDisciplinaPrincipal(obj.getDisciplinaPrincipal());
        newObj.setEmail(obj.getEmail());
        newObj.setNome(obj.getNome());
        return this.professorRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try {
            this.professorRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir devido a entidades relacionadas");
        }
    }

}
