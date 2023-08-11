package com.pradeeppadmakumar.fullstack.eventfeedbackservice.controller;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AdminController {

    private final FeedbackService feedbackService;

    @GetMapping("/{userId}/event/{eventId}/feedback")
    public ResponseEntity<List<Feedback>> getAllFeedbacksByEventId(@PathVariable Long userId, @PathVariable Long eventId) {

        List<Feedback> feedbacks = feedbackService.getAllFeedbacksByEvent( eventId);

        return ResponseEntity.ok().body(feedbacks);
    }

    @GetMapping("/feedback")
    public ResponseEntity<List<Feedback>>  findAllFeedback() {
        List<Feedback> feedbacks = feedbackService.findAllFeedbacks();

        return ResponseEntity.ok().body(feedbacks);
    }
}
