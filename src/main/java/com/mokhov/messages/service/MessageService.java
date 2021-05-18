package com.mokhov.messages.service;

import com.mokhov.messages.model.dto.MessageByRecipientDTO;
import com.mokhov.messages.model.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MessageService {
    Message save(Message message);

    List<MessageByRecipientDTO> getMessagesByRecipient(Long id);
}
