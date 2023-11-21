package docrob;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private Student bob = null;

    @Before
    public void setup() {
        bob = new Student(1, "bob");
        bob.addGrade(77);
        bob.addGrade(92);
        bob.addGrade(90);
    }

    @Test
    public void testId() {
        assertEquals(1, bob.getId());
    }

    @Test
    public void testName() {
        assertEquals("bob", bob.getName());
    }

    @Test
    public void testEquals() {
        Student otherBob = new Student(1, "bob");
        assertEquals(bob, otherBob);
    }

    // 86.33
    @Test
    public void testGradeAverage() {
        assertEquals(86.33, bob.getGradeAverage(), 0.01);
    }

    @Test
    public void testAddGrade() {
        // add a single grade and check to see if it added correctly
        bob.getGrades().clear();
        bob.addGrade(75);
        assertEquals(1, bob.getGrades().size());
        assertEquals(75, bob.getGrades().get(0).intValue());
    }

    // 85.66666666
    @Test
    public void testUpdateGrade() {
        bob.updateGrade(0, 75);
        assertEquals(85.66, bob.getGradeAverage(), 0.01);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUpdateGradeBadIndex() {
        bob.updateGrade(3, 100); // should cause exception
    }

    @Test
    public void testDeleteGrade() {
        bob.deleteGrade(2); // delete the 3rd grade (77 + 92)
        assertEquals(84.5, bob.getGradeAverage(), 0.1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteGradeBadIndex() {
        bob.deleteGrade(3); // should cause exception
    }


}
