package com.mycompany.kitabonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Category extends BaseEntity {

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Book> books;

}
