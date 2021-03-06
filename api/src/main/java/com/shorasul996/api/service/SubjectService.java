package com.shorasul996.api.service;

import com.shorasul996.core.dto.SubjectDto;
import com.shorasul996.core.entities.SubjectEntity;
import com.shorasul996.core.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Transactional(readOnly = true)
    List<SubjectDto> getSubjectDtoList() {
        return subjectRepository.findAll().stream().map(SubjectEntity::getDto).collect(Collectors.toList());
    }
}
