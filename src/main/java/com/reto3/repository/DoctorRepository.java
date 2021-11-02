package com.reto3.repository;

import com.reto3.modelo.Doctor;
import com.reto3.repository.crud.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    /**
     * Atributo Repositorio Doctor
     */
    @Autowired
    private DoctorCrudRepository crudRepository;

    /**
     * Método para encontrar todos los doctores del repositorio
     * @return
     */
    public List<Doctor> getAll(){
        return (List<Doctor>) crudRepository.findAll();
    }

    /**
     * Método para encontrar un doctor por id
     * @param id
     * @return
     */
    public Optional<Doctor> getDoctor(int id){
        return crudRepository.findById(id);
    }

    /**
     * Método para agregar un doctor nuevo
     * @param doctor
     * @return
     */
    public Doctor save(Doctor doctor){
        return crudRepository.save(doctor);
    }

    /**
     * Método para eliminar un doctor
     * @param doctor
     */
    public void delete(Doctor doctor){
        crudRepository.delete(doctor);
    }
}
