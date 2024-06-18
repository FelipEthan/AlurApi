create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100),
    mensaje varchar(100),   
    fecha_creacion date,   
    estatus varchar(100),   
    autor varchar(100),   
    curso varchar(100),   
    primary key(id)
);