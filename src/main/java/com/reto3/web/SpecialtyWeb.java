package com.reto3.web;

import com.reto3.modelo.Specialty;
import com.reto3.service.SpecialtyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Specialty/")
public class SpecialtyWeb {
    /**
     * Inicializamos Api Especialidad
     */
    @Autowired
    private SpecialtyApi specialtyApi;

    /**
     * Método para obtener todas las especialidades por URL
     * @return
     */
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Specialty> getAll(){
        return specialtyApi.getAll();
    }

    /**
     * Método para obtener una especialidad por su id desde URL
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int id){
        return specialtyApi.getSpecialty(id);
    }

    /**
     * Método para agregar una especialidad por URL
     * @param specialty
     * @return
     */
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty){
        return specialtyApi.save(specialty);
    }


    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty){
        return specialtyApi.update(specialty);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return specialtyApi.delete(id);
    }
}
