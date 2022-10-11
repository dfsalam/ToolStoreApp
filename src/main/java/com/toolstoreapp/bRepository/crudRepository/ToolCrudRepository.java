package com.toolstoreapp.bRepository.crudRepository;


import com.toolstoreapp.aEntities.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolCrudRepository extends CrudRepository<Tool,Integer> {
}
