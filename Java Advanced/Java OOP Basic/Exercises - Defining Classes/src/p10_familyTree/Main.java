package p10_familyTree;
import p10_familyTree.models.Children;
import p10_familyTree.models.Parent;
import p10_familyTree.models.Person;
import p10_familyTree.util.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> personsDB = new LinkedHashMap<>();
        List<String> inputLines = new LinkedList<>();

        String keyLine = reader.readLine();
        fillDatabasesFromInput(reader, personsDB, inputLines);
        Person keyPerson = getPersonForFamilyTree(keyLine, personsDB);

        for (String line : inputLines) {
            if (line.matches(Config.REGEX_NAME_DATE)) {
                extractDataByRegexND(personsDB, keyPerson, line);

            } else if (line.matches(Config.REGEX_DATE_NAME)) {
                extractDataByRegexDN(personsDB, keyPerson, line);

            } else if (line.matches(Config.REGEX_NAME_NAME)) {
                extractDataByRegexNN(personsDB, keyPerson, line);

            } else if (line.matches(Config.REGEX_DATE_DATE)) {
                extractDataByRegexDD(personsDB, keyPerson, line);
            }
        }

        System.out.println(keyPerson);

    }

    private static void extractDataByRegexDD(Map<String, String> personsDB, Person keyPerson, String line) {
        String parentBirth = produceString(Config.REGEX_DATE_DATE, Config.DATE1_GROUP, line);
        String childBirth = produceString(Config.REGEX_DATE_DATE, Config.DATE2_GROUP, line);

        if (parentBirth.equals(keyPerson.getBirthday())) {
            //if our dude is the father
            Children children = getChildByBirthDate(personsDB, childBirth);
            keyPerson.addChildren(children);
        } else if (childBirth.equals(keyPerson.getBirthday())) {
            //if our dude is the kid
            Parent parent = getParentByBirthDate(personsDB, parentBirth);
            keyPerson.addParent(parent);
        }
    }

    private static void extractDataByRegexNN(Map<String, String> personsDB, Person keyPerson, String line) {
        String parentName = produceString(Config.REGEX_NAME_NAME, Config.NAME1_GROUP, line);
        String childName = produceString(Config.REGEX_NAME_NAME, Config.NAME2_GROUP, line);

        if (parentName.equals(keyPerson.getName())) {
            //if our dude is the father
            Children children = getChildByName(personsDB, childName);
            keyPerson.addChildren(children);
        } else if (childName.equals(keyPerson.getName())) {
            //if our dude is the kid
            Parent parent = getParentByParentName(personsDB, parentName);
            keyPerson.addParent(parent);
        }
    }

    private static void extractDataByRegexDN(Map<String, String> personsDB, Person keyPerson, String line) {
        String parentBirth = produceString(Config.REGEX_DATE_NAME, Config.DATE_GROUP, line);
        String childName = produceString(Config.REGEX_DATE_NAME, Config.NAME_GROUP, line);

        if (parentBirth.equals(keyPerson.getBirthday())) {
            //if our dude is the father
            Children child = getChildByName(personsDB, childName);
            keyPerson.addChildren(child);
        } else if (childName.equals(keyPerson.getName())) {
            //if our dude is the kid
            Parent parent = getParentByBirthDate(personsDB, parentBirth);
            keyPerson.addParent(parent);
        }
    }

    private static void extractDataByRegexND(Map<String, String> personsDB, Person keyPerson, String line) {
        String parentName = produceString(Config.REGEX_NAME_DATE, Config.NAME_GROUP, line);
        String childBirth = produceString(Config.REGEX_NAME_DATE, Config.DATE_GROUP, line);

        if (parentName.equals(keyPerson.getName())) {
            //if our dude is the father
            Children child = getChildByBirthDate(personsDB, childBirth);
            keyPerson.addChildren(child);
        } else if (childBirth.equals(keyPerson.getBirthday())) {
            //if our dude is the kid
            Parent parent = getParentByParentName(personsDB, parentName);
            keyPerson.addParent(parent);
        }
    }

    private static Parent getParentByBirthDate(Map<String,String> personsDB, String parentBirth) {
        Parent parent = null;
        for (String name : personsDB.keySet()) {
            if (personsDB.get(name).equals(parentBirth)) {
                parent = new Parent(name, parentBirth);
                break;
            }
        }
        return parent;
    }

    private static Children getChildByName(Map<String,String> personsDB, String childName) {
        Children children = null;
        for (String name : personsDB.keySet()) {
            if (name.equals(childName)) {
                children = new Children(name, personsDB.get(name));
                break;
            }
        }
        return children;
    }

    private static Parent getParentByParentName(Map<String,String> personsDB, String parentName) {
        Parent parent = null;
        for (String name : personsDB.keySet()) {
            if (name.equals(parentName)) {
                parent = new Parent(name, personsDB.get(name));
                break;
            }
        }
        return parent;
    }

    private static Children getChildByBirthDate(Map<String,String> personsDB, String childBirth) {
        Children children = null;
        for (String name : personsDB.keySet()) {
            if (personsDB.get(name).equals(childBirth)) {
                children = new Children(name, childBirth);
                break;
            }
        }
        return children;
    }

    private static void fillDatabasesFromInput(BufferedReader reader, Map<String, String> personsDB, List<String> inputLines) throws IOException {
        String line;
        while (!Config.STOP.equalsIgnoreCase(line = reader.readLine())) {
            if (line.matches(Config.REGEX_PERSON_BIRTH)) {
                String name = produceString(Config.REGEX_PERSON_BIRTH, Config.NAME_GROUP, line);
                String birth = produceString(Config.REGEX_PERSON_BIRTH, Config.DATE_GROUP, line);
                personsDB.put(name, birth);
                continue;
            }
            inputLines.add(line);
        }
    }

    private static String produceString(String regex, String group, String line) {
        Matcher matcher = Pattern.compile(regex).matcher(line);
        matcher.find();
        return matcher.group(group);
    }

    private static Person getPersonForFamilyTree(String keyWord, Map<String, String> personsDB) {
        Person person = new Person();
        if (keyWord.contains("/")) {    //date
            person.setBirthday(keyWord);
        } else {    //name
            person.setName(keyWord);
        }

        findAndFillMoreDataForOurDude(personsDB, person);
        personsDB.remove(person.getName());

        return person;
    }

    private static void findAndFillMoreDataForOurDude(Map<String, String> personsDB, Person person) {
        if (person.getName() != null) {
            String birthDate = personsDB.get(person.getName());
            person.setBirthday(birthDate);
        } else {
            for (String name : personsDB.keySet()) {
                if (personsDB.get(name).equals(person.getBirthday())) {
                    person.setName(name);
                }
            }
        }
    }
}
