package org.skillfactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.skillfactory.dto.StudentData;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

public class Serialization {
    public static void main(String[] args) throws Exception {
        StudentData studentData = new StudentData();
        studentData.setFirstName("Saken");
        studentData.setLastName("Seifullin");
        studentData.setGrade(10);

//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("src\\main\\data\\student.data")))) {
//            objectOutputStream.writeObject(studentData);
//            objectOutputStream.flush();
//        }

//        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("src\\main\\data\\student.data")));
//        StudentData studentData = (StudentData) objectInputStream.readObject();
//        System.out.println(studentData.getFirstName());
//        System.out.println(studentData.getLastName());
//        System.out.println(studentData.getGrade());

        ObjectMapper objectMapper = new ObjectMapper();
        Files.write(Paths.get("src\\main\\json\\student.json"), Collections.singleton(objectMapper.writeValueAsString(studentData)));

        String rawJson = Files.readString(Paths.get("src\\main\\json\\student.json"));
        StudentData deserialized = objectMapper.readValue(rawJson, StudentData.class);

        System.out.println(deserialized.getFirstName());
        System.out.println(deserialized.getLastName());
        System.out.println(deserialized.getGrade());

    }
}
