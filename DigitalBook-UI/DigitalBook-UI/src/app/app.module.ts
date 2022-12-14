import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';

import {HttpClientModule} from '@angular/common/http'
import { RegistrationService } from './registration.service';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './header/header/header.component';
import { LoginComponent } from './components/login/login.component';

import { AuthordashboardComponent } from './components/authordashboard/authordashboard.component';
import { ReaderdashboardComponent } from './components/readerdashboard/readerdashboard.component';
import { LogoutComponent } from './components/logout/logout.component';
import { CreatebookComponent } from './components/createbook/createbook.component';
import { UpdatebookComponent } from './components/updatebook/updatebook.component';
import { BlockorunblockComponent } from './components/blockorunblock/blockorunblock.component';
import { BooksubscribeComponent } from './components/booksubscribe/booksubscribe.component';
import { ViewallsubscribedbookComponent } from './components/viewallsubscribedbook/viewallsubscribedbook.component';
import { CancelsubscriptionComponent } from './cancelsubscription/cancelsubscription.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
   
    AuthordashboardComponent,
        ReaderdashboardComponent,
        LogoutComponent,
        CreatebookComponent,
        UpdatebookComponent,
        BlockorunblockComponent,
        BooksubscribeComponent,
        ViewallsubscribedbookComponent,
        CancelsubscriptionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    RegistrationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
