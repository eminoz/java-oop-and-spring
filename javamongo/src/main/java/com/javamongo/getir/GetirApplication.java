package com.javamongo.getir;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class GetirApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetirApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("tr", "ant", "07");
            String email = "eminoz1@yahoo.com";
            Student student = new Student(
                    "emin2",
                    "oz",
                    email,
                    Gender.MALE,
                    address,
                    List.of("computer"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
            //Custom query
            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));
            List<Student> students = mongoTemplate.find(query, Student.class);
            if (students.size() > 1) {
                throw new IllegalAccessException(
                        "found many students with email " + email
                );
            }
            if (students.isEmpty()) {
                System.out.println("inserting student " + student);
                repository.insert(student);
            } else {
                System.out.println(student + " already exists");
            }

        };
    }
}
