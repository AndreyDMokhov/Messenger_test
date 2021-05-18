package com.mokhov.messages.reposirory;

import com.mokhov.messages.model.entity.Message;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, ObjectId> {
    List<Message> findAllByRecipientId(Long id);


}
