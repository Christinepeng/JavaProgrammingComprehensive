package HW5;

public class Student implements Comparable {
    private String firstName;
    private String lastName;
    private int score;

    Student(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    @Override
    public int compareTo(Object t) {
        Student s = (Student) t;

        if (lastName.equals(s.lastName)) {
            return firstName.compareToIgnoreCase(s.firstName);
        }
        return lastName.compareToIgnoreCase(s.lastName);
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    int getScore() {
        return score;
    }
}