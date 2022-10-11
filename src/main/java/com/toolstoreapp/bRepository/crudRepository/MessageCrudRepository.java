package com.toolstoreapp.bRepository.crudRepository;


import com.toolstoreapp.aEntities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
