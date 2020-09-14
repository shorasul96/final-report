package com.shorasul996.core.entities;

import com.shorasul996.core.constants.TableNames;
import com.shorasul996.core.constants.UserType;
import com.shorasul996.core.dto.StudentDto;
import com.shorasul996.core.entities.base.BaseEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableNames.students)
public class StudentEntity extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false) // su8133
    private String username;

    @Column(name = "full_name")
    private String fullName;


    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private SubjectEntity subject;

    public StudentDto getDto(){
        StudentDto dto = new StudentDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }


}
