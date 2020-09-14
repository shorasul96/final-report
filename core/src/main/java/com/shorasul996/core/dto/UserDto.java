package com.shorasul996.core.dto;

import com.shorasul996.core.constants.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserDto {
    private Long id;
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "fullName cannot be empty")
    private String fullName;
    @NotEmpty(message = "userType cannot be empty")
    private UserType userType;
    private Long subjectId;
    private SubjectDto subject;
}
