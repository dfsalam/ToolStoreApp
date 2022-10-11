package com.toolstoreapp.bRepository.crudRepository;

import com.toolstoreapp.aEntities.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
