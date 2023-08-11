package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.EventRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.FeedbackRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final EventRepository eventRepository;
    private  final UserRepository userRepository;

    public List<Feedback> getAllFeedbacksByEvent(Long eventId) {
        return feedbackRepository.getAllFeedbackByEventId(eventId);
    }

    public List<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackByUserAndEvent(Long userId, Long eventId) {
        return feedbackRepository.getFeedbackByEventIdAndUserId(eventId, userId);
    }


    public Feedback createFeedback(Long userId, Long eventId, Feedback feedbackBody) {
        if(userRepository.existsById(userId) && eventRepository.existsById(eventId)) {
            feedbackBody.setUser(userRepository.findById(userId).get());
            feedbackBody.setEvent(eventRepository.findById(eventId).get());
            return feedbackRepository.save(feedbackBody);
        }
        throw new IllegalArgumentException();

    }
}
