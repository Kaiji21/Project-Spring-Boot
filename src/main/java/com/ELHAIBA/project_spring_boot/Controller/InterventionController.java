package com.ELHAIBA.project_spring_boot.Controller;

import com.ELHAIBA.project_spring_boot.Model.Entity.Enseignant;
import com.ELHAIBA.project_spring_boot.Model.Entity.Intervention;
import com.ELHAIBA.project_spring_boot.Model.Entity.InterventionPK;
import com.ELHAIBA.project_spring_boot.Model.Entity.Module;
import com.ELHAIBA.project_spring_boot.Repository.EnseignantRepository;
import com.ELHAIBA.project_spring_boot.Repository.InterventionRepository;
import com.ELHAIBA.project_spring_boot.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interventions")
public class InterventionController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping
    public List<Intervention> getAllInterventions() {
        return interventionRepository.findAll();
    }

    @GetMapping("/{enseignantId}/{moduleId}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable int enseignantId, @PathVariable int moduleId) {
        Optional<Enseignant> enseignantOptional = enseignantRepository.findById(enseignantId);
        Optional<Module> moduleOptional = moduleRepository.findById(moduleId);

        if (enseignantOptional.isPresent() && moduleOptional.isPresent()) {
            Enseignant enseignant = enseignantOptional.get();
            Module module = moduleOptional.get();

            InterventionPK interventionPK = new InterventionPK();
            interventionPK.setEnseignant(enseignant);
            interventionPK.setModule(module);

            Optional<Intervention> intervention = interventionRepository.findById(interventionPK);

            if (intervention.isPresent()) {
                return ResponseEntity.ok(intervention.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Intervention createIntervention(@RequestBody Intervention intervention) {
        return interventionRepository.save(intervention);
    }

    @PutMapping("/{enseignantId}/{moduleId}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable int enseignantId, @PathVariable int moduleId, @RequestBody Intervention interventionDetails) {
        Optional<Enseignant> enseignantOptional = enseignantRepository.findById(enseignantId);
        Optional<Module> moduleOptional = moduleRepository.findById(moduleId);

        if (enseignantOptional.isPresent() && moduleOptional.isPresent()) {
            Enseignant enseignant = enseignantOptional.get();
            Module module = moduleOptional.get();

            InterventionPK interventionPK = new InterventionPK();
            interventionPK.setEnseignant(enseignant);
            interventionPK.setModule(module);

            Optional<Intervention> intervention = interventionRepository.findById(interventionPK);

            if (intervention.isPresent()) {
                Intervention updatedIntervention = intervention.get();
                updatedIntervention.setIntitule(interventionDetails.getIntitule());
                updatedIntervention.setVhCoursIntervenu(interventionDetails.getVhCoursIntervenu());
                updatedIntervention.setVhTDIntervenu(interventionDetails.getVhTDIntervenu());
                updatedIntervention.setVhTPIntervenu(interventionDetails.getVhTPIntervenu());
                updatedIntervention.setEvaluationIntervenu(interventionDetails.getEvaluationIntervenu());
                return ResponseEntity.ok(interventionRepository.save(updatedIntervention));
            } else {
                return ResponseEntity.notFound().build();
            }

        }
        else {
            return ResponseEntity.notFound().build();
        }


    }

    @DeleteMapping("/{enseignantId}/{moduleId}")
    public ResponseEntity<String> deleteIntervention(@PathVariable int enseignantId, @PathVariable int moduleId) {
        Optional<Enseignant> enseignantOptional = enseignantRepository.findById(enseignantId);
        Optional<Module> moduleOptional = moduleRepository.findById(moduleId);

        if (enseignantOptional.isPresent() && moduleOptional.isPresent()) {
            Enseignant enseignant = enseignantOptional.get();
            Module module = moduleOptional.get();

            InterventionPK interventionPK = new InterventionPK();
            interventionPK.setEnseignant(enseignant);
            interventionPK.setModule(module);

            Optional<Intervention> intervention = interventionRepository.findById(interventionPK);

            if (intervention.isPresent()) {
                interventionRepository.delete(intervention.get());
                return ResponseEntity.ok("Intervention deleted successfully.");
            } else {
                return ResponseEntity.notFound().build();
            }

        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}