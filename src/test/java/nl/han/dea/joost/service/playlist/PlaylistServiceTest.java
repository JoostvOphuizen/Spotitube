package nl.han.dea.joost.service.playlist;

import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.database.DataBase;
import nl.han.dea.joost.resource.playlist.PlaylistDTO;
import nl.han.dea.joost.resource.playlist.PlaylistsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlaylistServiceTest {

    private PlaylistService sut;
    private DataBase mockedDataBase;
    @BeforeEach
    void setUp() {
        sut = new PlaylistService();
        mockedDataBase = Mockito.mock(DataBase.class);
    }

    @Test
    void setDataBase() {
        //arrange
        sut.setDataBase(mockedDataBase);

        //act
        var result = sut.getDataBase();

        //assert
        Assertions.assertEquals(mockedDataBase, result);
    }

    @Test
    void getPlaylists() {
        //arrange
        var returnValue = Mockito.mock(PlaylistsDTO.class);
        Mockito.when(mockedDataBase.getPlaylists()).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.getPlaylists();

        //assert
        Mockito.verify(mockedDataBase).getPlaylists();
    }

    @Test
    void addPlaylistReturnValueTest() {
        //assert
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.getPlaylists()).thenReturn(returnValue);

        //act
        var result = fixture.getPlaylists();

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void addPlaylistDatabaseAddPlaylistTest() {
        //arrange
        var returnValue = Mockito.mock(PlaylistsDTO.class);
        Mockito.when(mockedDataBase.getPlaylists()).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.addPlaylist(Mockito.mock(PlaylistDTO.class));

        //assert
        Mockito.verify(mockedDataBase).getPlaylists();
    }

    @Test
    void deletePlaylistReturnValueTest() {
        //assert
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.getPlaylists()).thenReturn(returnValue);

        //act
        var result = fixture.getPlaylists();

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void deletePlaylistDatabaseDeletePlaylistTest() {
        //arrange
        var returnValue = Mockito.mock(PlaylistsDTO.class);
        Mockito.when(mockedDataBase.getPlaylists()).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.deletePlaylist(1);

        //assert
        Mockito.verify(mockedDataBase).getPlaylists();
    }

    @Test
    void editPlaylistReturnValueTest() {
        //assert
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(PlaylistService.class);
        Mockito.when(fixture.getPlaylists()).thenReturn(returnValue);

        //act
        var result = fixture.getPlaylists();

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void editPlaylistDatabaseEditPlaylistTest(){
        //arrange
        var returnValue = Mockito.mock(PlaylistsDTO.class);
        Mockito.when(mockedDataBase.getPlaylists()).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.editPlaylist(1, Mockito.mock(PlaylistDTO.class));

        //assert
        Mockito.verify(mockedDataBase).getPlaylists();
    }
}