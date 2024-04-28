package com.SeConnecterInscription.compte.Dto;

public class UtilisateurDTO {
    private Integer utilisateurId;
    private String pseudo;
    private String email;
    private String motDePasse;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(Integer utilisateurId, String pseudo, String email, String motDePasse) {
        this.utilisateurId = utilisateurId;
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;

    }

    public Integer getUtilisateurId() {
        return utilisateurId;
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


    public void setUtilisateurId(Integer utilisateurId) {
        utilisateurId = utilisateurId;
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

}
