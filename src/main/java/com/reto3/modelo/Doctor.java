package com.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Esme
 */
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    /**
     * Atributo id del doctor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoctor", nullable = false)
    private Integer id;
    /**
     * Atributo nombre del doctor
     */
    @Column(name = "name")
    private String name;
    /**
     * Atributo department del doctor
     */
    @Column(name = "department")
    private String department;
    /**
     * Atributo Año del doctor
     */
    @Column(name = "year")
    private int year;
    /**
     * Atributo descripción del doctor
     */
    @Column(name = "description")
    private String description;

    /**
     * Relación Muchos a uno tabla Specialty
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("doctors")
    private Specialty specialty;
    /**
     * Relación uno a muchos tabla mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<Message> messages;
    /**
     * Relación uno a muchos tabla reservaciones
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "doctor")
    @JsonIgnoreProperties("doctor")
    private List<Reservation> reservations;

    //Métodos getter y setter

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

   
}
