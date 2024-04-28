package com.SeConnecterInscription.compte.Service;

import com.SeConnecterInscription.compte.Dto.UtilisateurDTO;
import org.springframework.http.ResponseEntity;

public interface UtilisateurService {
    String addUtilisateur(UtilisateurDTO utilisateurDTO);

    String findUtilisateurByEmail(String email);
    String findUtilisateurByEmailAndPassword(String email,String password);
}
