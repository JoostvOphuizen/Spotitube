package nl.han.dea.joost.presentation.playlist;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.resource.playlist.PlaylistDTO;
import nl.han.dea.joost.resource.track.TrackDTO;
import nl.han.dea.joost.service.playlist.PlaylistService;
import nl.han.dea.joost.service.track.TrackService;

import static nl.han.dea.joost.service.login.AuthenticationService.authenticateToken;

@Path("/playlists")
public class playlist {

    private PlaylistService playlistService;

    @Inject
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    private TrackService trackService;

    @Inject
    public void setTrackService(TrackService TrackService) {
        this.trackService = TrackService;
    }

    @GET
    public Response getPlaylists() {
        return playlistService.getPlaylists();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token, PlaylistDTO playlist) {
        if (!authenticateToken(token)) {
            return Response.status(401).build();
        }
        return playlistService.addPlaylist(playlist);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@PathParam("id") int id, @QueryParam("token") String token) {
        if (!authenticateToken(token)) {
            return Response.status(401).build();
        }
        return playlistService.deletePlaylist(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPlaylist(@PathParam("id") int id, @QueryParam("token") String token, PlaylistDTO playlist) {
        if (!authenticateToken(token)) {
            return Response.status(401).build();
        }
        return playlistService.editPlaylist(id, playlist);
    }

    @GET
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTracksPath(@QueryParam("token") String token, @PathParam("id") int playlistId) {
        if (!authenticateToken(token)){
            return Response.status(401).build();
        }
        return trackService.getTracks(playlistId);
    }
    @POST
    @Path("{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrack(@QueryParam("token") String token, @PathParam("id") int playlistID, TrackDTO trackDTO) {
        if (!authenticateToken(token)){
            return Response.status(401).build();
        }
        return trackService.addTrack(playlistID, trackDTO);
    }

    @DELETE
    @Path("{id}/tracks/{trackId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrack(@QueryParam("token") String token, @PathParam("trackId") int trackId, @PathParam("id") int playlistId) {
        if (!authenticateToken(token)){
            return Response.status(401).build();
        }
        return trackService.deleteTrack(trackId, playlistId);
    }

}
