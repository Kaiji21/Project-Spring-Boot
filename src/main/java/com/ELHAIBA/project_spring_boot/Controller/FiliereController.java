package com.ELHAIBA.project_spring_boot.Controller;

import com.ELHAIBA.project_spring_boot.Model.Entity.Filiere;
import com.ELHAIBA.project_spring_boot.Repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filieres")
public class FiliereController {

    @Autowired
    private FiliereRepository filiereRepository;

    @GetMapping()
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable int id) {
        Optional<Filiere> filiere = filiereRepository.findById(id);
        if (filiere.isPresent()) {
            return ResponseEntity.ok(filiere.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable int id, @RequestBody Filiere filiereDetails) {
        Optional<Filiere> filiere = filiereRepository.findById(id);
        if (filiere.isPresent()) {
            Filiere updatedFiliere = filiere.get();
            updatedFiliere.setNom(filiereDetails.getNom());
            return ResponseEntity.ok(filiereRepository.save(updatedFiliere));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFiliere(@PathVariable int id) {
        Optional<Filiere> filiere = filiereRepository.findById(id);
        if (filiere.isPresent()) {
            filiereRepository.delete(filiere.get());
            return ResponseEntity.ok("Filiere deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}