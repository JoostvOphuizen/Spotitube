package nl.han.dea.joost.database;

import nl.han.dea.joost.resource.playlist.PlaylistDTO;
import nl.han.dea.joost.resource.playlist.PlaylistsDTO;
import nl.han.dea.joost.resource.track.TrackDTO;
import nl.han.dea.joost.resource.track.TracksDTO;

public class DataBase {

    static private final PlaylistsDTO playlistsDTO = new PlaylistsDTO();
    static private final PlaylistDTO[] playlists = new PlaylistDTO[3];

    static private final TracksDTO tracksDTO = new TracksDTO();
    static private final TrackDTO[] tracks = new TrackDTO[3];

    static {
        playlists[0] = new PlaylistDTO();
        playlists[0].setId(1);
        playlists[0].setName("Heavy Metal");
        playlists[0].setOwner(true);
        playlists[0].setTracks(new int[] {1, 2});

        playlists[1] = new PlaylistDTO();
        playlists[1].setId(2);
        playlists[1].setName("Pop");
        playlists[1].setOwner(false);
        playlists[1].setTracks(new int[] {2, 3});

        playlists[2] = new PlaylistDTO();
        playlists[2].setId(3);
        playlists[2].setName("Rock");
        playlists[2].setOwner(false);
        playlists[2].setTracks(new int[] {1});

        playlistsDTO.setPlaylists(playlists);
        playlistsDTO.setLength(123445);

        tracks[0] = new TrackDTO();
        tracks[0].setId(1);
        tracks[0].setPerformer("Metallica");
        tracks[0].setTitle("Enter Sandman");
        tracks[0].setDuration(300);
        tracks[0].setAlbum("Metallica");
        tracks[0].setPlaycount(12345);

        tracks[1] = new TrackDTO();
        tracks[1].setId(2);
        tracks[1].setPerformer("Metallica");
        tracks[1].setTitle("Nothing Else Matters");
        tracks[1].setDuration(300);
        tracks[1].setAlbum("Metallica");
        tracks[1].setPlaycount(12345);

        tracks[2] = new TrackDTO();
        tracks[2].setId(3);
        tracks[2].setPerformer("Metallica");
        tracks[2].setTitle("Master of Puppets");
        tracks[2].setDuration(300);
        tracks[2].setAlbum("Metallica");
        tracks[2].setPlaycount(12345);
    }

    public PlaylistsDTO getPlaylists() {
        return playlistsDTO;
    }

    public void addPlaylist(PlaylistDTO playlist) {
        playlistsDTO.setLength(playlistsDTO.getLength() + 1);
        playlist.setId(playlistsDTO.getLength());
        addPlaylistToPlaylists(playlist);
    }

    public void addPlaylistToPlaylists(PlaylistDTO playlist) {
        PlaylistDTO[] newPlaylists = new PlaylistDTO[playlists.length + 1];
        System.arraycopy(playlists, 0, newPlaylists, 0, playlists.length);
        newPlaylists[playlists.length] = playlist;
        playlistsDTO.setPlaylists(newPlaylists);
    }

    public void deletePlaylist(int id) {
        playlistsDTO.setLength(playlistsDTO.getLength() - 1);
        deletePlaylistFromPlaylists(id);
    }

    public void deletePlaylistFromPlaylists(int id) {
        PlaylistDTO[] newPlaylists = new PlaylistDTO[playlists.length - 1];
        int index = 0;
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() != id) {
                newPlaylists[index] = playlist;
                index++;
            }
        }
        playlistsDTO.setPlaylists(newPlaylists);
    }

    public void editPlaylist(int id, PlaylistDTO playlist) {
        editPlaylistInPlaylists(id, playlist);
    }

    public void editPlaylistInPlaylists(int id, PlaylistDTO playlist) {
        for (PlaylistDTO playlistDTO : playlists) {
            if (playlistDTO.getId() == id) {
                playlistDTO.setName(playlist.getName());
            }
        }
    }

    public PlaylistDTO getPlaylist(int id) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == id) {
                return playlist;
            }
        }
        return null;
    }

    public PlaylistsDTO addTrackToPlaylist(int playlistId, int trackId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                int[] newTracks = new int[tracks.length + 1];
                System.arraycopy(tracks, 0, newTracks, 0, tracks.length);
                newTracks[tracks.length] = trackId;
                playlist.setTracks(newTracks);
            }
        }
        return playlistsDTO;
    }

    public void deleteTrackFromPlaylist(int playlistId, int trackId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                int[] newTracks = new int[tracks.length - 1];
                int index = 0;
                for (int track : tracks) {
                    if (track != trackId) {
                        newTracks[index] = track;
                        index++;
                    }
                }
                playlist.setTracks(newTracks);
            }
        }
    }

    public TracksDTO getTracks(int playlistId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                TrackDTO[] trackDTOs = new TrackDTO[tracks.length];
                for (int j = 0; j < tracks.length; j++) {
                    trackDTOs[j] = getTrack(tracks[j]);
                }
                tracksDTO.setTracks(trackDTOs);
                tracksDTO.setLength(tracks.length);
                return tracksDTO;
            }
        }
        return null;
    }

    private TrackDTO getTrack(int track) {
        for (TrackDTO trackDTO : tracks) {
            if (trackDTO.getId() == track) {
                return trackDTO;
            }
        }
        return null;
    }

    public void addTrack(int playlistId, int trackId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                int[] newTracks = new int[tracks.length + 1];
                System.arraycopy(tracks, 0, newTracks, 0, tracks.length);
                newTracks[tracks.length] = trackId;
                playlist.setTracks(newTracks);
            }
        }
    }

    public void addTrack(int playlistId, TrackDTO track) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                int[] newTracks = new int[tracks.length + 1];
                System.arraycopy(tracks, 0, newTracks, 0, tracks.length);
                newTracks[tracks.length] = track.getId();
                playlist.setTracks(newTracks);
            }
        }
    }


    public void deleteTrack(int playlistId, int trackId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                int[] newTracks = new int[tracks.length - 1];
                int index = 0;
                for (int track : tracks) {
                    if (track != trackId) {
                        newTracks[index] = track;
                        index++;
                    }
                }
                playlist.setTracks(newTracks);
            }
        }
    }

    public void editTrack(int playlistId, int trackId, TrackDTO track) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                for (int i = 0; i < tracks.length; i++) {
                    if (tracks[i] == trackId) {
                        tracks[i] = track.getId();
                    }
                }
                playlist.setTracks(tracks);
            }
        }
    }

    public TrackDTO getTrack(int playlistId, int trackId) {
        for (PlaylistDTO playlist : playlists) {
            if (playlist.getId() == playlistId) {
                int[] tracks = playlist.getTracks();
                for (int track : tracks) {
                    if (track == trackId) {
                        return getTrack(track);
                    }
                }
            }
        }
        return null;
    }

    public TracksDTO getTracks() {
        return tracksDTO;
    }
}
