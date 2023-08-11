import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RouteGuardService } from './service/route-guard.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { EventsComponent } from './events/events.component';
import { EventComponent } from './events/event/event.component';
import { ErrorComponent } from './error/error.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
 { path: '', component: WelcomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'events', component: EventsComponent, canActivate:[RouteGuardService]},
  { path: 'events/:id', component: EventComponent, canActivate:[RouteGuardService]},
  { path: 'logout', component: LogoutComponent},

  { path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
