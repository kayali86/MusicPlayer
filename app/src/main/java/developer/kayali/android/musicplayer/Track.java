package developer.kayali.android.musicplayer;

public class Track {
    private String mName, mAlbum, mArtist;
    private int mImagePath;
    private double mDuration;
    private boolean mFavorite;
    // The Constructor
    public Track(String name, String album, String artist, int imagePath, double duration, boolean favorite){
        this.mName = name;
        this.mAlbum = album;
        this.mArtist = artist;
        this.mImagePath = imagePath;
        this.mDuration = duration;
        this.mFavorite = favorite;
    }
    // Getters
    public String getmName() {
        return mName;
    }
    public String getmAlbum() {
        return mAlbum;
    }
    public String getmArtist() {
        return mArtist;
    }
    public int getmImagePath() {
        return mImagePath;
    }
    public double getmDuration() {
        return mDuration;
    }
    public boolean getmFavorite(){
        return mFavorite;
    }
}
