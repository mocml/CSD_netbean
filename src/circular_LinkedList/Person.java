/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 11/08/2021    1.0            Vanhv   
 */
package circular_LinkedList;

/**
 *
 * @author vanhv
 */
class Person {

    String name;
    int age;
    boolean gender;
    String address;
    String phone;

     Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

     Person(String name, int age, boolean gender, String address, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

     int getAge() {
        return age;
    }

     void setAge(int age) {
        this.age = age;
    }

     boolean isGender() {
        return gender;
    }

     void setGender(boolean gender) {
        this.gender = gender;
    }

     String getAddress() {
        return address;
    }

     void setAddress(String address) {
        this.address = address;
    }

     String getPhone() {
        return phone;
    }

     void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
     public String toString() {
        return String.format("%-8s | %-3s | %-5s | %-5s | %-8s", name,age,gender,address,phone);
    }
 }
