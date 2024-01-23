package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Table(name = "Subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(50)")
    private String course;

    @Column(columnDefinition = "varchar(50)")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private Collection<Mark> marks;

}
