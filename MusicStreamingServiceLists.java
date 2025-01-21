import java.util.*;
import java.time.Duration;

class Song {
    private String title;
    private String artist;
    private Duration duration;
    private String genre;
    private String filePath;

    public Song(String title, String artist, Duration duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}

class Playlist {
    private String name;
    private List<Song> songs = new ArrayList<>();
    private boolean isShuffled = false;

    public void addSong(Song song) {
        songs.add(song);
    }

    public void shuffle() {
        if (!isShuffled) {
            Collections.shuffle(songs);
            isShuffled = true;
        }
    }

    public void resetOrder() {
        if (isShuffled) {
            // Restore original order
            isShuffled = false;
        }
    }
}

class MusicPlayer {
    private Queue<Song> playQueue = new LinkedList<>();
    private Song currentSong;
    private boolean isPlaying = false;

    public void play() {
        if (currentSong == null && !playQueue.isEmpty()) {
            currentSong = playQueue.poll();
        }
        isPlaying = true;
        // Start playing current song
    }

    public void pause() {
        isPlaying = false;
        // Pause current song
    }

    public void addToQueue(Song song) {
        playQueue.offer(song);
    }

    public void skipToNext() {
        if (!playQueue.isEmpty()) {
            currentSong = playQueue.poll();
            if (isPlaying) {
                // Start playing new song
            }
        }
    }
}