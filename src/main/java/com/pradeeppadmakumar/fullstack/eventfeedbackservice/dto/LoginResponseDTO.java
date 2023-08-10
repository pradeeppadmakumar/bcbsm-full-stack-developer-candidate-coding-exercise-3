package com.pradeeppadmakumar.fullstack.eventfeedbackservice.dto;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private ApplicationUser user;
    private String jwt;
}
