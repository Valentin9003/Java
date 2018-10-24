package p02_extendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;
import java.util.Random;

public class DatabaseP02Tests {

    private final String DEFAULT_MSG = "Test failed. Wrong: ";
    private final int DEFAULT_LENGTH = 16;
    private final int LENGTH_AFTER_INIT = 14;
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int DEFAULT_LETTER_INDEXES = 52;
    private final int DEFAULT_NAME_LENGTH = 15;
    private final int DEFAULT_ID_NUMBER = 100000;
    private final long DEFAULT_ID = 100001;
    private final String DEFAULT_USER_NAME = "P@sh0";

    private Database db;
    private People mockedPerson;

    @Before
    public void init() throws Exception {
        People[] arr = new People[DEFAULT_LENGTH];
        this.fillArr(arr);
        this.db = new Database(arr);

        this.mockedPerson = Mockito.mock(People.class);
    }

    private void fillArr(People[] arr) {
        Random random = new Random();
        for (int index = 0; index < DEFAULT_LENGTH - 2; index++) {
            String userName = createUserName(random);
            long userID = random.nextInt(DEFAULT_ID_NUMBER);
            arr[index] = new People(userID, userName);
        }
    }

    private String createUserName(Random random) {
        int nameLength = 0;
        while (nameLength < 4) {
            nameLength = random.nextInt(DEFAULT_NAME_LENGTH);
        }
        StringBuilder nameBuilder = new StringBuilder();
        for (int nameLetter = 0; nameLetter < nameLength; nameLetter++) {
            int letterIndex = random.nextInt(DEFAULT_LETTER_INDEXES);
            char letter = ALPHABET.charAt(letterIndex);
            nameBuilder.append(letter);
        }
        return nameBuilder.toString();
    }

    @Test
    public void addElementTest() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(DEFAULT_ID);

        this.db.addElement(this.mockedPerson);

        int actual = this.db.fetch().size();
        int expected = LENGTH_AFTER_INIT + 1;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementWithMultipleUsersWithSameId() throws OperationNotSupportedException {
        this.db.addElement(new People(DEFAULT_ID, DEFAULT_USER_NAME));
        this.db.addElement(new People(DEFAULT_ID, "aAaAa"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementWithNegativeId() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(-DEFAULT_ID);

        this.db.addElement(this.mockedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementWithNullId() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(null);

        this.db.addElement(this.mockedPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementOnFullDatabase() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(DEFAULT_ID);
        this.db.addElement(this.mockedPerson);
        this.db.addElement(new People(DEFAULT_ID + 1, "asd@"));
        this.db.addElement(new People(DEFAULT_ID + 2, "dsa@"));
    }

    @Test
    public void removeElementTest() throws OperationNotSupportedException {
        this.db.removeElement();

        int actual = this.db.fetch().size();
        int expected = LENGTH_AFTER_INIT - 1;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromDatabaseWithNoElements() throws OperationNotSupportedException {
        People[] pplArr = new People[DEFAULT_LENGTH];
        Database database = new Database(pplArr);

        database.removeElement();
    }

    @Test
    public void fetchTest() {
        int actual = this.db.fetch().size();
        int expected = LENGTH_AFTER_INIT;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test
    public void findByUsernameTest() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(DEFAULT_ID);
        this.db.addElement(this.mockedPerson);

        People personByUserName = this.db.findByUsername(DEFAULT_USER_NAME);

        long actual = personByUserName.getId();
        long expected = DEFAULT_ID;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameIfNoUserIsPresentWithThisUsername() throws OperationNotSupportedException {
        this.db.findByUsername(DEFAULT_USER_NAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameIfUsernameParameterIsNull() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ArgumentsAreAllCaseSensitive() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(DEFAULT_ID);
        this.db.addElement(this.mockedPerson);

        People personByUserName = this.db.findByUsername(DEFAULT_USER_NAME.toUpperCase());
    }

    @Test
    public void findByIdTest() throws OperationNotSupportedException {
        Mockito.when(this.mockedPerson.getUsername()).thenReturn(DEFAULT_USER_NAME);
        Mockito.when(this.mockedPerson.getId()).thenReturn(DEFAULT_ID);
        this.db.addElement(this.mockedPerson);

        People personByid = this.db.findById(DEFAULT_ID);

        String actual = personByid.getUsername();
        String expected = DEFAULT_USER_NAME;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdIfNoUserIsPresentWithThisId() throws OperationNotSupportedException {
        this.db.findById(DEFAULT_ID);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfGivenArraySizeIsDifferentFromDefault() throws OperationNotSupportedException {
        People[] arr = new People[DEFAULT_LENGTH + 1];
        Database database = new Database(arr);
    }

    @Test
    public void testConstructorCreateCorrectArrLength() throws OperationNotSupportedException {
        int actual = this.db.fetch().size();
        int expected = LENGTH_AFTER_INIT;

        Assert.assertEquals(DEFAULT_MSG, expected, actual);
    }
}