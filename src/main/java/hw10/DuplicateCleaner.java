package hw10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class DuplicateCleaner {

    public static void main(String[] args) {

        List<User> startCollection = new ArrayList<>();
        startCollection.add(new User(19, "Helen", "banker"));
        startCollection.add(new User(45, "Ivan", "doctor"));
        startCollection.add(new User(19, "Helen", "banker"));
        startCollection.add(new User(35, "Dirk", "teacher"));
        startCollection.add(new User(29, "Hanna", "baby sitter"));
        startCollection.add(null);
        startCollection.add(null);
        System.out.println(startCollection);
        System.out.println(startCollection.size());
        Collection <Object> cleanedCollection = cleanDuplicates(startCollection);
        System.out.println(cleanedCollection);
        System.out.println(cleanedCollection.size());
    }

    public static Collection<Object> cleanDuplicates(Collection inputCollection) {
        return new HashSet<>(inputCollection);
    }

}

class User {
    int age;
    String name;
    String job;

    public User(int age, String name, String job) {
        this.age = age;
        this.name = name;
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (!name.equals(user.name)) return false;
        return job.equals(user.job);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        result = 31 * result + job.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
