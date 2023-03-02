package nl.han.dea.joost.presentation.track;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.service.track.TrackService;

import static nl.han.dea.joost.service.login.AuthenticationService.authenticateToken;

@Path("/tracks")
public class Tracks {

    private TrackService trackService;

    @Inject
    public void setTrackService(TrackService TrackService) {
        this.trackService = TrackService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTracks(@QueryParam("token") String token, @QueryParam("forPlaylist") int playlistId) {
        if (!authenticateToken(token)){
            return Response.status(401).build();
        }
        return trackService.getTracks(playlistId);
    }



}
