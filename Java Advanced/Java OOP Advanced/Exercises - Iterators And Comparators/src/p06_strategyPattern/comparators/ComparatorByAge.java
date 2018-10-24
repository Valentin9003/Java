package p06_strategyPattern.comparators;

import p06_strategyPattern.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        //The second comparator should compare them based on their age
//        int comp = o1.getAge() - o2.getAge();
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
