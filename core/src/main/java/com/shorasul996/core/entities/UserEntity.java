package com.shorasul996.core.entities;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.shorasul996.core.constants.TableNames;
import com.shorasul996.core.constants.UserType;
import com.shorasul996.core.dto.UserDto;
import com.shorasul996.core.entities.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = TableNames.users)
public class UserEntity extends BaseEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "subject_id")
    private Long subjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", insertable = false, updatable = false)
    private SubjectEntity subject;

    public UserDto getDto(){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(this, dto, "password");
        return dto;
    }

}
