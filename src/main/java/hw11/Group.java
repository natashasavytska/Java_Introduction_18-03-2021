package hw11;

import java.util.Objects;

public class Group {

    String name;
    int groupID;
    Teacher teacher;

    public Group() {
    }

    public Group(String name, int groupID, Teacher teacher) {
        this.name = name;
        this.groupID = groupID;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupID == group.groupID && Objects.equals(name, group.name) && Objects.equals(teacher, group.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groupID, teacher);
    }
}
