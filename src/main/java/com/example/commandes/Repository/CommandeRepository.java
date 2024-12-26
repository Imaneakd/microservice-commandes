package com.example.commandes.Repository;

import com.example.commandes.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByDateAfter(Date date);
}