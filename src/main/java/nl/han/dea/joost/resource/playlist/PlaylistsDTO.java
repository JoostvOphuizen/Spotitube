package nl.han.dea.joost.resource.playlist;

public class PlaylistsDTO {

    private PlaylistDTO[] playlists;
    private int length;

    public String toString() {
        String playlistString = "{";
        playlistString += "\"playlists\": [";
        for (PlaylistDTO playlist : playlists) {
            playlistString += playlist.toString() + ",";
        }
        playlistString = playlistString.substring(0, playlistString.length() - 1);
        playlistString += "],";
        playlistString += "\"length\": " + length;
        playlistString += "}";
        return playlistString;
    }

    public PlaylistDTO[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(PlaylistDTO[] playlists) {
        this.playlists = playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
