package p06_twitter.repository;

import p06_twitter.interfaces.Repo;

import java.util.LinkedList;
import java.util.List;

public class ServerRepository implements Repo {

    private List<String> messages;

    public ServerRepository() {
        this.messages = new LinkedList<>();
    }

    @Override
    public void saveTweet(String content) {
        this.messages.add(content);
    }
}
