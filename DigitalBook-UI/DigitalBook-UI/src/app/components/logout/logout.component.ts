import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router,private tokenStorage: TokenStorageService){

  }
 // user =new TokenStorageService();
  ngOnInit(): void {
    
      this.tokenStorage.signOut();
    this.router.navigate(['home']);
  }

 
}
