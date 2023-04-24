package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "courses")


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private  Long id;
    @Column(name="course_name")
    private  String courName;
    @Column(name="last_name")
    private  int price;

    public Course(String courName, int price) {
        this.courName = courName;
        this.price = price;
    }

    public Course(Long id, String courName, int price) {
        this.id = id;
        this.courName = courName;
        this.price = price;
    }
}
