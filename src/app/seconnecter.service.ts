import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UtilisateurInscrit } from './utilisateur-inscrit';
import { Observable } from 'rxjs';
import { User } from './user';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class SeconnecterService {
  private baseurl="http://localhost:8087/connexion"

  constructor(private httpClient: HttpClient  ) { }

  connexionUtilisateurInscrit(utilisateurInscrit: UtilisateurInscrit ):Observable<object>{
    console.log(utilisateurInscrit);
    return this.httpClient.post(`${this.baseurl}`,utilisateurInscrit,httpOptions);
  }
} 
