package com.example.commandes.controller;

import com.example.commandes.Repository.CommandeRepository;
import com.example.commandes.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping
    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Commande getCommande(@PathVariable Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setId(id);
            return commandeRepository.save(commande);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
    }
}
