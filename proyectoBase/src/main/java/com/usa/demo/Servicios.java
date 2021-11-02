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
public class Servicios implements Serializable{
    @Autowired
    private Repositorio metodosCrud;
    
    public List<Doctor> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Doctor> getDoctor(int idDoctor){
        return metodosCrud.getDoctor(idDoctor);
    }
    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return metodosCrud.save(doctor);
        }else{
            Optional<Doctor> evt=metodosCrud.getDoctor(doctor.getId());
            if(!evt.isPresent()){
                return metodosCrud.save(doctor);
            }else{
            return doctor;
            }
        }
    }
    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> evt=metodosCrud.getDoctor(doctor.getId());
            if(evt.isPresent()){
                if(doctor.getName()!=null){
                    evt.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    evt.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    evt.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    evt.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    evt.get().setSpecialty(doctor.getSpecialty());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }


    public boolean deleteDoctor(int IdDoctor) {
        Boolean aBoolean = getDoctor(IdDoctor).map(doctor -> {
            metodosCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

//Integer.valueOf(x); // fails if x is null
//Optional.ofNullable(Integer.valueOf(x)).orElse(null); // NullPointerException