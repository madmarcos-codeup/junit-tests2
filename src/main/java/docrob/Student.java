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
}
