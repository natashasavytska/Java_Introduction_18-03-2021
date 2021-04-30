//package hw11;
//
//import java.util.Objects;
//
//public class Student {
//
//    String name;
//    String surname;
//    int age;
//    String phoneNumber;
//    Group group;
//    Address address;
//
//    public Student(String name, String surname, int age, String phoneNumber, Group group) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.phoneNumber = phoneNumber;
//        this.group = group;
//        this.address = new Address();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Group getGroup() {
//        return group;
//    }
//
//    public void setGroup(Group group) {
//        this.group = group;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(group, student.group);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, age, phoneNumber, group);
//    }
//}
