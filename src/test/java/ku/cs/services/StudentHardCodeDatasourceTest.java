package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentHardCodeDatasource datasource;

    @BeforeEach
    void setup() {
        datasource = new StudentHardCodeDatasource();
    }

    @Test
    void testReadData() {
        StudentList resultList = datasource.readData();
        StudentList list = new StudentList();
        list.addNewStudent("6710400001", "First");
        list.addNewStudent("6710400002", "Second");
        list.addNewStudent("6710400003", "Third");
        list.addNewStudent("6710400004", "Fourth");

        for (int i = 0; i < resultList.getStudents().size(); i++) {
            assertEquals(list.getStudents().get(i).getId(), resultList.getStudents().get(i).getId());
            assertEquals(list.getStudents().get(i).getName(), resultList.getStudents().get(i).getName());
        }
    }
}