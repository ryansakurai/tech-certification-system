package com.sakurai.techcertification.certification.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RankingCertificationDto {

    private UUID id;
    private double grade;
    private RankingStudentDto student;
    
}
