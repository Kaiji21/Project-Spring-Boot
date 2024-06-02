package com.ELHAIBA.project_spring_boot.Model.Entity;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;


@Data
@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private int vhCours;
    private int vhTD;
    private int vhTP;
    private int evaluation;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    @ManyToMany(mappedBy = "modules")
    private List<Enseignant> enseignants;

}