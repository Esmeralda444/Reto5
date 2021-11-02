package com.reto3.repository;

import com.reto3.modelo.Specialty;
import com.reto3.repository.crud.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {
    /**
     * Atributo Repositorio Specialty
     */
    @Autowired
    private SpecialtyCrudRepository crudRepository;

    /**
     * Método para obtener todas las especialidades del repositorio
     * @return
     */
    public List<Specialty> getAll(){
        return (List<Specialty>) crudRepository.findAll();
    }

    /**
     * Método para buscar una especialidad por id
     * @param id
     * @return
     */
    public Optional<Specialty> getSpecialty(int id){
        return crudRepository.findById(id);
    }

    /**
     * Método para agregar una especialidad
     * @param specialty
     * @return
     */
    public Specialty save(Specialty specialty){
        return crudRepository.save(specialty);
    }

    /**
     * Método para eliminar una Especialidad
     * @param specialty
     */
    public void delete(Specialty specialty){
        crudRepository.delete(specialty);
    }
}
