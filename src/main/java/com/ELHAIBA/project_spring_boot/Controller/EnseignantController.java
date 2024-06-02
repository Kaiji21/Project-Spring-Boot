package com.ELHAIBA.project_spring_boot.Controller;

import com.ELHAIBA.project_spring_boot.Model.Entity.Enseignant;
import com.ELHAIBA.project_spring_boot.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enseignant> getEnseignantById(@PathVariable int id) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isPresent()) {
            return ResponseEntity.ok(enseignant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable int id, @RequestBody Enseignant enseignantDetails) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isPresent()) {
            Enseignant updatedEnseignant = enseignant.get();
            updatedEnseignant.setNom(enseignantDetails.getNom());
            updatedEnseignant.setPrenom(enseignantDetails.getPrenom());
            updatedEnseignant.setModules(enseignantDetails.getModules());
            return ResponseEntity.ok(enseignantRepository.save(updatedEnseignant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable int id) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isPresent()) {
            enseignantRepository.delete(enseignant.get());
            return ResponseEntity.ok("Enseignant deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}