package p06_strategyPattern.comparators;

import p06_strategyPattern.Person;

import java.util.Comparator;

public class ComparatorByNameLength implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        //The first comparator should compare people based on the length of their name
        //as a first parameter, if 2 people have a name with the same length,
        //perform a case-insensitive compare based on the first letter of their name instead
        int comp = Integer.compare(o1.getName().length(), o2.getName().length());
        if (comp == 0) {
            char o1NameFirstLetter = Character.toLowerCase(o1.getName().charAt(0));
            char o2NameFirstLetter = Character.toLowerCase(o2.getName().charAt(0));
            comp = Character.compare(o1NameFirstLetter, o2NameFirstLetter);
        }
        return comp;
    }
}
