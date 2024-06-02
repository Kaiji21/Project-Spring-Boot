package com.ELHAIBA.project_spring_boot.Model.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules;

}