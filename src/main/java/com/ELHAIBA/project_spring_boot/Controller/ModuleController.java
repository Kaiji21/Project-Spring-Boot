package com.ELHAIBA.project_spring_boot.Controller;

import com.ELHAIBA.project_spring_boot.Model.Entity.Module;
import com.ELHAIBA.project_spring_boot.Repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable int id) {
        Optional<Module> module = moduleRepository.findById(id);
        if (module.isPresent()) {
            return ResponseEntity.ok(module.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Module createModule(@RequestBody Module module) {
        return moduleRepository.save(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable int id, @RequestBody Module moduleDetails) {
        Optional<Module> module = moduleRepository.findById(id);
        if (module.isPresent()) {
            Module updatedModule = module.get();
            updatedModule.setIntitule(moduleDetails.getIntitule());
            updatedModule.setVhCours(moduleDetails.getVhCours());
            updatedModule.setVhTD(moduleDetails.getVhTD());
            updatedModule.setVhTP(moduleDetails.getVhTP());
            updatedModule.setEvaluation(moduleDetails.getEvaluation());
            updatedModule.setFiliere(moduleDetails.getFiliere());
            updatedModule.setEnseignants(moduleDetails.getEnseignants());
            return ResponseEntity.ok(moduleRepository.save(updatedModule));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable int id) {
        Optional<Module> module = moduleRepository.findById(id);
        if (module.isPresent()) {
            moduleRepository.delete(module.get());
            return ResponseEntity.ok("Module deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}