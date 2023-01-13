package com.mycompany.kitabonline.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Getter
@Builder
@NoArgsConstructor
public class Image extends BaseEntity {
    private String imageUrl;

}
