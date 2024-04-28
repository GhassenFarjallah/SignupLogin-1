package com.SeConnecterInscription.compte.modèle;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="UtilisateurId")
    private Integer UtilisateurId;
    private String pseudo;
    @Column(name="email")
    private String email;
    @Column(name="motDePasse")
    private String motDePasse;

    public void setUtilisateurId(Integer utilisateurId) {
        UtilisateurId = utilisateurId;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getUtilisateurId() {
        return UtilisateurId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }



    public Utilisateur(Integer utilisateurId, String pseudo, String email, String motDePasse) {
        UtilisateurId = utilisateurId;
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;
    }
}
