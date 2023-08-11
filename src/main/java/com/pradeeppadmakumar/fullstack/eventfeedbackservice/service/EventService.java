package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Event;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        log.info("fetching all event details");
        return eventRepository.findAll();
    }

    public Event findEventById(Long id) {
        log.info("fetching event details for event: {}", id);
        return eventRepository.findById(id).orElse(null);
    }
}
