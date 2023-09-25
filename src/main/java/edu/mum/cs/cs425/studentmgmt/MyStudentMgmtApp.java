package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.ClassroomService;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;
import edu.mum.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassroomService classroomService;

    @Autowired
    TranscriptService transcriptservice;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args){
        //Create Transcript and Student
        Transcript transcript = new Transcript(1L, "BS Computer Science");
        transcriptservice.saveTranscript(transcript);

        List<Transcript> transcriptList = new ArrayList<>();
        transcriptList.add(transcriptservice.getTranscriptById(1L));
        Student newStudent = new Student(1L, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, new Date(2019, 05, 24), transcriptList);
        studentService.saveStudent(newStudent);

        // Retrieve all students
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        // Retrieve a student by ID
        Long studentId = 1L;
        Student retrievedStudent = studentService.getStudentById(studentId);
        System.out.println("Retrieved Student: " + retrievedStudent);

        //Create Classroom
        Classroom classroom = new Classroom(1L, "McLaughlin building", "M105");
        List<Student> studentList = new ArrayList();
        studentList.add(newStudent);
        classroom.setStudents(studentList);
        classroomService.saveClassroom(classroom);


        // Retrieve a student by ID
        Long classroomId = 1L;
        Classroom retrievedClassroom = classroomService.getClassroomById(classroomId);
        System.out.println("Retrieved Classroom: " + retrievedClassroom);



    }

}
