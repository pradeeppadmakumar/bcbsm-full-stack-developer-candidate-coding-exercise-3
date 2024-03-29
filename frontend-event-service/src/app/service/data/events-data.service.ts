import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class EventsDataService {

  constructor(
    public http: HttpClient
  ) { }

  executeEventsService() {
    return this.http.get<any>('http://localhost:8080/api/v1/event/');
  }

  getEventById(id: string) {
      return this.http.get<any>('http://localhost:8080/api/v1/event/' + id);
    }
}
