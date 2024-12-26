package com.example.commandes.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer quantite;  // Utilisation d'Integer pour permettre la valeur nulle

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private BigDecimal montant;  // Utilisation de BigDecimal pour gérer les montants avec précision

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
