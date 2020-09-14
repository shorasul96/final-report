package com.shorasul996.api.service;

import com.shorasul996.core.dto.StudentDto;
import com.shorasul996.core.entities.StudentEntity;
import com.shorasul996.core.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    List<StudentDto> getStudentDtoList() {
        return studentRepository.findAll().stream().map(StudentEntity::getDto).collect(Collectors.toList());
    }
}
