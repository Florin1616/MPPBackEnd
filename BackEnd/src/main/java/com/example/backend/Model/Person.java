package com.example.backend.Model;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;
    private String address;
    private String photo;
    public Person() {
    }

    public Person(int id, String name, int age, String occupation, String address, String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.photo = photo;
    }

    public Person(String name, int age, String occupation, String address, String photo) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.photo = photo;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                ", address='" + address + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoto() {
        return photo;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId(int id) {
        this.id = id;
    }
}