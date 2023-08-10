package com.pradeeppadmakumar.fullstack.eventfeedbackservice.controller;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@CrossOrigin("*")
public class EventsController {

    @GetMapping("/")
    public List<Event> helloUserController() {

        //events = [
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
 // ]

        Event event1 = Event.builder()
                .id(1L)
                .imageLink("https://images.unsplash.com/photo-1501281668745-f7f57925c3b4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3570&q=80")
                .title("TechConnect: Innovations in Digital Healthcare")
                .description("Join us at \"TechConnect: Innovations in Digital Healthcare,\" a groundbreaking event presented by the Blue Cross Blue Shield (BCBS) Innovation Lab. Discover the future of healthcare as we explore the latest advancements in digital health technologies and their impact on patient care. Engage with leading experts, entrepreneurs, and healthcare professionals as they share insights on telemedicine, wearable health devices, AI-driven diagnostics, and personalized treatment plans. From virtual doctor visits to real-time health monitoring, this event promises to unveil the next frontier in healthcare innovation. Don't miss this opportunity to connect, learn, and shape the future of healthcare together.")
                .time(Instant.now())
                .duration("2 Hours")
                .build();

        Event event2 = Event.builder()
                .id(2L)
                .imageLink("https://images.unsplash.com/photo-1505373877841-8d25f7d46678?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2224&q=80")
                .title("HealthyFutures: Empowering Wellness Communities")
                .description("Welcome to \"HealthyFutures: Empowering Wellness Communities,\" a transformative event organized by Blue Cross Blue Shield (BCBS) Community Outreach. This inspiring gathering aims to foster healthier and happier neighborhoods by promoting community engagement and well-being. Join us for interactive workshops, fitness challenges, and mindfulness sessions designed to enhance physical, mental, and emotional health. Learn about sustainable living practices, locally sourced nutrition, and innovative approaches to holistic wellness. By bringing together individuals, families, and local businesses, we're building a stronger, more resilient community that prioritizes health at its core. Let's embark on a journey towards HealthyFutures together!")
                .time(Instant.now())
                .duration("3 Hours")
                .build();

        Event event3 = Event.builder()
                .id(3L)
                .imageLink("https://images.unsplash.com/photo-1505373877841-8d25f7d46678?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2224&q=80")
                .title("BlueWell Expo: A Journey to Total Wellness")
                .description("Welcome to \"HealthyFutures: Empowering Wellness Communities,\" a transformative event organized by Blue Cross Blue Shield (BCBS) Community Outreach. This inspiring gathering aims to foster healthier and happier neighborhoods by promoting community engagement and well-being. Join us for interactive workshops, fitness challenges, and mindfulness sessions designed to enhance physical, mental, and emotional health. Learn about sustainable living practices, locally sourced nutrition, and innovative approaches to holistic wellness. By bringing together individuals, families, and local businesses, we're building a stronger, more resilient community that prioritizes health at its core. Let's embark on a journey towards HealthyFutures together!")
                .time(Instant.now())
                .duration("3 Hours")
                .build();

        return Arrays.asList(event1, event2, event3);
    }

}
