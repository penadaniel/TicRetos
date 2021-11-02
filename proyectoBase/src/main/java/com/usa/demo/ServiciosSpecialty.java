/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class ServiciosSpecialty implements Serializable{
    @Autowired
    private RepositorioSpecialty metodosCrud;
    
    public List<Specialty> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Specialty> getSpecialty(int idSpecialty){
        return metodosCrud.getSpecialty(idSpecialty);
    }
    
    
    public Specialty save(Specialty specialty){
        if(specialty.getId()==null){
            return metodosCrud.save(specialty);
        }else{
            Optional<Specialty> evt=metodosCrud.getSpecialty(specialty.getId());
            if(!evt.isPresent()){
            return metodosCrud.save(specialty);
            }else{
                return specialty;
            }
        
        
        }
    }
    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty>evt=metodosCrud.getSpecialty(specialty.getId());
            if(evt.isPresent()){
                if(specialty.getDescription()!=null){
                    evt.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    evt.get().setName(specialty.getName());
                }
                return metodosCrud.save(evt.get());
            }
        }
        return specialty;
    }
    public boolean deleteSpecialty(int id){
        Boolean dBoolean=getSpecialty(id).map(specialty -> {
            metodosCrud.delete(specialty);
            return true;
        }).orElse(false);
        return dBoolean;
    }
    
}
