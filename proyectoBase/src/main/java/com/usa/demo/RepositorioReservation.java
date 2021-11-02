/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public class RepositorioReservation implements Serializable{
    @Autowired
    private InterfaceReservation crud3;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud3.findAll();
    }
    public Optional <Reservation> getReservation(int id){
        return crud3.findById(id);
    }
    
    public Reservation save(Reservation reservations){
        return crud3.save(reservations);
    }
    public void delete(Reservation reservations){
        crud3.delete(reservations);
    }
   
    public List<Reservation> ReservacionStatusRepositorio (String status){
         return crud3.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crud3.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorClient> getRepositorioClient(){
         List<ContadorClient> res = new ArrayList<>();
         List<Object[]> report = crud3.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
    
}
