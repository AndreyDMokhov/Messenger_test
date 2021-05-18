package com.mokhov.messages.contoller;

import com.mokhov.messages.model.dto.MessageByRecipientDTO;
import com.mokhov.messages.model.entity.Message;
import com.mokhov.messages.reposirory.MessageRepository;
import com.mokhov.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private MessageService messageService;

    public MessageRepository messageRepository;

    @GetMapping("/user/{id}/messages")
    public List<MessageByRecipientDTO> getMessagesByRecipient(@PathVariable Long id) {
        return messageService.getMessagesByRecipient(id);
    }


    @MessageMapping("/chat")
    public void procMessage(@Payload Message message) {
        messageService.save(message);
        messagingTemplate.convertAndSendToUser(
                message.getRecipientId().toString(),
                "/messages",
                message
        );
    }
}
