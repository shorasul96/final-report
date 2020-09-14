package com.shorasul996.web.controllers;

import com.shorasul996.core.dto.UserDto;
import com.shorasul996.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users/")
@RequiredArgsConstructor
public class WebUserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getUserDtoList();
        if (userDtoList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(userDtoList); // ok
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // if list empty
    }

    @PostMapping("/")
    public ResponseEntity<?> saveNewUser(@RequestBody UserDto dto) {
        if (dto == null || dto.getFullName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User fullName cannot be empty");
        }
        userService.saveUserDto(dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
