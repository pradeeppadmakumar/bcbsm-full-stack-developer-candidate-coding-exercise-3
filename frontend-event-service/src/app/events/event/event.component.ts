import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventsDataService } from './../../service/data/events-data.service';
import { FeedbackDataService } from './../../service/data/feedback-data.service';
import { JwtAuthenticationService } from './../../service/jwt-authentication.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit{

  constructor( private activatedRoute: ActivatedRoute, public eventsDataService: EventsDataService, public feedbackDataService: FeedbackDataService  , public jwtAuthenticationService: JwtAuthenticationService) {}

  eventId: any;
  event: any;
  userFeedback: any;
  allUserFeedbacks: any;
  userId : any;
  newFeedback = '';
  newRating = '';


  ngOnInit() {
      this.eventId = this.activatedRoute.snapshot.paramMap.get('id');
      this.userId = this.jwtAuthenticationService.getAuthenticatedUser();
      this.eventsDataService.getEventById(this.eventId).subscribe(response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error));

      if(this.jwtAuthenticationService.isAdminUser()) {
        this.feedbackDataService.getAllFeedbacksByEventId( this.eventId).subscribe(response => this.setAllUsersFeedback(response));
          /* if(this.userId === 'admin') {
            this.allUserFeedbacks = [
              {
                  "id": 3,
                  "createdTimestamp": "2023-08-11T14:40:54.921160Z",
                  "updateTimestamp": "2023-08-11T14:40:54.921167Z",
                  "version": 0,
                  "user": {
                      "id": 3,
                      "username": "user1",
                      "name": "user 1",
                      "email": "user1@gmail.com",
                      "enabled": true,
                      "accountNonExpired": true,
                      "accountNonLocked": true,
                      "credentialsNonExpired": true
                  },
                  "rating": 1,
                  "comment": "Not Good"
              },
              {
                  "id": 4,
                  "createdTimestamp": "2023-08-11T14:51:28.463249Z",
                  "updateTimestamp": "2023-08-11T14:51:28.463257Z",
                  "version": 0,
                  "user": {
                      "id": 6,
                      "username": "newuser",
                      "name": "pradeep padmakumar",
                      "email": "pradeep.padmakumar@demo.com",
                      "enabled": true,
                      "accountNonExpired": true,
                      "accountNonLocked": true,
                      "credentialsNonExpired": true
                  },
                  "rating": 5,
                  "comment": "Great Experience!!!"
              }
          ];
          } */

      }
      else {
        this.feedbackDataService.getFeedbackByEventAndUserId(this.eventId).subscribe(response => this.setUserFeedback(response));
        /* this.userFeedback = {
           "id": 3,
           "createdTimestamp": "2023-08-11T14:40:54.921160Z",
           "updateTimestamp": "2023-08-11T14:40:54.921167Z",
           "version": 0,
           "user": {
               "id": 3,
               "username": "pradeep",
               "name": "user 1",
               "email": "user1@gmail.com",
               "enabled": true,
               "accountNonExpired": true,
               "accountNonLocked": true,
               "credentialsNonExpired": true
           },
           "rating": 1,
           "comment": "Not Good"
       } */
      }

    }

    handleSuccessfulResponse(response: any) {
      console.log(response);
      this.event = response;
    }

    setAllUsersFeedback(response: any) {
      console.log(response);
      this.allUserFeedbacks = response;
    }

    setUserFeedback(response: any) {
      console.log(response);
      this.userFeedback = response;
    }

    handleErrorResponse(error: any) {
      this.event = null;
    }

    handleFeedbackSubmit() {
      this.userFeedback = {
        'comment' : this.newFeedback,
        'rating': this.newRating,
        'user': {
          'username': this.userId
        }
      }

      this.feedbackDataService.submitFeedback(this.userId, this.eventId, this.userFeedback );
    }

}
