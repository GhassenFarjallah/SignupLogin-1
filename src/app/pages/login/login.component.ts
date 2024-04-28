import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../user';
import { RegisterService } from '../../register.service';
import { UtilisateurInscrit } from '../../utilisateur-inscrit';
import { SeconnecterService } from '../../seconnecter.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  user:User = new User();
  utilisateurInscrit:UtilisateurInscrit = new UtilisateurInscrit();
  isSignDivVisiable: boolean  = true;

  constructor(private registerService:RegisterService,private seconnecterService:SeconnecterService){}
  ngOnInit(): void {
      
  }


  //Inscription Utilisateur 
  userRegister(){
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data =>{
      alert("utilisateur est inscrit avec succés")
    },error => {
      console.error('Registration error:', error);
      alert("Désolé l'utilisateur ne peut pas s'inscrire");
    }
  );
  }


  //connexion utilisateur Inscrit
  Seconnecter() {
    if (this.utilisateurInscrit.email && typeof this.utilisateurInscrit.email === 'string') {
      console.log(this.utilisateurInscrit.email.toLowerCase());
    } else {
      console.log('Email is not defined or not a string');
    }
    console.log("Email before request:", this.utilisateurInscrit.email);
    if (this.utilisateurInscrit.email) {
      this.utilisateurInscrit.email = this.utilisateurInscrit.email.toLowerCase(); // Safe to call toLowerCase
    }
    console.log("Sending request with:", this.utilisateurInscrit);
    this.seconnecterService.connexionUtilisateurInscrit(this.utilisateurInscrit).subscribe(data => {
      alert("utilisateurInscrit est connecté avec succés");
    }, error => {
      console.error('Error during login:', error);
      alert("Entrer email et Mot de passe correcte");
    });
  }
  



}


