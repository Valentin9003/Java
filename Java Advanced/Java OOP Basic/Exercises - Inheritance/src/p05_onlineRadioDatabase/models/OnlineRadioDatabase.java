package p05_onlineRadioDatabase.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnlineRadioDatabase {

    private List<Song> songsDB;

    public OnlineRadioDatabase() {
        this.songsDB = new ArrayList<>();
    }

    public void addNewSong(Song song) {
        this.songsDB.add(song);
    }

    public List<Song> getPlayList() {
        return Collections.unmodifiableList(this.songsDB);
    }

    public String getPlayListLength() {
        return calculatePlayListLengthAndConstructResult();
    }

    private String calculatePlayListLengthAndConstructResult() {
        long sumMinutes = this.getPlayList().stream().mapToLong(Song::getMinute).sum();
        long sumSeconds = this.getPlayList().stream().mapToLong(Song::getSeconds).sum();

        long fullTimeInSec = sumMinutes * 60 + sumSeconds;

        long hours = fullTimeInSec / 3600;
        long restTimeInSec = fullTimeInSec % 3600;
        long minutes = restTimeInSec / 60;
        long seconds = restTimeInSec % 60;

        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Songs added: %d", this.getPlayList().size()))
                .append(System.lineSeparator())
                .append(String.format("Playlist length: %s", this.getPlayListLength()));

        return sb.toString();
    }
}
