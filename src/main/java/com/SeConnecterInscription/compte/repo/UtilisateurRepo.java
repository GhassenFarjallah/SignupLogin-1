package com.SeConnecterInscription.compte.repo;

import com.SeConnecterInscription.compte.modèle.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, String> {
    Optional<Utilisateur> findOneByEmailAndMotDePasse(String email, String motDePasse);

    Utilisateur findByEmail(String email);
}
