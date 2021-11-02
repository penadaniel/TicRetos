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
public class RepositorioMessage implements Serializable{
    @Autowired
    private InterfaceMessage crud2;
    
    public List<Message> getAll(){
        return (List<Message>) crud2.findAll();
    }
    public Optional <Message> getMessage(int id){
        return crud2.findById(id);
    }
    
    public Message save(Message message){
        return crud2.save(message);
    }
    public void delete(Message message){
        crud2.delete(message);
    }
}
