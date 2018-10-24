package com.company.onlineRadioDatabase.models;

public class SongDatabase {

    private int songCount;
    private long durationInSeconds;

    public SongDatabase() {

    }

    public void addSong(Song song) {
        this.songCount++;
        long duration = song.getSeconds() + song.getMinutes() * 60;
        this.durationInSeconds += duration;
    }

    @Override
    public String toString() {
        long totalTime = this.durationInSeconds;
        long hours = totalTime / 3600;
        totalTime %= 3600;
        long mins = totalTime / 60;
        totalTime %= 60;
        long secs = totalTime;

        String timeStr = String.format("%dh %dm %ds", hours, mins, secs);

        return String.format("Songs added: %d%n" +
                        "Playlist length: %s%n",
                this.songCount,
                timeStr);
    }
}
