package com.ELHAIBA.project_spring_boot.Model.Entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ManyToMany
    @JoinTable(
            name = "interventions",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

}