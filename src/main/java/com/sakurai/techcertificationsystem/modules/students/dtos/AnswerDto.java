package com.sakurai.techcertificationsystem.modules.students.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private UUID questionId;
    private UUID alternativeId;
    private boolean isCorrect;

}
