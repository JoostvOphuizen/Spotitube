package nl.han.dea.joost.resource.track;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.datasource.exceptions.TokenIsNotValidException;
import nl.han.dea.joost.service.login.AuthenticationService;
import nl.han.dea.joost.service.track.TrackService;

@Path("/tracks")
public class Tracks {

    private TrackService trackService;

    private AuthenticationService authenticationService;

    @Inject
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Inject
    public void setTrackService(TrackService TrackService) {
        this.trackService = TrackService;
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTracks(@QueryParam("token") String token, @QueryParam("forPlaylist") int playlistId) {
        try {
            authenticationService.authenticateToken(token);
        } catch (TokenIsNotValidException e) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .build();
        }
        return trackService.getTracks(playlistId);
    }

}
