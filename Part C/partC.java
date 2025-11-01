public class Student {
    public int studentID;
    public String name;
    public String department;
    public int marks;

    public Student(int studentID, String name, String department, int marks) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return studentID + " | " + name + " | " + department + " | " + marks;
    }
}
