package p06_twitter.interfaces;

public interface Client {

    void writeTweet(String message);

    void sentTweetToServer(String message);
}
