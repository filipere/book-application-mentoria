CREATE TABLE book (

					    id                                 UUID            not null,
					    nome                               varchar(100)    not null,
					    autor                              varchar(100)    not null,
					    categoria                          varchar(100)    not null,
					    tipo                               varchar(100)    not null,

					    CONSTRAINT pk_id PRIMARY KEY (id)
					    );