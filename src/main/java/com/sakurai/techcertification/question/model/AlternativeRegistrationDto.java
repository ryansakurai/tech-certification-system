package com.sakurai.techcertification.question.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlternativeRegistrationDto {

    private String description;
    private boolean isCorrect;

}
