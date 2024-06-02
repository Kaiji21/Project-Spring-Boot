package com.ELHAIBA.project_spring_boot.Repository;

import com.ELHAIBA.project_spring_boot.Model.Entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Integer> {
}
