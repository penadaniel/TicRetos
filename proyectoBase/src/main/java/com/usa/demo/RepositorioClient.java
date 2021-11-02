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
public class RepositorioClient implements Serializable{
    @Autowired
    private InterfaceClient crud1;
    
    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
        
    }
    public Optional<Client> getClient(int id){
        return crud1.findById(id);
    }
    public Client save(Client client){
        return crud1.save(client);
    }
    public void delete(Client client){
        crud1.delete(client);
    }
    
}
