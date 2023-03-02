package nl.han.dea.joost.presentation.track;

import jakarta.ws.rs.Path;

@Path("/playlists")
public class Tracks {

    /*@GET
    @Path("/{id}/tracks")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTracks(@QueryParam("token") String token, @QueryParam("forPlaylist") int id, @PathParam("id") int playlistId) {
        return Response.status(201).entity(TrackService.getTracks(playlistId)).build();
    }

    @POST
    @Path("/{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrack(@QueryParam("token") String token, @QueryParam("forPlaylist") int id, @PathParam("id") int trackId) {
        //check authorization from token

        TrackService.addTrack(id, trackId);

        return Response.status(201).entity(TrackService.getTracksExceptPlaylistTracks(id)).build();
    }*/

}
