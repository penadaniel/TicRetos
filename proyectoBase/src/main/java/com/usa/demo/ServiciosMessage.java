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
public class ServiciosMessage implements Serializable{
    @Autowired
    private RepositorioMessage metodosCrud;
    
    public List<Message> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }
    
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(!evt.isPresent()){
            return metodosCrud.save(message);
            }else{
                return message;
            }
        
        
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evt= metodosCrud.getMessage(message.getIdMessage());
            if(evt.isPresent()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
