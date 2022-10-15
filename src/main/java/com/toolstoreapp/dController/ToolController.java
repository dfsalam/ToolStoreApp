package com.toolstoreapp.dController;


import com.toolstoreapp.aEntities.Category;
import com.toolstoreapp.aEntities.Tool;
import com.toolstoreapp.cService.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*", allowedHeaders ="*")
@RequestMapping("/api/Tool")
public class ToolController {

    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Tool> getById(@PathVariable("id") int id){
        return toolService.getTool(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save(@RequestBody  Tool p){
        return toolService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool p){
        return toolService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return toolService.delete(id);
    }



}
