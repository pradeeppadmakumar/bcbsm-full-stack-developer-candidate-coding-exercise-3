package com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    public List<Feedback> getAllFeedbackByEventId(Long eventId);
    public Feedback getFeedbackByEventIdAndUserId(Long eventId, Long userId);
}
