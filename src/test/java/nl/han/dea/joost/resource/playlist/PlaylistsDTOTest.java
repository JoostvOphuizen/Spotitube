package nl.han.dea.joost.resource.playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistsDTOTest {

    private PlaylistsDTO sut;

    @BeforeEach
    void setUp() {
        sut = new PlaylistsDTO();
    }

    @Test
    void testToString() {
        //arrange
        var expected = "{\"playlists\": ],\"length\": 0}";
        var playlists = new PlaylistDTO[0];
        sut.setPlaylists(playlists);
        sut.setLength(0);

        //act
        String result = sut.toString();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void getPlaylists() {
        //arrange
        var expected = new PlaylistDTO[0];
        sut.setPlaylists(expected);

        //act
        var result = sut.getPlaylists();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setPlaylists() {
        //arrange
        var expected = new PlaylistDTO[0];

        //act
        sut.setPlaylists(expected);

        //assert
        assertEquals(expected, sut.getPlaylists());
    }

    @Test
    void getLength() {
        //arrange
        var expected = 0;
        sut.setLength(expected);

        //act
        var result = sut.getLength();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setLength() {
        //arrange
        var expected = 0;

        //act
        sut.setLength(expected);

        //assert
        assertEquals(expected, sut.getLength());
    }
}