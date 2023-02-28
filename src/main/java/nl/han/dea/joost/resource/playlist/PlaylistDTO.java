package nl.han.dea.joost.resource.playlist;

import java.util.Arrays;

public class PlaylistDTO {

    private int id;
    private String name;
    private boolean owner;
    private int[] tracks;

    public String toString() {
        String playlist = "{";
        playlist += "\"id\": " + id + ",";
        playlist += "\"name\": \"" + name + "\",";
        playlist += "\"owner\": " + owner + ",";
        playlist += "\"tracks\": "+"[" + Arrays.toString(tracks)+"]";
        playlist += "}";
        return playlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public int[] getTracks() {
        return tracks;
    }

    public void setTracks(int[] tracks) {
        this.tracks = tracks;
    }

    

}
