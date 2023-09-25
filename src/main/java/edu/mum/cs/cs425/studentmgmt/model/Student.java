package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank
    private String studentNumber;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    private Double cgpa;

    private Date dateOfEnrollment;

    @OneToMany
    private List<Transcript> transcript;


    public Student() {
    }

    public Student(Long studentId, @NotBlank String studentNumber, @NotBlank String firstName, String middleName, @NotBlank String lastName, Double cgpa, Date dateOfEnrollment, List<Transcript> transcript) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
    }

    public void setTranscript(List<Transcript> transcript) {
        this.transcript = transcript;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                '}';
    }

}

