package nl.han.dea.joost.resource.track;

public class TracksDTO {

    private TrackDTO[] tracks;
    private int length;

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        result.append("\"tracks\": [");
        for (int i = 0; i < tracks.length; i++) {
            result.append(tracks[i].toString());
            if (i < tracks.length - 1) {
                result.append(",");
            }
        }
        result.append("]}");
        return result.toString();
    }

    public TrackDTO[] getTracks() {
        return tracks;
    }

    public void setTracks(TrackDTO[] tracks) {
        this.tracks = tracks;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
