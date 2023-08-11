package com.pradeeppadmakumar.fullstack.eventfeedbackservice;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Event;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Feedback;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Role;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.EventRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.FeedbackRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.RoleRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class EventFeedbackServiceApplication implements CommandLineRunner {

	private final RoleRepository roleRepository;

	private final UserRepository userRepository;

	private final EventRepository eventRepository;

	private final FeedbackRepository feedbackRepository;

	private final PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(EventFeedbackServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(roleRepository.findByAuthority("ADMIN").isPresent()) return;

		Role adminRole = roleRepository.save(new Role("ADMIN"));
		Role userRole = roleRepository.save(new Role("USER"));

		Set<Role> roles = new HashSet<>();

		roles.add(adminRole);

		ApplicationUser admin = new ApplicationUser(0L, "admin", encoder.encode("admin"), "admin", "admin@bcbs.com", roles);
		userRepository.save(admin);

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);

		ApplicationUser user1 = new ApplicationUser(0L, "pradeep", encoder.encode("ironMan"), "pradeepPadmakumar", "pradeep@gmail.com", userRoles);


		ApplicationUser user2 = new ApplicationUser(0L, "user1", encoder.encode("user1Password"), "user 1", "user1@gmail.com", userRoles);


		ApplicationUser user3 = new ApplicationUser(0L, "user2", encoder.encode("user2Password"), "user 1", "user2@gmail.com", userRoles);


		ApplicationUser savedUser1 = userRepository.save(user1);
		ApplicationUser savedUser2 = userRepository.save(user2);
		ApplicationUser savedUser3 = userRepository.save(user3);

		userRepository.flush();


		Event event1 = Event.builder()
				.imageLink("https://images.unsplash.com/photo-1501281668745-f7f57925c3b4?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3570&q=80")
				.title("TechConnect: Innovations in Digital Healthcare")
				.description("Join us at \"TechConnect: Innovations in Digital Healthcare,\" a groundbreaking event presented by the Blue Cross Blue Shield (BCBS) Innovation Lab. ")
				.time(Instant.now())
				.duration("2 Hours")
				.build();

		Event event2 = Event.builder()
				.imageLink("https://images.unsplash.com/photo-1505373877841-8d25f7d46678?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2224&q=80")
				.title("HealthyFutures: Empowering Wellness Communities")
				.description("Welcome to \"HealthyFutures: Empowering Wellness Communities,\" a transformative event organized by Blue Cross Blue Shield (BCBS) Community Outreach.")
				.time(Instant.now())
				.duration("3 Hours")
				.build();

		Event event3 = Event.builder()
				.imageLink("https://images.unsplash.com/photo-1472653431158-6364773b2a56?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2369&q=80")
				.title("BlueWell Expo: A Journey to Total Wellness")
				.description("Blue Cross Blue Shield (BCBS) hosted the \"BlueWell Expo: A Journey to Total Wellness,\" a vibrant event that brought together health enthusiasts, experts, and community members.")
				.time(Instant.now())
				.duration("3 Hours")
				.build();

		Event savedEvent1 = eventRepository.save(event1);
		Event savedEvent2 = eventRepository.save(event2);
		Event savedEvent3 = eventRepository.save(event3);

		System.out.println(savedEvent1.getId());
		System.out.println(savedEvent2.getId());
		System.out.println(savedEvent3.getId());

		eventRepository.flush();

		Feedback feedback1 = Feedback.builder()
				.event(savedEvent1)
				.user(savedUser1)
				.rating(5)
				.comment("Awesome")
				.build();

		Feedback feedback2 = Feedback.builder()
				.event(savedEvent1)
				.user(savedUser2)
				.rating(3)
				.comment("Needs improvement")
				.build();

		Feedback feedback3 = Feedback.builder()
				.event(savedEvent2)
				.user(savedUser2)
				.rating(1)
				.comment("Not Good")
				.build();

		feedbackRepository.save(feedback1);
		feedbackRepository.save(feedback2);
		feedbackRepository.save(feedback3);


	}


}
