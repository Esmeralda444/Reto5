package com.reto3.repository.crud;

import com.reto3.modelo.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor,Integer> {
}
