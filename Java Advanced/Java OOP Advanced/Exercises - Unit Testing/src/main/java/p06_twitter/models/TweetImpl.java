package p06_twitter.models;

import p06_twitter.interfaces.Client;
import p06_twitter.interfaces.Tweet;

public class TweetImpl implements Tweet {

    private Client client;

    public TweetImpl(Client client) {
        this.client = client;
    }

    @Override
    public void receiveMessage(String message) {
        this.client.writeTweet(message);
        this.client.sentTweetToServer(message);
    }
}
