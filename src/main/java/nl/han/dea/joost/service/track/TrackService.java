package nl.han.dea.joost.service.track;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.database.DataBase;
import nl.han.dea.joost.resource.track.TrackDTO;

public class TrackService {

    private DataBase dataBase;

    @Inject
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Response getTracks(int playlistId) {
        String trackString = dataBase.getTracks(playlistId).toString();
        return Response.status(200).entity(trackString).build();
    }

    public Response addTrack(int playlistId, int trackId) {
        dataBase.addTrack(playlistId, trackId);
        return getTracks(playlistId);
    }

    public Response addTrack(int playlistId, TrackDTO trackDTO) {
        dataBase.addTrack(playlistId, trackDTO);
        return getTracks(playlistId);
    }

    public Response deleteTrack(int trackId, int playlistId) {
        dataBase.deleteTrackFromPlaylist(trackId, playlistId);
        return getTracks(playlistId);
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
