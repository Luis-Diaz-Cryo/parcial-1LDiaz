package unisababa.edu.co.Patrones_parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisababa.edu.co.Patrones_parcial.entity.Message;
import unisababa.edu.co.Patrones_parcial.repository.MessageRepository;
import java.util.List;
@Service
public class MessageService {

    private final MessageRepository repository;

    @Autowired
    public  MessageService(MessageRepository repository){
        this.repository = repository;
    }


    public Message guardarMessage(Message message) {

        return repository.save(message);
    }

    public List<Message> consultarMessages() {
        return repository.findAll();
    }

    public void clearAllMessages() {
        repository.deleteAll();
    }





}
