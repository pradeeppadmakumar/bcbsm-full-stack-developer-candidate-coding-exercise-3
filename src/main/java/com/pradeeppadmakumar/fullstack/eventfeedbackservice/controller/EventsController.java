package com.pradeeppadmakumar.fullstack.eventfeedbackservice.controller;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Event;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.EventRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EventsController {

    private final EventService eventService;

    @GetMapping("/")
    public ResponseEntity<List<Event>> getAllEvents() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Headers", "*");
        return ResponseEntity.ok().headers(headers).body(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventsById(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Headers", "*");
        return ResponseEntity.ok().headers(headers).body(eventService.findEventById(id));
    }


}


