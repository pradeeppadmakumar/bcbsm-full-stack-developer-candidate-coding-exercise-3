package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.EventRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.FeedbackRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final EventRepository eventRepository;
    private  final UserRepository userRepository;

    public List<Feedback> getAllFeedbacksByEvent(Long eventId) {
        log.info("fetching all feedbacks by eventId: {}", eventId);
        return feedbackRepository.getAllFeedbackByEventId(eventId);
    }

    public List<Feedback> findAllFeedbacks() {
        log.info("fetching all feedbacks");
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackByUserAndEvent(Long userId, Long eventId) {
        log.info("fetching all feedbacks by eventId: {} for user:{}", eventId, userId);
        return feedbackRepository.getFeedbackByEventIdAndUserId(eventId, userId);
    }


    public Feedback createFeedback(Long userId, Long eventId, Feedback feedbackBody) {
        if(userRepository.existsById(userId) && eventRepository.existsById(eventId)) {
            log.info("creating feedback by eventId: {} for user:{}", eventId, userId);
            feedbackBody.setUser(userRepository.findById(userId).get());
            feedbackBody.setEvent(eventRepository.findById(eventId).get());
            return feedbackRepository.save(feedbackBody);
        }
        log.info("event or user not found for eventId: {} for user:{}", eventId, userId);
        throw new IllegalArgumentException();

    }
}
