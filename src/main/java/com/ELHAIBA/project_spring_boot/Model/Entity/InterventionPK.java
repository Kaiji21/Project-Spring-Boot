package com.ELHAIBA.project_spring_boot.Model.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InterventionPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "enseignant_id", insertable = false, updatable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    private Module module;


}
