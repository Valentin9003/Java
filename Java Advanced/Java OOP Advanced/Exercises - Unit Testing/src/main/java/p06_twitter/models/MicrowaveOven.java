package p06_twitter.models;

import p06_twitter.interfaces.Client;
import p06_twitter.interfaces.Repo;
import p06_twitter.interfaces.Writer;
import p06_twitter.io.WriterImpl;

public class MicrowaveOven implements Client {

    private Writer writer;
    private Repo server;

    public MicrowaveOven(Repo repo) {
        this.writer = new WriterImpl();
        this.server = repo;
    }

    @Override
    public void writeTweet(String message) {
        this.writer.writeLine(message);
    }

    @Override
    public void sentTweetToServer(String message) {
        this.server.saveTweet(message);
    }
}
