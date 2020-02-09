CREATE TABLE participacoes (
  id_artista INT NOT NULL,
  id_album INT NOT NULL,
  PRIMARY KEY (id_artista, id_album),
  foreign key(id_artista) references artistas(id),
  foreign key(id_album) references albuns(id)
) engine=InnoDB DEFAULT CHARSET=utf8;