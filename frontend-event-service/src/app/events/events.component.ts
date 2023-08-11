import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EventsDataService } from './../service/data/events-data.service';
import { JwtAuthenticationService } from './../service/jwt-authentication.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {

  constructor(private router: Router,  public eventsDataService: EventsDataService , public jwtAuthenticationService: JwtAuthenticationService) {}

  ngOnInit() {
    this.eventsDataService.executeEventsService().subscribe(response => this.handleSuccessfulResponse(response),
    error => this.handleErrorResponse(error));
  }

  handleSuccessfulResponse(response: any) {
    console.log(response);
    this.events = response;
  }

  handleErrorResponse(error: any) {
    this.events =[];
  }

  routeToEvent(id: any) {
    this.router.navigate(['events/', id])
  }

  events: any = [
  ]

}
