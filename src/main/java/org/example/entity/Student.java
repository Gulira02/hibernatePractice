package org.example.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.gender.Gender;
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name="students")
//@ToString(exclude = "firstName") ,,length =50,nullable = false
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private  Long id;
    @Column(name="first_name")
    private  String firstName;
    @Column(name="last_name")
    private  String lastName;
    private  String email;
    private int age;


    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(Long id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
