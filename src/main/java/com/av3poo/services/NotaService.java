package com.av3poo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.av3poo.models.Nota;
import com.av3poo.repositories.NotaRepository;
import com.av3poo.services.exceptions.DataBindingViolationException;
import com.av3poo.services.exceptions.ObjectNotFoundException;

@Service
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;

    public Nota findById(Long id) {

        Nota nota = this.notaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
            "Cliente não encontrado! Id: " + id + ", Tipo: " + Nota.class.getName()
    ));

    return nota;

    }

    public List<Nota> findAll(){
        
        List<Nota> notas = this.notaRepository.findAll();
        return notas;
    }

    public List<Nota> findAllById(Long id){
        
        List<Nota> notas = this.notaRepository.findAllByAluno_id(id);
        return notas;
    }

    @Transactional
    public Nota create(Nota obj) {

        obj.setId(null);
        obj = this.notaRepository.save(obj);
        return obj;

    }

    @Transactional
    public Nota update(Nota obj){

        Nota newObj = findById(obj.getId());
        newObj.setAluno(obj.getAluno());
        newObj.setDataAvaliacao(obj.getDataAvaliacao());
        newObj.setDisciplina(obj.getDisciplina());
        newObj.setValor(obj.getValor());
        return this.notaRepository.save(newObj);

    }

    public void delete(Long id){
        findById(id);
        try {
            this.notaRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataBindingViolationException("Não é possível excluir devido a entidades relacionadas");
        }
    }
    

}
