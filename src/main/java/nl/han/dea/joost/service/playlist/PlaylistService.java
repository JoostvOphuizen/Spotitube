package nl.han.dea.joost.service.playlist;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.database.DataBase;
import nl.han.dea.joost.resource.playlist.PlaylistDTO;

public class PlaylistService {

    private DataBase dataBase;

    @Inject
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Response getPlaylists() {
        String playlistString = dataBase.getPlaylists().toString();
        return Response.status(200).entity(playlistString).build();
    }

    public Response addPlaylist(PlaylistDTO playlist) {
        dataBase.addPlaylist(playlist);
        return getPlaylists();
    }

    public Response deletePlaylist(int id) {
        dataBase.deletePlaylist(id);
        return getPlaylists();
    }

    public Response editPlaylist(int id, PlaylistDTO playlist) {
        dataBase.editPlaylist(id, playlist);
        return getPlaylists();
    }
}
