package hw10.duplicateCleaner;

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

