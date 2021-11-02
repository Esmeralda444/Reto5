package com.reto3.service;

import com.reto3.modelo.Doctor;
import com.reto3.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorApi {
    /**
     * Inicializamos el repositorio
     */
    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Método para obtener todos los doctores del repositorio
     * @return
     */
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    /**
     * Método para obtener un carro por id
     * @param id
     * @return
     */
    public Optional<Doctor> getDoctor(int id){
        return doctorRepository.getDoctor(id);
    }

    /**
     * Método para agregar un doctor
     * @param doctor
     * @return
     */
    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return doctorRepository.save(doctor);
        }else{
            Optional<Doctor> evt = doctorRepository.getDoctor(doctor.getId());
            if(evt.isEmpty()){
                return doctorRepository.save(doctor);
            }else{
                return doctor;
            }
        }
    }

    /**
     * Método para actualizar doctor
     * @param doctor
     * @return
     */
    public Doctor update(Doctor doctor){
        if (doctor.getId() != null){
            Optional<Doctor> actualizar = doctorRepository.getDoctor(doctor.getId());
            if (!actualizar.isEmpty()){
                if (doctor.getName() != null){
                actualizar.get().setName(doctor.getName());
                }
                if (doctor.getDepartment() != null){
                    actualizar.get().setDepartment(doctor.getDepartment());
                }
                if (doctor.getYear() != 0){
                    actualizar.get().setYear(doctor.getYear());
                }
                if (doctor.getDescription() != null){
                    actualizar.get().setDescription(doctor.getDescription());
                }
                doctorRepository.save(actualizar.get());
                return actualizar.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }

    /**
     * Método para eliminar un doctor
     * @param id
     * @return
     */
    public boolean delete(int id){
        return getDoctor(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
    }
}
