package unisababa.edu.co.Patrones_parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unisababa.edu.co.Patrones_parcial.entity.Messages;

import unisababa.edu.co.Patrones_parcial.service.MessageService;

import java.util.List;

@RestController
@CrossOrigin("http://34.69.139.36:30170/")
public class MessageController {
    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping("/save/message")
    public ResponseEntity<Messages> guardarMessage(@RequestBody Messages messages) {
        Messages newMessage = service.guardarMessage(messages);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Messages>> consultarMessages() {
        List<Messages> messages = service.consultarMessages();
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }

    @DeleteMapping("/clear/messages")
    public ResponseEntity<Void> clearAllMessages() {
        service.clearAllMessages();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
