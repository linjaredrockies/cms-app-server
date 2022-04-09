package com.ctrockies.cms.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import com.ctrockies.cms.data.Student;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository repository;
    @Test
    public void testFindByStudent() {
    	entityManager.persist(new Student(Integer.valueOf(231456), "John", "Denver", "721345678"));
    	List<Student> students = repository.findByStudentNumber(231456);
    	assertEquals(1, students.size());
        assertThat(students).extracting(Student::getStudentNumber).containsOnly(231456);
        assertThat(students).extracting(Student::getFirstName).containsOnly("John");
        assertThat(students).extracting(Student::getLastName).containsOnly("Denver");
    }
}
