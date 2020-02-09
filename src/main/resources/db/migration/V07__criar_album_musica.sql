CREATE TABLE album_musica (
  id_album INT NOT NULL,
  id_musica INT NOT NULL,
  PRIMARY KEY (id_musica, id_album),
  foreign key(id_musica) references musicas(id),
  foreign key(id_album) references albuns(id)
) engine=InnoDB DEFAULT CHARSET=utf8;