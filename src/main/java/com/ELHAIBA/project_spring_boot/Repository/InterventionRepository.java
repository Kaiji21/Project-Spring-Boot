package com.ELHAIBA.project_spring_boot.Repository;

import com.ELHAIBA.project_spring_boot.Model.Entity.Intervention;
import com.ELHAIBA.project_spring_boot.Model.Entity.InterventionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, InterventionPK> {
}
