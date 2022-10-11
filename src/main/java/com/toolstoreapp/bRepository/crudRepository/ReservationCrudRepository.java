package com.toolstoreapp.bRepository.crudRepository;

import com.toolstoreapp.aEntities.Reservation;
import org.springframework.data.repository.CrudRepository;
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
