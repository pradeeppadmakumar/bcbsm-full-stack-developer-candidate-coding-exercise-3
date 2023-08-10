import { Component, OnInit } from '@angular/core';
import { EventsDataService } from './../service/data/events-data.service';





@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent {

  constructor( public eventsDataService: EventsDataService ) {}

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


  events: any = [
   /*  new Event( 1,
      "https://images.unsplash.com/photo-1501281668745-f7f57925c3b4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3570&q=80",
      "20 September 2023 10 AM CT",
      "2 Hours",
      "TechConnect: Innovations in Digital Healthcare",
      "Join us at \"TechConnect: Innovations in Digital Healthcare,\" a groundbreaking event presented by the Blue Cross Blue Shield (BCBS) Innovation Lab. Discover the future of healthcare as we explore the latest advancements in digital health technologies and their impact on patient care. Engage with leading experts, entrepreneurs, and healthcare professionals as they share insights on telemedicine, wearable health devices, AI-driven diagnostics, and personalized treatment plans. From virtual doctor visits to real-time health monitoring, this event promises to unveil the next frontier in healthcare innovation. Don't miss this opportunity to connect, learn, and shape the future of healthcare together."
    ),
    new Event(  2,
      "https://images.unsplash.com/photo-1505373877841-8d25f7d46678?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2224&q=80",
      "12 August 2023 10 AM CT",
      "1 Hour",
      "HealthyFutures: Empowering Wellness Communities",
      "Welcome to \"HealthyFutures: Empowering Wellness Communities,\" a transformative event organized by Blue Cross Blue Shield (BCBS) Community Outreach. This inspiring gathering aims to foster healthier and happier neighborhoods by promoting community engagement and well-being. Join us for interactive workshops, fitness challenges, and mindfulness sessions designed to enhance physical, mental, and emotional health. Learn about sustainable living practices, locally sourced nutrition, and innovative approaches to holistic wellness. By bringing together individuals, families, and local businesses, we're building a stronger, more resilient community that prioritizes health at its core. Let's embark on a journey towards HealthyFutures together!"
    ),
    new Event(  3,
      "https://images.unsplash.com/photo-1472653431158-6364773b2a56?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2369&q=80",
      "15 January 2023 10 AM CT",
      "5 Hours",
      "BlueWell Expo: A Journey to Total Wellness",
      "Blue Cross Blue Shield (BCBS) hosted the \"BlueWell Expo: A Journey to Total Wellness,\" a vibrant event that brought together health enthusiasts, experts, and community members. Attendees immersed themselves in a diverse range of activities, from informative seminars and interactive fitness demonstrations to cooking workshops and guided meditation sessions. This expo fostered a sense of community while inspiring participants to prioritize their well-being through knowledge and positive lifestyle changes, leaving a lasting impact on BCBS's commitment to promoting holistic health and preventive care."
    ) */
  ]

}
