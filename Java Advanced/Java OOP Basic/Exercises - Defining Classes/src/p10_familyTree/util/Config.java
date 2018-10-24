package p10_familyTree.util;

public class Config {

    public static final String STOP = "End";
    public static final String REGEX_NAME_DATE = "^(?<name>\\w+\\s\\w+)(\\s[-]\\s)(?<date>\\d{1,2}\\/\\d{1,2}\\/\\d{4})$";
    public static final String REGEX_DATE_NAME = "^(?<date>\\d{1,2}\\/\\d{1,2}\\/\\d{4})(\\s[-]\\s)(?<name>\\w+\\s\\w+)$";
    public static final String REGEX_NAME_NAME = "^(?<name1>\\w+\\s\\w+)(\\s[-]\\s)(?<name2>\\w+\\s\\w+)$";
    public static final String REGEX_DATE_DATE = "^(?<date1>\\d{1,2}\\/\\d{1,2}\\/\\d{4})(\\s[-]\\s)(?<date2>\\d{1,2}\\/\\d{1,2}\\/\\d{4})$";
    public static final String REGEX_PERSON_BIRTH = "^(?<name>\\w+\\s\\w+)\\s(?<date>\\d{1,2}\\/\\d{1,2}\\/\\d{4})$";
    public static final String NAME_GROUP = "name";
    public static final String NAME1_GROUP = "name1";
    public static final String NAME2_GROUP = "name2";
    public static final String DATE_GROUP = "date";
    public static final String DATE1_GROUP = "date1";
    public static final String DATE2_GROUP = "date2";

}
