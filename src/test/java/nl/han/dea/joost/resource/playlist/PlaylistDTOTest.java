package nl.han.dea.joost.resource.playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistDTOTest {

    private PlaylistDTO sut;

    @BeforeEach
    void setUp() {
        sut = new PlaylistDTO();
    }

    @Test
    void testToString() {
        //arrange
        var expected = "{\"id\": 0,\"name\": \"null\",\"owner\": false,\"tracks\": [[]]}";
        sut.setId(0);
        sut.setName(null);
        sut.setOwner(false);
        sut.setTracks(new int[]{});

        //act
        String result = sut.toString();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void getId() {
        //arrange
        var expected = 0;
        sut.setId(expected);

        //act
        var result = sut.getId();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setId() {
        //arrange
        var expected = 0;

        //act
        sut.setId(expected);

        //assert
        assertEquals(expected, sut.getId());
    }

    @Test
    void getName() {
        //arrange
        var expected = "name";
        sut.setName(expected);

        //act
        var result = sut.getName();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setName() {
        //arrange
        var expected = "name";

        //act
        sut.setName(expected);

        //assert
        assertEquals(expected, sut.getName());
    }

    @Test
    void isOwner() {
        //arrange
        var expected = true;
        sut.setOwner(expected);

        //act
        var result = sut.isOwner();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setOwner() {
        //arrange
        var expected = true;

        //act
        sut.setOwner(expected);

        //assert
        assertEquals(expected, sut.isOwner());
    }

    @Test
    void getTracks() {
        //arrange
        var expected = new int[]{};
        sut.setTracks(expected);

        //act
        var result = sut.getTracks();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setTracks() {
        //arrange
        var expected = new int[]{};

        //act
        sut.setTracks(expected);

        //assert
        assertEquals(expected, sut.getTracks());
    }
}