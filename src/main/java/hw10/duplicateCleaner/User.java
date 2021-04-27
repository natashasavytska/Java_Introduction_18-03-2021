package hw10.duplicateCleaner;

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
