package com.pradeeppadmakumar.fullstack.eventfeedbackservice.controller;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserController {

    private final FeedbackService feedbackService;

    @GetMapping("/{userId}/event/{eventId}/feedback")
    public Feedback getEventsById(@PathVariable Long userId, @PathVariable Long eventId) {
        return feedbackService.getFeedbackByUserAndEvent(userId, eventId);
    }

    @PostMapping("/{userId}/event/{eventId}/feedback")
    public Feedback createFeedback(@PathVariable Long userId, @PathVariable Long eventId, @RequestBody Feedback feedbackBody) {
        return feedbackService.createFeedback(userId, eventId, feedbackBody);
    }
}
