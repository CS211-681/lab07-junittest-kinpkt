package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;

    @BeforeAll
    static void initial() {
    }

    @BeforeEach
    void setup() {
        student = new Student("6710405141", "Test");
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อนักเรียน")
    void testChangeName() {
        student.changeName("New Name");
        assertEquals("New Name", student.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 3.14")
    void testAddScore() {
        student.addScore(80);
        assertEquals(80, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรด A (80 คะแนน)")
    void testCalculateGrade() {
        student.addScore(80);
        assertEquals("A", student.grade());
    }
}