package unisababa.edu.co.Patrones_parcial.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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


    @CircuitBreaker(name = "messageService", fallbackMethod = "fallbackGuardarMessage")
    public Messages guardarMessage(Messages messages) {

        return repository.save(messages);
    }
    @CircuitBreaker(name = "messageService", fallbackMethod = "fallbackConsultarMessages")
    public List<Messages> consultarMessages() {
        return repository.findAll();
    }

    @CircuitBreaker(name = "messageService", fallbackMethod = "fallbackClearAllMessages")
    public void clearAllMessages() {
        repository.deleteAll();
    }

    public Messages fallbackGuardarMessage(Messages messages, Throwable t) {
        System.err.println("Error occurred while saving message: " + t.getMessage());
        Messages fallbackMessage = new Messages();
        fallbackMessage.setMessage("Default message content due to fallback");

        return fallbackMessage;
    }
    public List<Messages> fallbackConsultarMessages(Throwable t) {
        System.err.println("Error occurred while fetching messages: " + t.getMessage());
        return List.of();
    }
    public void fallbackClearAllMessages(Throwable t) {
        System.err.println("Error occurred while clearing messages: " + t.getMessage());
    }






}
