package com.shorasul996.core.entities;

import com.shorasul996.core.constants.TableNames;
import com.shorasul996.core.dto.SubjectDto;
import com.shorasul996.core.entities.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableNames.subjects)
public class SubjectEntity extends BaseEntity {

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "credit_amount")
    private Double creditAmount;

    @Column(name = "duration_hours")
    private Double durationHours;

    public SubjectDto getDto(){
        SubjectDto dto = new SubjectDto();
        BeanUtils.copyProperties(this, dto);
        return  dto;
    }
}
