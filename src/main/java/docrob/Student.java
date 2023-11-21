package docrob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
        grades = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }


    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getGradeAverage() {
        double sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    // change the grade at index to newGrade
    public void updateGrade(int index, int newGrade) {
        if(index > grades.size() - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        grades.set(index, newGrade);
    }

    // delete the grade at given index
    // returns the deleted grade
    public int deleteGrade(int index) {
        if(index > grades.size() - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return grades.remove(index);
    }
}
