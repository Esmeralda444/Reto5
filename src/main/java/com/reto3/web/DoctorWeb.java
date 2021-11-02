package com.reto3.web;

import com.reto3.modelo.Doctor;
import com.reto3.service.DoctorApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Doctor/")
public class DoctorWeb {
    /**
     * Inicializamos el Api Doctor
     */
    @Autowired
    private DoctorApi doctorApi;

    /**
     * Método para obtener los doctores por URL
     * @return
     */
    @GetMapping("all")
    public List<Doctor> getDoctor(){
        return doctorApi.getAll();
    }

    /**
     * Método para obtener un doctor por id desde URL
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int id){
        return doctorApi.getDoctor(id);
    }

    /**
     * Método para agregar un carro desde URL
     * @param doctor
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor){
        return doctorApi.save(doctor);
    }

   @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor){
        return doctorApi.update(doctor);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return doctorApi.delete(id);
    }
}
