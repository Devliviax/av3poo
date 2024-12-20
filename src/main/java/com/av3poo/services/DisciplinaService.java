package com.av3poo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.av3poo.models.Disciplina;
import com.av3poo.repositories.DisciplinaRepository;
import com.av3poo.services.exceptions.DataBindingViolationException;
import com.av3poo.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina findById(Long id) {
        Disciplina disciplina = this.disciplinaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Disciplina não encontrada! Id: " + id + ", Tipo: " + Disciplina.class.getName()
        ));

        return disciplina;
    }

    public List<Disciplina> findAll(){
        
        List<Disciplina> disciplinas = this.disciplinaRepository.findAll();
        return disciplinas;
    }

    @Transactional
    public Disciplina create(Disciplina obj) {
        obj.setId(null);
        obj = this.disciplinaRepository.save(obj);
        return obj;
    }

    @Transactional
    public Disciplina update(Disciplina obj) {
        Disciplina newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setCargaHoraria(obj.getCargaHoraria());
        newObj.setProfessor(obj.getProfessor());
        return this.disciplinaRepository.save(newObj);
    }

    public void delete(Long id) {
        
        findById(id);
        try{
            this.disciplinaRepository.deleteById(id);
        } catch(Exception e) {
            throw new DataBindingViolationException("Não é possivel excluir devido a entidades relacionadas!");
        }
 
    }

    


}
