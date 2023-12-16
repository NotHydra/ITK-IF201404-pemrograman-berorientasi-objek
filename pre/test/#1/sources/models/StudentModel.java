package models;

import interfaces.StudentInterface;

public class StudentModel implements StudentInterface {
    private static int count = 0;

    private int id;
    private String name;
    private int age;
    private String grade;
    private String major;

    public StudentModel(String name, int age, String grade, String major) {
        this.id = ++count;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    };

    public static int getCount() {
        return count;
    }

    public int getId() {
        return this.id;
    };

    public String getName() {
        return this.name;
    };

    public int getAge() {
        return this.age;
    };

    public String getGrade() {
        return this.grade;
    };

    public String getMajor() {
        return this.major;
    };

    public void setId(int id) {
        this.id = id;
    };

    public void setName(String name) {
        this.name = name;
    };

    public void setAge(int age) {
        this.age = age;
    };

    public void setGrade(String grade) {
        this.grade = grade;
    };

    public void setMajor(String major) {
        this.major = major;
    };
}
