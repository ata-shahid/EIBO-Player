package entities;

public class Track {

    private String title;
    private String artistName;
    private String albumTitle;
    private int length;
    private String soundFile;
    private long id;

    public Track(String title, String artistName, String albumTitle, int length, String soundFile, long id) {
        this.title = title;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
        this.length = length;
        this.soundFile = soundFile;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getLength() {
        return length;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public long getId() {
        return id;
    }

}