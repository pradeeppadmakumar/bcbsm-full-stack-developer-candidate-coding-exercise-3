import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


/* export class Event {
  constructor(
    public id: number,
    public imageLink: string,
    public time: string,
    public duration: string,
    public title: string,
    public description: string,
  ) {}
} */


export class EventsDataService {

  constructor(
    public http: HttpClient
  ) { }

  executeEventsService() {
    return this.http.get<any>('http://localhost:8080/api/v1/event/');
  }
}
