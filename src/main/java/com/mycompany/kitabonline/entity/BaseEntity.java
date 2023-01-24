package com.mycompany.kitabonline.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@CreationTimestamp
    private LocalDateTime createDate = LocalDateTime.now();
    //@UpdateTimestamp
    private LocalDateTime updateDate = LocalDateTime.now();

}
