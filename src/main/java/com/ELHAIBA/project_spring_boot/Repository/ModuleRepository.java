package com.ELHAIBA.project_spring_boot.Repository;

import com.ELHAIBA.project_spring_boot.Model.Entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Integer> {
}
