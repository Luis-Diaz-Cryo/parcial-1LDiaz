package unisababa.edu.co.Patrones_parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unisababa.edu.co.Patrones_parcial.entity.Messages;
import unisababa.edu.co.Patrones_parcial.repository.MessageRepository;
import java.util.List;
@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public  MessageService(MessageRepository repository){
        this.repository = repository;
    }


    public Messages guardarMessage(Messages messages) {

        return repository.save(messages);
    }

    public List<Messages> consultarMessages() {
        return repository.findAll();
    }

    public void clearAllMessages() {
        repository.deleteAll();
    }





}
