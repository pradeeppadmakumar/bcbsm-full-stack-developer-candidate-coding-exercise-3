import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FeedbackDataService {

  constructor(
    public http: HttpClient
  ) { }

  getAllFeedbacksByEventId( eventId: string) {
   let userId = sessionStorage.getItem('authenticatedUserId');
      return this.http.get<any>('http://localhost:8080/api/v1/admin/' + userId + '/event/' + eventId + '/feedback');
    }

    getFeedbackByEventAndUserId(eventId: string) {
      let userId = sessionStorage.getItem('authenticatedUserId');
      return this.http.get<any>('http://localhost:8080/api/v1/user/' + userId + '/event/' + eventId + '/feedback');
    }

    submitFeedback(userId: string, eventId: string, feedback: any) {
      this.http.post<any>(
            "http://localhost:8080/api/v1/user/" + userId + "/event/" + eventId + "/feedback", feedback
          )
    }
}
