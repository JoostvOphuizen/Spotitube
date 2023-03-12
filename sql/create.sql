

create table users (
   id int IDENTITY primary key,
   username VARCHAR(255) not null,
   password VARCHAR(255) not null,
   token VARCHAR(255) null
);

CREATE TABLE user_playlists (
   user_id int not null,
   playlist_id int not null
);

create table playlists (
   id int IDENTITY primary key,
   name text not null,
   owner bit not null
);

create table tracks (
   id int IDENTITY primary key,
   title VARCHAR(255) not null,
   performer VARCHAR(255) not null,
   duration int not null,
   album VARCHAR(255) null,
   playcount int null,
   publicationDate date null,
   description VARCHAR(255) null,
   offlineAvailable bit not null
);

create table playlist_tracks (
   playlist_id int not null,
   track_id int not null
);

alter table playlist_tracks
   add constraint fk_playlist_tracks_playlist_id
   foreign key (playlist_id) references playlists (id);

alter table playlist_tracks 
    add constraint fk_playlist_tracks_track_id 
    foreign key (track_id) references tracks (id);

alter table user_playlists
    add constraint fk_user_playlists_user_id
    foreign key (user_id) references users (id);

alter table user_playlists
    add constraint fk_user_playlists_playlist_id
    foreign key (playlist_id) references playlists (id);

-- Path: insert.sql
insert into users (username, password) values ('meron', 'MySuperSecretPassword12341');
insert into users (username, password) values ('user2', 'password2');
insert into users (username, password) values ('user3', 'password3');
SELECT * FROM users
insert into playlists (name, owner) values ('Heavy Metal', 1);
insert into playlists (name, owner) values ('Pop', 0);

insert into tracks (title, performer, duration, album, playcount, publicationDate, description, offlineAvailable) values ('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0);
insert into tracks (title, performer, duration, album, playcount, publicationDate, description, offlineAvailable) values ('The cost', 'The Frames', 423, null, 37, '10-03-2006', 'Title song from the Album The Cost', 1);

insert into user_playlists (user_id, playlist_id) values (1, 1);
insert into user_playlists (user_id, playlist_id) values (1, 2);
insert into user_playlists (user_id, playlist_id) values (2, 1);

insert into playlist_tracks (playlist_id, track_id) values (1, 1);
insert into playlist_tracks (playlist_id, track_id) values (1, 2);
insert into playlist_tracks (playlist_id, track_id) values (2, 2);


insert into tracks (title, performer, duration, album, playcount, publicationDate, description, offlineAvailable) 
values ('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0),
('The cost', 'The Frames', 423, null, 37, '03-19-2006', 'Title song from the Album The Cost', 1),
('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0),
('The cost', 'The Frames', 423, null, 37, '03-19-2006', 'Title song from the Album The Cost', 1),
('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0),
('The cost', 'The Frames', 423, null, 37, '03-19-2006', 'Title song from the Album The Cost', 1),
('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0),
('The cost', 'The Frames', 423, null, 37, '03-19-2006', 'Title song from the Album The Cost', 1),
('Song for someone', 'The Frames', 350, 'The cost', null, null, null, 0),
('The cost', 'The Frames', 423, null, 37, '03-19-2006', 'Title song from the Album The Cost', 1);

INSERT INTO tracks (title, performer, duration, album, playcount, publicationDate, description, offlineAvailable)
VALUES
('Stairway to Heaven', 'Led Zeppelin', 482, 'Led Zeppelin IV', 350, '1971-11-08', 'One of the greatest rock songs of all time', 1),
('Rolling in the Deep', 'Adele', 228, '21', 900, '2010-11-29', 'Soulful ballad about heartbreak', 1),
('Billie Jean', 'Michael Jackson', 293, 'Thriller', 250, '1982-01-02', 'Pop classic with iconic bassline', 1),
('Yesterday', 'The Beatles', 125, 'Help!', 500, '1965-08-06', 'Timeless ballad with simple, beautiful melody', 1),
('Thriller', 'Michael Jackson', 357, 'Thriller', 600, '1982-11-30', 'Horror-themed pop song with iconic music video', 1),
('Sweet Child o Mine', 'Guns N Roses', 356, 'Appetite for Destruction', 800, '1987-07-21', 'Guitar-driven rock classic with memorable riff', 1),
('Bohemian Rhapsody', 'Queen', 354, 'A Night at the Opera', 1200, '1975-10-31', 'Operatic rock masterpiece with iconic piano intro', 1),
('Hey Jude', 'The Beatles', 431, 'The Beatles (White Album)', 700, '1968-08-26', 'One of the Beatles most famous songs, featuring a sing-along chorus', 1),
('Hotel California', 'Eagles', 391, 'Hotel California', 900, '1976-12-08', 'One of the most popular classic rock songs ever, with a haunting guitar solo', 1),
('Shape of You', 'Ed Sheeran', 233, '÷ (Divide)', 1000, '2017-01-06', 'Catchy pop hit with tropical house influences', 1);


INSERT INTO playlists (name, owner)
VALUES
('Pop', 1),
('Rock', 2),
('Hip Hop', 1),
('Classical', 3),
('Country', 2);

INSERT INTO playlist_tracks (playlist_id, track_id)
VALUES
(1, 1),
(1, 2),
(1, 5),
(2, 4),
(2, 7),
(2, 9),
(3, 3),
(3, 6),
(3, 8),
(3, 10),
(3, 1);

INSERT INTO user_playlists (user_id, playlist_id)
VALUES
(4, 3),
(4, 2),
(4, 1);


INSERT INTO playlist_tracks (playlist_id, track_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 5),
(1, 8),
(2, 2),
(2, 3),
(2, 4),
(2, 6),
(2, 7),
(2, 9),
(3, 1),
(3, 4),
(3, 5),
(3, 6),
(4, 3),
(4, 7),
(4, 8),
(4, 10),
(5, 2),
(5, 4),
(5, 6),
(5, 9),
(6, 1),
(6, 5),
(6, 7),
(6, 8),
(7, 2),
(7, 3),
(7, 4),
(7, 9),
(7, 10);


INSERT INTO playlist_tracks (playlist_id, track_id)
VALUES
(1, 3),
(1, 6),
(1, 8),
(2, 2),
(2, 5),
(2, 7),
(2, 10),
(3, 1),
(3, 4),
(3, 9),
(3, 10),
(3, 2);


SELECT * FROM playlist_tracks

SELECT * FROM playlists

SELECT * FROM tracks

SELECT * FROM users

SELECT * FROM user_playlists