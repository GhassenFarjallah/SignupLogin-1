package com.SeConnecterInscription.compte.controlleur;

import com.SeConnecterInscription.compte.Dto.UtilisateurDTO;
import com.SeConnecterInscription.compte.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurControleur {
    @Autowired
    private UtilisateurService utilisateurService;
    @PostMapping(path="/save")
    public ResponseEntity<?> saveUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO){
        String name = utilisateurService.addUtilisateur(utilisateurDTO);
        return ResponseEntity.ok(utilisateurService);
    }

    @PostMapping(path="/connexion")
    public ResponseEntity<?> connecterUtilisateur(@RequestParam String email, @RequestParam String motDePasse){
        String pseudo = utilisateurService.findUtilisateurByEmail(email);
        if (pseudo != null){
            return ResponseEntity.ok(pseudo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found or incorrect password.");
    };
}
