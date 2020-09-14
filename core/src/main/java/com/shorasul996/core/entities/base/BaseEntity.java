package com.shorasul996.core.entities.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isActive", columnDefinition = "boolean default true")
    private Boolean isActive = Boolean.TRUE;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !getClass().getName().equalsIgnoreCase(obj.getClass().getName())){
            return true;
        }
        if(this==obj){
            return true;
        }
        return Objects.equals(getId(),((BaseEntity)obj).getId());
    }

    @Override
    public String toString() {
        return getClass().getName()+"{" +
                "id=" + id +
                '}';
    }
}