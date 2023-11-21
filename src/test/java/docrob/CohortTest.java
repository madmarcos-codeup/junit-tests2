package docrob;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CohortTest {
    private Cohort cohort;

    @Before
    public void setup() {
        cohort = new Cohort();

        Student bob = new Student(1, "bob");
        bob.addGrade(77);
        bob.addGrade(92);
        bob.addGrade(90);
        cohort.addStudent(bob);
        // 86.3

        Student sue = new Student(2, "sue");
        sue.addGrade(97);
        cohort.addStudent(sue);
        // 97

        // cohort avg 91.65
    }

    @Test
    public void testAddStudent() {
        Student tom = new Student(3, "tom");
        cohort.addStudent(tom);

        assertSame(tom, cohort.getStudents().get(2));
        assertEquals(tom, cohort.getStudents().get(2));
    }

    @Test
    public void testGetStudents() {
        assertEquals(2, cohort.getStudents().size());
    }

    @Test
    public void testCohortAverage() {
        assertEquals(91.65, cohort.getCohortAverage(), 0.02);
    }

    @Test
    public void testEmptyCohort() {
        cohort = new Cohort();
        assertEquals(Double.NaN, cohort.getCohortAverage(), 0);
    }

    @Test
    public void testFindStudentOk() {
        Student checkBob = cohort.findStudentById(1);
        assertEquals("bob", checkBob.getName());
    }

    @Test(expected = StudentNotFoundException.class)
    public void testFindStudentNotOk() {
        Student checkNotBob = cohort.findStudentById(99999);
        fail("no student with id 99999 should exist");
    }
}
