package p06_twitter.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p06_twitter.interfaces.Client;
import p06_twitter.interfaces.Repo;
import p06_twitter.interfaces.Tweet;
import p06_twitter.repository.ServerRepository;

public class TweetImplTest {

    private final String DEFAULT_TEST_MSG = "Test";

    private Tweet tweet;
    private Client client;
    private Repo repo;

    @Before
    public void setUp() throws Exception {
        this.repo = new ServerRepository();
        this.client = new MicrowaveOven(this.repo);
        this.client = Mockito.mock(Client.class);
        this.tweet = new TweetImpl(this.client);
    }

    @Test
    public void receiveMessageShouldInvokeItsClientToWriteTheMessage() {
        //Arrange

        //Act
        this.tweet.receiveMessage(Mockito.anyString());

        //Assert
        Mockito.verify(this.client, Mockito.times(1))
                .writeTweet(Mockito.anyString());
    }

    @Test
    public void receiveMessageShouldInvokeItsClientToSendTheMessageToTheServer() {
        //Arrange

        //Act
        this.tweet.receiveMessage(DEFAULT_TEST_MSG);

        //Assert
        Mockito.verify(this.client, Mockito.times(1)).sentTweetToServer(Mockito.anyString());
    }
}