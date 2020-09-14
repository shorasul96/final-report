package com.shorasul996.api.controllers;

import com.shorasul996.api.service.UserService;
import com.shorasul996.core.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users/")
@RequiredArgsConstructor
public class ApiUserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getUserDtoList();
        if (userDtoList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(userDtoList); // ok
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // if list empty
    }


}
