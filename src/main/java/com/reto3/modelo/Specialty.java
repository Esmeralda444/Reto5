package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialty")
public class Specialty {
    /**
     * Atributo id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSpecialty", nullable = false)
    private Integer id;
    /**
     * Atributo Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo Description
     */
    @Column(name = "description")
    private String description;
    /**
     * Relación uno a muchos de la tabla Car
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "specialty")
    @JsonIgnoreProperties("specialty")
    private List<Doctor> doctors;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    
}
