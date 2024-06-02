package com.ELHAIBA.project_spring_boot.Model.Entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "interventions")
@AssociationOverrides({
        @AssociationOverride(name = "pk.enseignant", joinColumns = @JoinColumn(name = "enseignant_id")),
        @AssociationOverride(name = "pk.module", joinColumns = @JoinColumn(name = "module_id"))
})
public class Intervention {
    @EmbeddedId
    private InterventionPK pk = new InterventionPK();

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "vh_cours_intervenu")
    private int vhCoursIntervenu;

    @Column(name = "vh_td_intervenu")
    private int vhTDIntervenu;

    @Column(name = "vh_tp_intervenu")
    private int vhTPIntervenu;

    @Column(name = "evaluation_intervenu")
    private int evaluationIntervenu;


}