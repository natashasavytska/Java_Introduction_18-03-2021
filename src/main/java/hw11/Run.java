package hw11;

public class Run {
    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Ivan", "Ivanov", 30);
        Teacher teacher2 = new Teacher("Petr", "Petrov", 35);

        Group group1 = new Group("Java Basics", 1, teacher1);
        Group group2 = new Group("Java Elementary", 2, teacher2);

        Student student1 = new Student("Bill", "Smith", 28, "+380967889777", group1);
        Student student2 = new Student("Kate", "Orthon", 28, "+38056893879", group2);
        Student student3 = new Student("Natalia", "Smith", 28, "+38045547767",group1);
        Student student4 = new Student("Helen", "White", 28, "+3809675645577",group1);
        Student student5 = new Student("Nick", "Black", 28, null,group2);


        System.out.println(student1.getGroup().getTeacher());
//        System.out.println(student2.getAddress().getStreet().toLowerCase());
//        System.out.println(student5.getPhoneNumber().startsWith("+"));

        String welcomeLetter = """
                Dear students!
                Welcome to the course.
                If you have any questions please use Telegram-bot.      
                """;
        System.out.println(welcomeLetter);


    }
}
