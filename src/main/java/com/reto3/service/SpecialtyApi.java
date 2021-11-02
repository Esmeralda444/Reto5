package com.reto3.service;
import com.reto3.modelo.Specialty;
import com.reto3.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyApi {
    /**
     * Inicializamos el repositorio Especialidad
     */
    @Autowired
    private SpecialtyRepository specialtyRepository;

    /**
     * Método para obtener todas las especialidades del repositorio
     * @return
     */
    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }

    /**
     * Método para obtener una gama por id
     * @param id
     * @return
     */
    public Optional<Specialty> getSpecialty(int id){
        return specialtyRepository.getSpecialty(id);
    }

    /**
     * Método para agregar una especialidad
     * @param specialty
     * @return
     */
    public Specialty save(Specialty specialty){
        if(specialty.getId()==null){
            return specialtyRepository.save(specialty);
        }else{
            Optional<Specialty> evt=specialtyRepository.getSpecialty(specialty.getId());
            if(evt.isEmpty()){
                return specialtyRepository.save(specialty);
            }else{
                return specialty;
            }
        }
    }

    /**
     * Método para actualizar una Especialidad
     * @param specialty
     * @return
     */
    public Specialty update(Specialty specialty){
        if (specialty.getId() != null){
            Optional<Specialty> evnt = specialtyRepository.getSpecialty(specialty.getId());
            if (!evnt.isEmpty()){
                if (specialty.getName() != null){
                    evnt.get().setName(specialty.getName());
                }if (specialty.getDescription() != null){
                    evnt.get().setDescription(specialty.getDescription());
                }
                specialtyRepository.save(evnt.get());
                return evnt.get();
            }else{
                return specialty;
            }
        }else{
            return specialty;
        }
    }

    /**
     * Método para eliminar una Especialidad
     * @param id
     * @return
     */
    public boolean delete(int id){
        Boolean flag = getSpecialty(id).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return flag;
    }
}
