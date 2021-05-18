package com.mokhov.messages.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@Builder
public class MessageByRecipientDTO {

    private Long senderId;
    private Long recipientId;
    private String messageContent;
}
