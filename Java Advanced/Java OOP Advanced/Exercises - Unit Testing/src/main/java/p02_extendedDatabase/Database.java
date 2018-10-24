package p02_extendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.*;
import java.util.stream.Collectors;

public class Database {

    private final int DEFAULT_CAPACITY = 16;

    private List<People> storedPeople;
    private int cursor;

    public Database(People... numbers) throws OperationNotSupportedException {
        this.storedPeople = new LinkedList<>();
        this.setStoredIntegers(numbers);
    }

    private void setStoredIntegers(People[] people) throws OperationNotSupportedException {
        if (people.length != DEFAULT_CAPACITY) {
            throw new OperationNotSupportedException();
        }

        for (int index = 0; index < DEFAULT_CAPACITY; index++) {
            People person = people[index];
            if (person == null) {
                continue;
            } else if (!this.isUniqueId(person) || !this.isUniqueUsername(person)) {
                continue;
            } else {
                this.storedPeople.add(this.cursor++, person);
            }
        }


    }

    private boolean isUniqueId(People person) {
        for (People p : this.storedPeople) {
            if (person.getId().equals(p.getId())) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueUsername(People person) {
        for (People p : this.storedPeople) {
            if (person.getUsername().equals(p.getUsername())) {
                return false;
            }
        }
        return true;
    }

    private boolean hasPeopleWithThisName(String username) {
        return this.storedPeople.stream()
                .filter(p -> p.getUsername().equals(username))
                .collect(Collectors.toList())
                .size() != 0;
    }

    private boolean hasUserWithThisId(long id) {
        return this.storedPeople.stream()
                .filter(p -> p.getId() == id)
                .collect(Collectors.toList())
                .size() != 0;
    }

    public void addElement(People person) throws OperationNotSupportedException {
        if (person == null
                || this.cursor == DEFAULT_CAPACITY
                || person.getId() == null
                || person.getId() < 0
                || !this.isUniqueId(person)
                || !this.isUniqueUsername(person)) {
            throw new OperationNotSupportedException();
        }

        this.storedPeople.add(this.cursor++, person);
    }

    public void removeElement() throws OperationNotSupportedException {
        if (this.cursor == 0 && this.storedPeople.size() == 0) {
            throw new OperationNotSupportedException();
        }

        this.storedPeople.remove(--this.cursor);
    }

    public List<People> fetch() {
        return Collections.unmodifiableList(this.storedPeople);
    }

    public People findByUsername(String username) throws OperationNotSupportedException {
        if (username == null
                || !this.hasPeopleWithThisName(username)) {
            throw new OperationNotSupportedException();
        }
        return this.storedPeople.stream()
                .filter(p -> p.getUsername().equals(username))
                .findAny()
                .get();
    }

    public People findById(long id) throws OperationNotSupportedException {
        if (!hasUserWithThisId(id)) {
            throw new OperationNotSupportedException();
        }
        return this.storedPeople.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .get();
    }
}
