import { Component } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-readerdashboard',
  templateUrl: './readerdashboard.component.html',
  styleUrls: ['./readerdashboard.component.css']
})
export class ReaderdashboardComponent {

  user =new TokenStorageService();

uname=this.user.getUser().username;
urole= this.user.getUser().roles[0];
actualrole=this.urole.substring(5,11);



}
