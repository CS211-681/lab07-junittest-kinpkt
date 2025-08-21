package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;

    @BeforeAll
    static void initial() {
    }

    @BeforeEach
    void setup() {
        studentList = new StudentList();
        studentList.addNewStudent("6710405141", "Test 1", 12);
        studentList.addNewStudent("6810405142", "Test 2", 0);
        studentList.addNewStudent("6610405143", "Test 3", 80);
        studentList.addNewStudent("6310405144", "Test 4", 1000);
    }

    @Test
    void testAddNewStudent() {
        String[] studentIds = {"6710405141", "6810405142", "6610405143", "6310405144"};
        String[] studentNames = {"Test 1", "Test 2", "Test 3", "Test 4"};

        for (int i = 0; i < studentList.getStudents().size(); i++) {
            assertEquals(studentIds[i], studentList.getStudents().get(i).getId());
            assertEquals(studentNames[i], studentList.getStudents().get(i).getName());
        }
    }

    @Test
    void testAddNewStudentWithScore() {
        String[] studentIds = {"6710405141", "6810405142", "6610405143", "6310405144"};
        String[] studentNames = {"Test 1", "Test 2", "Test 3", "Test 4"};
        double[] studentScore = {12, 0, 80, 1000};

        for (int i = 0; i < studentList.getStudents().size(); i++) {
            assertEquals(studentIds[i], studentList.getStudents().get(i).getId());
            assertEquals(studentNames[i], studentList.getStudents().get(i).getName());
            assertEquals(studentScore[i], studentList.getStudents().get(i).getScore());
        }
    }

    @Test
    void testFindStudentById() {
        Student targetStudent = new Student("6710405141", "Test 1", 12);
        Student foundedStudent = studentList.findStudentById("6710405141");
        assertEquals(targetStudent.getId(), foundedStudent.getId());
        assertEquals(targetStudent.getName(), foundedStudent.getName());
        assertEquals(targetStudent.getScore(), foundedStudent.getScore());
    }

    @Test
    void testFilterByName() {
        String filterer = "Test";
        StudentList filteredList = studentList.filterByName(filterer);
        for (Student student : filteredList.getStudents())
            assertEquals(true, student.isNameContains(filterer));
    }

    @Test
    void testGiveScoreToId() {
        studentList.giveScoreToId("6710405141", 100);
        assertEquals(112, studentList.getStudents().get(0).getScore());
    }

    @Test
    void testViewGradeOfId() {
        String grade = studentList.viewGradeOfId("6810405142");
        assertEquals("F", grade);
    }
}