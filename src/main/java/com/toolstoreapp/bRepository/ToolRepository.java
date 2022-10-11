package com.toolstoreapp.bRepository;


import com.toolstoreapp.aEntities.Tool;
import com.toolstoreapp.bRepository.crudRepository.ToolCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository {
    @Autowired
    private ToolCrudRepository toolCrudRepository;

    public List<Tool> getAll(){
        return (List<Tool>) toolCrudRepository.findAll();
    }

    public Optional<Tool> getTool(int id){
        return toolCrudRepository.findById(id);
    }
    public Tool save(Tool c){
        return toolCrudRepository.save(c);
    }
    public void delete(Tool c){
        toolCrudRepository.delete(c);
    }

}
