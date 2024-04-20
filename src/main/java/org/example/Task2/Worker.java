package org.example.Task2;

public class Worker {
    private String name;

    private String position;

    private double salary;

    private int age;

    private String CrazyIntroduce;

    public Worker(String name, String position, double salary, int age, String CrazyIntroduce) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.CrazyIntroduce = CrazyIntroduce;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCrazyIntroduce() {
        return CrazyIntroduce;
    }

    public void setCrazyIntroduce(String crazyIntroduce) {
        CrazyIntroduce = crazyIntroduce;
    }

}
