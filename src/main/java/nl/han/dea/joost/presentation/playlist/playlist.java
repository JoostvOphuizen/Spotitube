package nl.han.dea.joost.presentation.playlist;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/playlists")
public class playlist {

    @GET
    public Response getPlaylists() {
        Response response = Response.ok().entity(PlaylistService.getPlaylists()).build();
        if(response == null) {
            return Response.status(404).build();
        }
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPlaylist(@QueryParam("token") String token, Playlist playlist) {
        //check authorization from token

        PlaylistService.addPlaylist(playlist);

        return Response.status(201).entity(PlaylistService.getPlaylists()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlaylist(@PathParam("id") int id, @QueryParam("token") String token) {
        //check authorization from token

        if (PlaylistService.doesPlaylistExist(id)) {
            return Response.status(404).build();
        }
        PlaylistService.deletePlaylist(id);

        return Response.status(200).entity(PlaylistService.getPlaylists()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPlaylist(@PathParam("id") int id, @QueryParam("token") String token, Playlist playlist) {
        //check authorization from token

        if (PlaylistService.doesPlaylistExist(id)) {
            return Response.status(404).build();
        }
        PlaylistService.editPlaylist(id, playlist);

        return Response.status(200).entity(PlaylistService.getPlaylists()).build();
    }

}
