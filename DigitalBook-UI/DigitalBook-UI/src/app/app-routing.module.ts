import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthordashboardComponent } from './components/authordashboard/authordashboard.component';
import { BlockorunblockComponent } from './components/blockorunblock/blockorunblock.component';
import { BooksubscribeComponent } from './components/booksubscribe/booksubscribe.component';
import { CreatebookComponent } from './components/createbook/createbook.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ReaderdashboardComponent } from './components/readerdashboard/readerdashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { UpdatebookComponent } from './components/updatebook/updatebook.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'authordashboard', component: AuthordashboardComponent},
  { path: 'readerdashboard', component: ReaderdashboardComponent},
  { path: 'logout',component: LogoutComponent},
  { path: 'createbook',component: CreatebookComponent},
  { path: 'updatebook',component: UpdatebookComponent},
  { path: 'blockorunblock',component: BlockorunblockComponent},
  { path: 'booksubscribe',component: BooksubscribeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
