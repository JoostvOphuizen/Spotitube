package nl.han.dea.joost.service.track;

import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.database.DataBase;
import nl.han.dea.joost.resource.track.TracksDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TrackServiceTest {

    private TrackService sut;
    private DataBase mockedDataBase;

    @BeforeEach
    void setup(){
        sut = new TrackService();
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
    void getTracksReturnValueTest() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        var result = fixture.getTracks(Mockito.anyInt());

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void getTracksDatabaseGetTracksTest() {
        //arrange
        var returnValue = Mockito.mock(TracksDTO.class);
        Mockito.when(mockedDataBase.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.getTracks(Mockito.anyInt());

        //assert
        Mockito.verify(mockedDataBase).getTracks(Mockito.anyInt());
    }

    @Test
    void addTrackReturnValueTest() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.addTrack(Mockito.anyInt(), Mockito.anyInt())).thenReturn(returnValue);

        //act
        var result = fixture.addTrack(Mockito.anyInt(), Mockito.anyInt());

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void addTrackDatabaseAddTrackTest() {
        //arrange
        var returnValue = Mockito.mock(TracksDTO.class);
        Mockito.when(mockedDataBase.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.addTrack(Mockito.anyInt(), Mockito.anyInt());

        //assert
        Mockito.verify(mockedDataBase).addTrack(Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    void addTrackReturnValueTest2() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.addTrack(Mockito.anyInt(), Mockito.any())).thenReturn(returnValue);

        //act
        var result = fixture.addTrack(Mockito.anyInt(), Mockito.any());

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void addTrackDatabaseAddTrackTest2() {
        //arrange
        var returnValue = Mockito.mock(TracksDTO.class);
        Mockito.when(mockedDataBase.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.addTrack(Mockito.anyInt(), Mockito.any());

        //assert
        Mockito.verify(mockedDataBase).addTrack(Mockito.anyInt(), Mockito.any());
    }

    @Test
    void deleteTrackReturnValueTest() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(TrackService.class);
        Mockito.when(fixture.deleteTrack(Mockito.anyInt(), Mockito.anyInt())).thenReturn(returnValue);

        //act
        var result = fixture.deleteTrack(Mockito.anyInt(), Mockito.anyInt());

        //assert
        Assertions.assertEquals(returnValue, result);
    }

    @Test
    void deleteTrackDatabaseDeleteTrackFromPlaylistTest() {
        //arrange
        var returnValue = Mockito.mock(TracksDTO.class);
        Mockito.when(mockedDataBase.getTracks(Mockito.anyInt())).thenReturn(returnValue);

        //act
        sut.setDataBase(mockedDataBase);
        sut.deleteTrack(Mockito.anyInt(), Mockito.anyInt());

        //assert
        Mockito.verify(mockedDataBase).deleteTrackFromPlaylist(Mockito.anyInt(), Mockito.anyInt());
    }



}