package com.shorasul996.core.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SubjectDto {
    private Long id;
    @NotEmpty(message = "Subject name cannot be empty")
    private String subjectName;
    @Min(value = 2, message = "Credit for this subject cannot be less then 2")
    @Max(value = 10, message = "Credit for this subject cannot be more then 10")
    private Double creditAmount;
    @Min(value = 10, message = "Duration of this subject cannot be less then 10 hours")
    private Double durationHours;
    private Boolean isActive;
}
