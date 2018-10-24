package p05_onlineRadioDatabase.models;

import p05_onlineRadioDatabase.exceptions.*;

public class Song {

    private String artistName;
    private String songName;
    private int minute;
    private int seconds;

    public Song(String artistName, String songName, String duration) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setDuration(duration);
    }

    public String getArtistName() {
        return this.artistName;
    }

    private void setArtistName(String artistName) {
        /**Artist name should be between 3 and 20 symbols.*/
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    private void setSongName(String songName) {
        /** Song name should be between 3 and 30 symbols.*/
        if (songName == null || songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    private void setDuration(String duration) {
        String[] durationParams = duration.split(":");
        int minutes;
        int seconds;

        try {
            minutes = Integer.parseInt(durationParams[0]);
            seconds = Integer.parseInt(durationParams[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException();
        }

        this.setMinute(minutes);
        this.setSeconds(seconds);
    }

    public int getMinute() {
        return this.minute;
    }

    private void setMinute(int minute) {
        /**Song minutes should be between 0 and 14.*/
        if (minute < 0 || minute > 14) {
            throw new InvalidSongMinutesException();
        }
        this.minute = minute;
    }

    public int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds) {
        /**Song seconds should be between 0 and 59.*/
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }
}
