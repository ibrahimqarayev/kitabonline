package com.mycompany.kitabonline.dto;

import com.mycompany.kitabonline.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

}
