package nl.han.dea.joost.resource.playlist;

import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.service.login.AuthenticationService;
import nl.han.dea.joost.service.playlist.PlaylistService;
import nl.han.dea.joost.service.track.TrackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class playlistTest {

    private Playlist sut;
    private PlaylistService mockedPlaylistService;
    private TrackService mockedTrackService;

    private AuthenticationService mockedAuthenticationService;

    @BeforeEach
    void setUp() {
        //arrange
        sut = new Playlist();
        mockedAuthenticationService = Mockito.mock(AuthenticationService.class);
    }


    @Test
    void setPlaylistService() {
        //arrange
        mockedPlaylistService = Mockito.mock(PlaylistService.class);
        sut.setPlaylistService(mockedPlaylistService);

        //act
        var result = sut.getPlaylistService();

        //assert
        Assertions.assertEquals(mockedPlaylistService, result);
    }

    @Test
    void setTrackService() {
        //arrange
        mockedTrackService = Mockito.mock(TrackService.class);
        sut.setTrackService(mockedTrackService);

        //act
        var result = sut.getTrackService();

        //assert
        Assertions.assertEquals(mockedTrackService, result);
    }

    @Test
    void getPlaylists() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.getPlaylists()).thenReturn(returnValue);

        //act
        this.sut.setPlaylistService(fixture);
        sut.getPlaylists();

        //assert
        Mockito.verify(fixture).getPlaylists();
    }

    @Test
    void addPlaylist() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.addPlaylist(Mockito.any())).thenReturn(returnValue);

        Mockito.when(mockedAuthenticationService.authenticateToken(Mockito.anyString())).thenReturn(true);

        //act
        this.sut.setPlaylistService(fixture);
        sut.addPlaylist("1234-1234-1234", null);

        //assert
        Mockito.verify(fixture).addPlaylist(Mockito.any());
    }

    @Test
    void addPlaylistAuthenticateTokenIsFalse(){
        //arrange
        var returnValue = false;
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticateToken(Mockito.anyString())).thenReturn(returnValue);

        //act
        this.sut.setAuthenticationService(fixture);
        var result = sut.addPlaylist("1234-1234-1234", null);

        //assert
        Assertions.assertEquals(401, result.getStatus());
    }

    @Test
    void deletePlaylist() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.deletePlaylist(Mockito.anyInt())).thenReturn(returnValue);

        //act
        this.sut.setPlaylistService(fixture);
        sut.deletePlaylist(1, "1234-1234-1234");


        //assert
        Mockito.verify(fixture).deletePlaylist(Mockito.anyInt());
    }

    @Test
    void deletePlaylistAuthenticateTokenIsFalse(){
        //arrange
        var returnValue = false;
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticateToken(Mockito.anyString())).thenReturn(returnValue);

        //act
        this.sut.setAuthenticationService(fixture);
        var result = sut.deletePlaylist(1, "1234-1234-1234");

        //assert
        Assertions.assertEquals(401, result.getStatus());
    }

    @Test
    void editPlaylist() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.editPlaylist(Mockito.anyInt(), Mockito.any())).thenReturn(returnValue);

        //act
        this.sut.setPlaylistService(fixture);
        sut.editPlaylist(1, "1234-1234-1234", null);

        //assert
        Mockito.verify(fixture).editPlaylist(Mockito.anyInt(), Mockito.any());
    }

    @Test
    void editPlaylistAuthenticateTokenIsFalse(){
        //arrange
        var returnValue = false;
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticateToken(Mockito.anyString())).thenReturn(returnValue);

        //act
        this.sut.setAuthenticationService(fixture);
        var result = sut.editPlaylist(1, "1234-1234-1234", null);

        //assert
        Assertions.assertEquals(401, result.getStatus());
    }

    @Test
    void getTracksPath() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        this.sut.setTrackService(fixture);
        sut.getTracksPath("1234-1234-1234", 1);

        //assert
        Mockito.verify(fixture).getTracks(Mockito.anyInt());
    }

    @Test
    void addTrack() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.addTrack(Mockito.anyInt(), Mockito.any())).thenReturn(returnValue);

        //act
        this.sut.setTrackService(fixture);
        sut.addTrack("1234-1234-1234", 1, null);

        //assert
        Mockito.verify(fixture).addTrack(Mockito.anyInt(), Mockito.any());
    }

    @Test
    void addTrackAuthenticateTokenIsFalse(){
        //arrange
        var returnValue = false;
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticateToken(Mockito.anyString())).thenReturn(returnValue);

        //act
        this.sut.setAuthenticationService(fixture);
        var result = sut.addTrack("1234-1234-1234", 1, null);

        //assert
        Assertions.assertEquals(401, result.getStatus());
    }

    @Test
    void deleteTrack() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.deleteTrack(Mockito.anyInt(), Mockito.anyInt())).thenReturn(returnValue);

        //act
        this.sut.setTrackService(fixture);
        sut.deleteTrack("1234-1234-1234", 1, 1);

        //assert
        Mockito.verify(fixture).deleteTrack(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void deleteTrackAuthenticateTokenIsFalse(){
        //arrange
        var returnValue = false;
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticateToken(Mockito.anyString())).thenReturn(returnValue);

        //act
        this.sut.setAuthenticationService(fixture);
        var result = sut.deleteTrack("1234-1234-1234", 1, 1);

        //assert
        Assertions.assertEquals(401, result.getStatus());
    }
}