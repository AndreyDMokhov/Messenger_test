package com.mokhov.messages.service;

import com.mokhov.messages.model.dto.MessageByRecipientDTO;
import com.mokhov.messages.model.entity.Message;
import com.mokhov.messages.reposirory.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public Message save(Message message) {
        messageRepository.save(message);
        return message;
    }

    @Override
    public List<MessageByRecipientDTO> getMessagesByRecipient(Long id) {
        List<Message> allByRecipientId = messageRepository.findAllByRecipientId(id);
        return allByRecipientId.stream()
                .map(m -> MessageByRecipientDTO.builder()
                        .senderId(m.getSenderId())
                        .recipientId(m.getRecipientId())
                        .messageContent(m.getMessageContent())
                        .build())
                .collect(Collectors.toList());
    }


}
