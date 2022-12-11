import { Component } from '@angular/core';
import { JwtResponse } from 'src/app/jwt-response.model';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-authordashboard',
  templateUrl: './authordashboard.component.html',
  styleUrls: ['./authordashboard.component.css']
})
export class AuthordashboardComponent {

  user =new TokenStorageService();

  uname=this.user.getUser().username;
  urole= this.user.getUser().roles[0];
  actualrole=this.urole.substring(5,11);
  
}
