package p05_onlineRadioDatabase;

import p05_onlineRadioDatabase.exceptions.InvalidSongException;
import p05_onlineRadioDatabase.models.OnlineRadioDatabase;
import p05_onlineRadioDatabase.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OnlineRadioDatabase radioDatabase = new OnlineRadioDatabase();

        int songsAmount = Integer.parseInt(reader.readLine());
        while (songsAmount-- > 0) {
            String[] songTokens = reader.readLine().split(";");

            try {
                Song song = createNewSong(songTokens);
                radioDatabase.addNewSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException ise) {
                System.out.println(ise.getMessage());
            }
        }

        System.out.println(radioDatabase);
    }

    private static Song createNewSong(String[] songTokens) {
        String artistName = songTokens[0];
        String songName = songTokens[1];
        String duration = songTokens[2];

        return new Song(artistName, songName, duration);
    }
}
