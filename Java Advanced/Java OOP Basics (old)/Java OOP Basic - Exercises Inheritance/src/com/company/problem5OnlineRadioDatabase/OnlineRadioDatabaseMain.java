package com.company.problem5OnlineRadioDatabase;

import com.company.problem5OnlineRadioDatabase.exceptions.InvalidSongException;
import com.company.problem5OnlineRadioDatabase.models.Song;
import com.company.problem5OnlineRadioDatabase.models.SongDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlineRadioDatabaseMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SongDatabase database = new SongDatabase();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] inputParams = reader.readLine().split(";");
            addSongToDatabase(inputParams, database);
        }

        System.out.println(database);
    }

    private static void addSongToDatabase(String[] inputParams, SongDatabase database) {
        String artistName = inputParams[0];
        String songName = inputParams[1];
        String duration = inputParams[2];

        try {
            Song song = new Song(artistName, songName, duration);
            database.addSong(song);
            System.out.println("Song added.");
        }
        catch (InvalidSongException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
