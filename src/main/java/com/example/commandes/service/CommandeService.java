package com.example.commandes.service;

import com.example.commandes.Repository.CommandeRepository;
import com.example.commandes.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getCommandes(int lastDays) {
        Date dateLimite = new Date(System.currentTimeMillis() - (lastDays * 24 * 60 * 60 * 1000L));
        return commandeRepository.findByDateAfter(dateLimite);
    }

    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande getCommande(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}
