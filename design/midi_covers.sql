-- MIDI covers DB
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS version;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS rating;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

CREATE TABLE song (
	song_id SERIAL PRIMARY KEY,
	title varchar(300) NOT NULL,
	artist varchar(200) NOT NULL
);

CREATE TABLE version (
	version_id SERIAL PRIMARY KEY,
	song_id int NOT NULL, 
	file_path TEXT NOT NULL,
	version_type varchar(100) NOT NULL,
	CONSTRAINT FK_song_version 
		FOREIGN KEY (song_id) REFERENCES song(song_id) ON DELETE CASCADE,
	CONSTRAINT unique_song_version
		UNIQUE (song_id, version_type)
);

CREATE TABLE comment (
	comment_id SERIAL PRIMARY KEY,
	song_id int NOT NULL,
	display_name varchar(100),
	comment_text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_song_comment 
		FOREIGN KEY (song_id) REFERENCES song(song_id) ON DELETE CASCADE
);

CREATE TABLE rating (
	rating_id SERIAL PRIMARY KEY,
	song_id int NOT NULL,
	rating int NOT NULL CHECK (rating BETWEEN 1 AND 5),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FK_song_rating 
		FOREIGN KEY (song_id) REFERENCES song(song_id) ON DELETE CASCADE
	
);

CREATE TABLE youtube (
	youtube_id SERIAL PRIMARY KEY,
	song_id int NOT NULL,
	link varchar(400),
	CONSTRAINT FK_song_youtube
		FOREIGN KEY (song_id) REFERENCES song(song_id) ON DELETE CASCADE
);

CREATE INDEX idx_song_title ON song(title);
CREATE INDEX idx_song_artist ON song(artist);

CREATE INDEX idx_version_song_id ON version(song_id);
CREATE INDEX idx_comment_song_id ON comment(song_id);
CREATE INDEX idx_rating_song_id ON rating(song_id);
CREATE INDEX idx_youtube_song_id ON youtube(song_id);


-- Songs
INSERT INTO song (title, artist) VALUES 
    ('Fernando', 'ABBA'),
    ('Groove Is in the Heart', 'Deee-Lite'),
    ('Kokomo', 'The Beach Boys'),
    ('Meet Me Halfway', 'The Black Eyed Peas'),
    ('Mood', '24kGoldn'),
    ('Rockstar', 'Nickleback'),
    ('Style', 'Taylor Swift'),
	('True', 'Spandau Ballet');

-- Versions
INSERT INTO version(song_id, file_path, version_type) VALUES
    (1, '/Rosie/Bandle/12_19/Fernando/1', 'Drums & Bass'),
    (1, '/Rosie/Bandle/12_19/Fernando/2', 'Strings & Flute'),
    (1, '/Rosie/Bandle/12_19/Fernando/3', 'Piano'),
	(1, '/Rosie/Bandle/12_19/Fernando/4', 'Instrumental'),
	(1, '/Rosie/Bandle/12_19/Fernando/5', 'With Vocals'),

	(2, '/Rosie/Bandle/12_19/Groove Is in the Heart/1', 'Drums & SFX'),
	(2, '/Rosie/Bandle/12_19/Groove Is in the Heart/2', 'Bass & Drums'),
	(2, '/Rosie/Bandle/12_19/Groove Is in the Heart/3', 'Horns'),
	(2, '/Rosie/Bandle/12_19/Groove Is in the Heart/4', 'Instrumental'),
	(2, '/Rosie/Bandle/12_19/Groove Is in the Heart/5', 'With Vocals'),

	(3, '/Rosie/Bandle/12_19/Kokomo/1', 'Drums'),
	(3, '/Rosie/Bandle/12_19/Kokomo/2', 'Bass'),
	(3, '/Rosie/Bandle/12_19/Kokomo/3', 'Accordion'),
	(3, '/Rosie/Bandle/12_19/Kokomo/4', 'Instrumental'),
	(3, '/Rosie/Bandle/12_19/Kokomo/4', 'With Vocals'),

	(4, '/Rosie/Bandle/12_19/Meet Me Halfway/1', 'Drums'),
	(4, '/Rosie/Bandle/12_19/Meet Me Halfway/2', 'Bass'),
	(4, '/Rosie/Bandle/12_19/Meet Me Halfway/3', 'Synth'),
	(4, '/Rosie/Bandle/12_19/Meet Me Halfway/4', 'Instrumental'),
	(4, '/Rosie/Bandle/12_19/Meet Me Halfway/5', 'With Vocals'),

	(5, '/Rosie/Bandle/12_19/Mood/1', 'Drums'),
	(5, '/Rosie/Bandle/12_19/Mood/2', 'Bass'),
	(5, '/Rosie/Bandle/12_19/Mood/3', 'Guitar'),
	(5, '/Rosie/Bandle/12_19/Mood/4', 'Instrumental'),
	(5, '/Rosie/Bandle/12_19/Mood/5', 'With Vocals'),

	(6, '/Rosie/Bandle/12_19/Rockstar/1', 'Drums'),
	(6, '/Rosie/Bandle/12_19/Rockstar/2', 'Bass'),
	(6, '/Rosie/Bandle/12_19/Rockstar/3', 'Guitar'),
	(6, '/Rosie/Bandle/12_19/Rockstar/4', 'Instrumental'),
	(6, '/Rosie/Bandle/12_19/Rockstar/5', 'With Vocals'),

	(7, '/Rosie/Bandle/12_19/Style/1', 'Drums & Bass'),
	(7, '/Rosie/Bandle/12_19/Style/2', 'Guitar'),
	(7, '/Rosie/Bandle/12_19/Style/3', 'Synth'),
	(7, '/Rosie/Bandle/12_19/Style/4', 'Instrumental'),
	(7, '/Rosie/Bandle/12_19/Style/5', 'With Vocals'),

	(8, '/Rosie/Bandle/12_19/True/1', 'Drums & Bass'),
	(8, '/Rosie/Bandle/12_19/True/2', 'Strings'),
	(8, '/Rosie/Bandle/12_19/True/3', 'Synth'),
	(8, '/Rosie/Bandle/12_19/True/4', 'Instrumental'),
	(8, '/Rosie/Bandle/12_19/True/5', 'With Vocals')
;
COMMIT TRANSACTION;