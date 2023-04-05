package kz.iitu.spring.SpringBoot.beans;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



public class SecondBean {

    private String name;
    private int age;

    public SecondBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public SecondBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
