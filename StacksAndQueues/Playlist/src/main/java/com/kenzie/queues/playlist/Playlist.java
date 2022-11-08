package com.kenzie.queues.playlist;

import com.kenzie.queues.playlist.models.Song;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Playlist {

    private Queue<Song> playlist;

    /**
     * Constructor.
     */
    public Playlist() {
        playlist = new LinkedList<>();
    }

    /**
     * Provides the next song to be played from this playlist.
     * Once a song is played it will not be available to be played again.
     * @return The next Song in the playlist, or null if the playlist is empty.
     */
    public Song getNextSong() {
        //  implement this
        if (playlist.isEmpty()) {
            return null;
        } else {
            return playlist.remove();
        }
    }

    /**
     * Adds a Song to the end of the playlist.
     * @param song the song to be added to the playlist.
     */
    public void addSong(Song song) {
        // implement this
        playlist.add(song);
    }

}
