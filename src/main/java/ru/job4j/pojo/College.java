package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov");
        student.setGroup(123);
        student.setYear(2000);
        System.out.println("Student : " + student.getName() + " group : " + student.getGroup()
                + " year " + student.getYear());
    }
}
