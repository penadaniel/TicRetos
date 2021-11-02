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
public class ServiciosClient implements Serializable{
    @Autowired
    private RepositorioClient metodosCrud;
    
    public List<Client> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }
    
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(!evt.isPresent()){
            return metodosCrud.save(client);
            }else{
                return client;
            }
        
        
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evt= metodosCrud.getClient(client.getIdClient());
            if(evt.isPresent()){
                if(client.getName()!=null){
                    evt.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evt.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int idClient) {
        Boolean aBoolean = getClient(idClient).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
