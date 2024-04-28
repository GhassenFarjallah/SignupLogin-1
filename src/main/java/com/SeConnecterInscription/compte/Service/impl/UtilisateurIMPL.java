package com.SeConnecterInscription.compte.Service.impl;

import com.SeConnecterInscription.compte.Dto.UtilisateurDTO;
import com.SeConnecterInscription.compte.Service.UtilisateurService;
import com.SeConnecterInscription.compte.modèle.Utilisateur;
import com.SeConnecterInscription.compte.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UtilisateurIMPL implements UtilisateurService {
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Override
    public String addUtilisateur(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = new Utilisateur(

                utilisateurDTO.getUtilisateurId(),
                utilisateurDTO.getPseudo(),
                utilisateurDTO.getEmail(),
                hashPassword(utilisateurDTO.getMotDePasse())
        );

        utilisateurRepo.save(utilisateur);

        return utilisateur.getPseudo();
    }

    // Utility method to hash a password
    private String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    @Override
    public String findUtilisateurByEmail(String email) {
        Utilisateur utilisateur = utilisateurRepo.findByEmail(email);
        if (utilisateur != null) {
                return utilisateur.getPseudo();
        }
        return "";
    }

    @Override
    public String findUtilisateurByEmailAndPassword(String email, String password) {
        // Fetch the user by email
        Utilisateur utilisateur = utilisateurRepo.findByEmail(email);

        // Check if the user exists and the password matches
        if (utilisateur != null && checkPassword(password, utilisateur.getMotDePasse())) {
            return utilisateur.getPseudo(); // or return utilisateur to return the whole user object
        }

        // Return null or throw an exception if authentication fails
        return null; // Return null or you could throw an AuthenticationException
    }

    // Utility method to check the plaintext password against the hashed password stored in the database
    private boolean checkPassword(String plainPassword, String hashedPassword) {
        // This is a placeholder: use actual password hashing library/method to verify password
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }


}
