package com.shorasul996.web.service;

import com.shorasul996.core.dto.UserDto;
import com.shorasul996.core.entities.UserEntity;
import com.shorasul996.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> getUserDtoList() {
        return userRepository.findAll().stream().map(UserEntity::getDto).collect(Collectors.toList());
    }

    @Transactional
    public void saveUserDto(UserDto dto) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setPassword("root"); //default password for new member
        userRepository.save(entity);
    }
}
