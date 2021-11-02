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
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class Repositorio implements Serializable{
    @Autowired
    private InterfaceDoctor crud;
    
    public List<Doctor> getAll(){
        return (List<Doctor>) crud.findAll();
        
    }
    public Optional<Doctor> getDoctor(int id){
        return crud.findById(id);
    }
    public Doctor save(Doctor doctor){
        return crud.save(doctor);
    }
    public void delete(Doctor doctor){
        crud.delete(doctor);
    }
    
}
