------------------------------------------------------------------------------------------------------------------------
------------------------------------------------	SEQUENCES	------------------------------------------------
------------------------------------------------------------------------------------------------------------------------

CREATE SEQUENCE arte_interes_artista_id_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE artista_idArtista_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE artista_grupo_idArtistaGrupo_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE biografia_id_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE calificacion_idCalificacion_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE capa_idCapa_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE capa_lugar_idCapaLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE caracteristica_idCaracteristica_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE caracteristica_obra_idCaracteristicaObra_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE categoria_idCategoria_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE categoria_lugar_idCategoriaLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE comentario_idComentario_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE estado_idEstado_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE expresion_artistica_idExpresionArtistica_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE expresion_artistica_caracteristica_idExpresionArtisticaCaracteristica_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE expresion_autor_idExpresionAutor_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE grupo_idGrupo_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE grupo_expresion_artistica_idGrupoExpresionArtistica_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE lugar_idLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE obra_idObra_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE opinion_usuario_idOpinionUsuario_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE pais_idPais_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE portafolio_idPortafolio_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE referencia_obra_usuario_idReferenciaObraUsuario_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE rol_idRol_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE ruta_idRuta_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE ruta_expresion_artistica_idRutaExpresionArtistica_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE ruta_obra_idRutaObra_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE soporte_idSoporte_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE soporte_lugar_idSoporteLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE tipo_lugar_idTipoLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE tipo_lugar_lugar_idTipoLugarLugar_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE tipo_soporte_idTipoSoporte_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE usuario_idUsuario_seq INCREMENT BY 1 MINVALUE 1 START 1;
CREATE SEQUENCE valor_caracteristica_obra_idValorCaracteristicaObra_seq INCREMENT BY 1 MINVALUE 1 START 1;

------------------------------------------------------------------------------------------------------------------------
------------------------------------------------	TABLES		------------------------------------------------
------------------------------------------------------------------------------------------------------------------------

----	arte_interes_artista	----
CREATE TABLE arte_interes_artista (idArteInteresArtista INT NOT NULL, idExpresionArtistica INT DEFAULT NULL, idArtista INT DEFAULT NULL, PRIMARY KEY(idArteInteresArtista));
CREATE INDEX IDX_21EC31F83853B78C ON arte_interes_artista (idExpresionArtistica);
CREATE INDEX IDX_21EC31F88BD39AA4 ON arte_interes_artista (idArtista);

----	artista		----
CREATE TABLE artista (idArtista INT NOT NULL, profesion VARCHAR(50) NOT NULL, interesAmapearte TEXT NULL, sexo VARCHAR(1) DEFAULT NULL, idUsuario INT DEFAULT NULL, PRIMARY KEY(idArtista));
CREATE INDEX IDX_9B6AF15632DCDBAF ON artista (idUsuario);

----	artista_grupo	----
CREATE TABLE artista_grupo (idArtistaGrupo INT NOT NULL, idArtista INT DEFAULT NULL, idGrupo INT DEFAULT NULL, PRIMARY KEY(idArtistaGrupo));
CREATE INDEX IDX_C68A53E8BD39AA4 ON artista_grupo (idArtista);
CREATE INDEX IDX_C68A53E9BCAD8CE ON artista_grupo (idGrupo);

----	biografia	----
CREATE TABLE biografia (idBiografia INT NOT NULL, descripcion TEXT NOT NULL, fechaCreacion TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, idArtista INT DEFAULT NULL, PRIMARY KEY(idBiografia));
CREATE INDEX IDX_F16F10898BD39AA4 ON biografia (idArtista);

----	calificacion	----
CREATE TABLE calificacion (idCalificacion INT NOT NULL, descripcion VARCHAR(50) NOT NULL, PRIMARY KEY(idCalificacion));

----	capa	----
CREATE TABLE capa (idCapa INT NOT NULL, nombreCapa VARCHAR(150) NOT NULL, descripcionCapa VARCHAR(255) NOT NULL, iconoCapa VARCHAR(255) NOT NULL, PRIMARY KEY(idCapa));
CREATE UNIQUE INDEX UNIQ_54480EDE3ABFD06D ON capa (nombreCapa);

----	capa_lugar	----
CREATE TABLE capa_lugar (idCapaLugar INT NOT NULL, idCapa INT DEFAULT NULL, idLugar INT DEFAULT NULL, PRIMARY KEY(idCapaLugar));
CREATE INDEX IDX_615D73B027B55040 ON capa_lugar (idCapa);
CREATE INDEX IDX_615D73B05EB0E9B1 ON capa_lugar (idLugar);

----	caracteristica	----
CREATE TABLE caracteristica (idCaracteristica INT NOT NULL, nombre VARCHAR(255) NOT NULL, PRIMARY KEY(idCaracteristica));

----	caracteristica_obra	----
CREATE TABLE caracteristica_obra (idCaracteristicaObra INT NOT NULL, decripcion TEXT NOT NULL, idObra INT DEFAULT NULL, idCaracteristica INT DEFAULT NULL, idValorCaracteristicaObra INT DEFAULT NULL, PRIMARY KEY(idCaracteristicaObra));
CREATE INDEX IDX_DED453585D133323 ON caracteristica_obra (idObra);
CREATE INDEX IDX_DED45358458147DA ON caracteristica_obra (idCaracteristica);
CREATE INDEX IDX_DED45358A14F35CA ON caracteristica_obra (idValorCaracteristicaObra);

----	categoria	----
CREATE TABLE categoria (idCategoria INT NOT NULL, nombre VARCHAR(100) NOT NULL, descripcion VARCHAR(255) NOT NULL, PRIMARY KEY(idCategoria));

----	categoria_lugar	----
CREATE TABLE categoria_lugar (idCategoriaLugar INT NOT NULL, idLugar INT DEFAULT NULL, idCategoria INT DEFAULT NULL, PRIMARY KEY(idCategoriaLugar));
CREATE INDEX IDX_4843636F5EB0E9B1 ON categoria_lugar (idLugar);
CREATE INDEX IDX_4843636FB2FA397B ON categoria_lugar (idCategoria);

----	comentario	----
CREATE TABLE comentario (idComentario INT NOT NULL, descComentario TEXT NOT NULL, idUsuario INT DEFAULT NULL, idRuta INT DEFAULT NULL, PRIMARY KEY(idComentario));
CREATE INDEX IDX_4B91E70232DCDBAF ON comentario (idUsuario);
CREATE INDEX IDX_4B91E702B053AE12 ON comentario (idRuta);

----	estado	----
CREATE TABLE estado (idEstado INT NOT NULL, nombreEstado VARCHAR(100) NOT NULL, descEstado VARCHAR(255) NOT NULL, PRIMARY KEY(idEstado));
CREATE UNIQUE INDEX UNIQ_265DE1E388DE8DBC ON estado (nombreEstado);

----	expresion_artistica	----
CREATE TABLE expresion_artistica (idExpresionArtistica INT NOT NULL, descripcion VARCHAR(60) NOT NULL, PRIMARY KEY(idExpresionArtistica));
CREATE UNIQUE INDEX UNIQ_E8120F17A02A2F00 ON expresion_artistica (descripcion);

----	expresion_artistica_caracteristica	----
CREATE TABLE expresion_artistica_caracteristica (idExpresionArtisticaCaracteristica INT NOT NULL, idExpresionArtistica INT DEFAULT NULL, idCaracteristica INT DEFAULT NULL, PRIMARY KEY(idExpresionArtisticaCaracteristica));
CREATE INDEX IDX_56D1B1E23853B78C ON expresion_artistica_caracteristica (idExpresionArtistica);
CREATE INDEX IDX_56D1B1E2458147DA ON expresion_artistica_caracteristica (idCaracteristica);

----	expresion_autor	----
CREATE TABLE expresion_autor (idExpresionAutor INT NOT NULL, idArtista INT DEFAULT NULL, idExpresionArtistica INT DEFAULT NULL, PRIMARY KEY(idExpresionAutor));
CREATE INDEX IDX_195B93278BD39AA4 ON expresion_autor (idArtista);
CREATE INDEX IDX_195B93273853B78C ON expresion_autor (idExpresionArtistica);

----	grupo	----
CREATE TABLE grupo (idGrupo INT NOT NULL, nombreGrupo VARCHAR(80) NOT NULL, descripcion TEXT NOT NULL, PRIMARY KEY(idGrupo));

----	grupo_expresion_artistica	----
CREATE TABLE grupo_expresion_artistica (idGrupoExpresionArtistica INT NOT NULL, idGrupo INT DEFAULT NULL, idExpresionArtistica INT DEFAULT NULL, PRIMARY KEY(idGrupoExpresionArtistica));
CREATE INDEX IDX_9015E9749BCAD8CE ON grupo_expresion_artistica (idGrupo);
CREATE INDEX IDX_9015E9743853B78C ON grupo_expresion_artistica (idExpresionArtistica);

----	lugar	----
CREATE TABLE lugar (idLugar INT NOT NULL, nombreLugar VARCHAR(255) NOT NULL, descLugar TEXT NOT NULL, longitud DOUBLE PRECISION NOT NULL, latitud DOUBLE PRECISION NOT NULL, meGustaVotos INT NOT NULL, noMeGustaVotos INT NOT NULL, visitas INT NOT NULL, PRIMARY KEY(idLugar));

----	obra	----
CREATE TABLE obra (idObra INT NOT NULL, nombre VARCHAR(255) NOT NULL, longitud DOUBLE PRECISION NOT NULL, latitud DOUBLE PRECISION NOT NULL, direccion VARCHAR(255) NOT NULL, autor VARCHAR(80) NOT NULL, fechaCreacion TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, visitas INT NOT NULL, idExpresionArtistica INT DEFAULT NULL, PRIMARY KEY(idObra));
CREATE INDEX IDX_2EEE6DBD3853B78C ON obra (idExpresionArtistica);

----	opinion_usuario	----
CREATE TABLE opinion_usuario (idOpinionUsuario INT NOT NULL, comentario TEXT NOT NULL, idObra INT DEFAULT NULL, idUsuario INT DEFAULT NULL, idCalificacion INT DEFAULT NULL, PRIMARY KEY(idOpinionUsuario));
CREATE INDEX IDX_CFD47A435D133323 ON opinion_usuario (idObra);
CREATE INDEX IDX_CFD47A4332DCDBAF ON opinion_usuario (idUsuario);
CREATE INDEX IDX_CFD47A43D4A456E9 ON opinion_usuario (idCalificacion);

----	pais	----
CREATE TABLE pais (idPais INT NOT NULL, nombre VARCHAR(255) NOT NULL, abreviatura VARCHAR(5) NOT NULL, PRIMARY KEY(idPais));

----	portafolio	----
CREATE TABLE portafolio (idPortafolio INT NOT NULL, idObra INT DEFAULT NULL, idArtista INT DEFAULT NULL, PRIMARY KEY(idPortafolio));
CREATE INDEX IDX_FE2BE66A5D133323 ON portafolio (idObra);
CREATE INDEX IDX_FE2BE66A8BD39AA4 ON portafolio (idArtista);

----	referencia_obra_usuario	----
CREATE TABLE referencia_obra_usuario (idReferenciaObraUsuario INT NOT NULL, observacion TEXT NULL, idObra INT DEFAULT NULL, idUsuario INT DEFAULT NULL, PRIMARY KEY(idReferenciaObraUsuario));
CREATE INDEX IDX_FF1BBBE15D133323 ON referencia_obra_usuario (idObra);
CREATE INDEX IDX_FF1BBBE132DCDBAF ON referencia_obra_usuario (idUsuario);

----	rol	----
CREATE TABLE rol (idRol INT NOT NULL, Descripcion VARCHAR(50) NOT NULL, PRIMARY KEY(idRol));
CREATE UNIQUE INDEX UNIQ_E553F3726B6A0D7 ON rol (Descripcion);

----	ruta	----
CREATE TABLE ruta (idRuta INT NOT NULL, nombreRuta VARCHAR(200) NOT NULL, imagenRuta VARCHAR(255) NOT NULL, descRuta TEXT NOT NULL, fechaCreacion TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, fechaAprobacion TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NULL, visitas INT NOT NULL, votosMeGusta INT NOT NULL, votosNoMeGusta INT NOT NULL, idUsuario INT DEFAULT NULL, idEstado INT DEFAULT NULL, PRIMARY KEY(idRuta));
CREATE UNIQUE INDEX UNIQ_C3AEF08CAD592E3F ON ruta (nombreRuta);
CREATE INDEX IDX_C3AEF08C32DCDBAF ON ruta (idUsuario);
CREATE INDEX IDX_C3AEF08C454C4979 ON ruta (idEstado);

----	ruta_expresion_artistica	----
CREATE TABLE ruta_expresion_artistica (idRutaExpresionArtistica INT NOT NULL, idRuta INT DEFAULT NULL, idExpresionArtistica INT DEFAULT NULL, PRIMARY KEY(idRutaExpresionArtistica));
CREATE INDEX IDX_90269BE6B053AE12 ON ruta_expresion_artistica (idRuta);
CREATE INDEX IDX_90269BE63853B78C ON ruta_expresion_artistica (idExpresionArtistica);

----	ruta_obra	----
CREATE TABLE ruta_obra (idRutaObra INT NOT NULL, idRuta INT DEFAULT NULL, idObra INT DEFAULT NULL, PRIMARY KEY(idRutaObra));
CREATE INDEX IDX_B28AA275B053AE12 ON ruta_obra (idRuta);
CREATE INDEX IDX_B28AA2755D133323 ON ruta_obra (idObra);

----	soporte	----
CREATE TABLE soporte (idSoporte INT NOT NULL, descripcion VARCHAR(60) NOT NULL, idObra INT DEFAULT NULL, idTipoSoporte INT DEFAULT NULL, PRIMARY KEY(idSoporte));
CREATE INDEX IDX_2273AC65D133323 ON soporte (idObra);
CREATE INDEX IDX_2273AC6E14DEDB9 ON soporte (idTipoSoporte);

----	soporte_lugar	----
CREATE TABLE soporte_lugar (idSoporteLugar INT NOT NULL, descripcion VARCHAR(255) NOT NULL, idLugar INT DEFAULT NULL, idTipoSoporte INT DEFAULT NULL, PRIMARY KEY(idSoporteLugar));
CREATE INDEX IDX_D10D58575EB0E9B1 ON soporte_lugar (idLugar);
CREATE INDEX IDX_D10D5857E14DEDB9 ON soporte_lugar (idTipoSoporte);

----	tipo_lugar	----
CREATE TABLE tipo_lugar (idTipoLugar INT NOT NULL, nombreTipoLugar VARCHAR(100) NOT NULL, descTipoLugar VARCHAR(255) NOT NULL, icono VARCHAR(255) NOT NULL, PRIMARY KEY(idTipoLugar));

----	tipo_lugar_lugar	----
CREATE TABLE tipo_lugar_lugar (idTipoLugarLugar INT NOT NULL, idLugar INT DEFAULT NULL, idTipoLugar INT DEFAULT NULL, PRIMARY KEY(idTipoLugarLugar));
CREATE INDEX IDX_3937BFEE5EB0E9B1 ON tipo_lugar_lugar (idLugar);
CREATE INDEX IDX_3937BFEE235509A0 ON tipo_lugar_lugar (idTipoLugar);

----	tipo_soporte	----
CREATE TABLE tipo_soporte (idTipoSoporte INT NOT NULL, descripcion VARCHAR(60) NOT NULL, PRIMARY KEY(idTipoSoporte));

----	usuario	----
CREATE TABLE usuario (idUsuario INT NOT NULL, nombre VARCHAR(255) NOT NULL, fechaNacimiento DATE NOT NULL, contrasena VARCHAR(20) NOT NULL, correo VARCHAR(255) NOT NULL, publicorreo BOOLEAN NOT NULL, telefono VARCHAR(20) NOT NULL, publitel BOOLEAN NOT NULL, fotoArtista VARCHAR(255) NOT NULL, idPais INT DEFAULT NULL, idRol INT DEFAULT NULL, PRIMARY KEY(idUsuario));
CREATE INDEX IDX_2265B05DDA07061 ON usuario (idPais);
CREATE INDEX IDX_2265B05D2F1D22B0 ON usuario (idRol);

----	valor_caracteristica_obra	----
CREATE TABLE valor_caracteristica_obra (idValorCaracteristicaObra INT NOT NULL, descripcionCaracteristica VARCHAR(255) NOT NULL, idCaracteristica INT DEFAULT NULL, PRIMARY KEY(idValorCaracteristicaObra));
CREATE INDEX IDX_70DA354E458147DA ON valor_caracteristica_obra (idCaracteristica);

------------------------------------------------------------------------------------------------------------------------
------------------------------------------------	ALTER TABLES	------------------------------------------------
------------------------------------------------------------------------------------------------------------------------

ALTER TABLE arte_interes_artista ADD CONSTRAINT FK_21EC31F83853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE arte_interes_artista ADD CONSTRAINT FK_21EC31F88BD39AA4 FOREIGN KEY (idArtista) REFERENCES artista (idArtista) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE artista ADD CONSTRAINT FK_9B6AF15632DCDBAF FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE artista_grupo ADD CONSTRAINT FK_C68A53E8BD39AA4 FOREIGN KEY (idArtista) REFERENCES artista (idArtista) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE artista_grupo ADD CONSTRAINT FK_C68A53E9BCAD8CE FOREIGN KEY (idGrupo) REFERENCES grupo (idGrupo) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE biografia ADD CONSTRAINT FK_F16F10898BD39AA4 FOREIGN KEY (idArtista) REFERENCES artista (idArtista) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE capa_lugar ADD CONSTRAINT FK_615D73B027B55040 FOREIGN KEY (idCapa) REFERENCES capa (idCapa) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE capa_lugar ADD CONSTRAINT FK_615D73B05EB0E9B1 FOREIGN KEY (idLugar) REFERENCES lugar (idLugar) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE caracteristica_obra ADD CONSTRAINT FK_DED453585D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE caracteristica_obra ADD CONSTRAINT FK_DED45358458147DA FOREIGN KEY (idCaracteristica) REFERENCES caracteristica (idCaracteristica) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE caracteristica_obra ADD CONSTRAINT FK_DED45358A14F35CA FOREIGN KEY (idValorCaracteristicaObra) REFERENCES valor_caracteristica_obra (idValorCaracteristicaObra) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE categoria_lugar ADD CONSTRAINT FK_4843636F5EB0E9B1 FOREIGN KEY (idLugar) REFERENCES lugar (idLugar) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE categoria_lugar ADD CONSTRAINT FK_4843636FB2FA397B FOREIGN KEY (idCategoria) REFERENCES categoria (idCategoria) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE comentario ADD CONSTRAINT FK_4B91E70232DCDBAF FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE comentario ADD CONSTRAINT FK_4B91E702B053AE12 FOREIGN KEY (idRuta) REFERENCES ruta (idRuta) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE expresion_artistica_caracteristica ADD CONSTRAINT FK_56D1B1E23853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE expresion_artistica_caracteristica ADD CONSTRAINT FK_56D1B1E2458147DA FOREIGN KEY (idCaracteristica) REFERENCES caracteristica (idCaracteristica) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE expresion_autor ADD CONSTRAINT FK_195B93278BD39AA4 FOREIGN KEY (idArtista) REFERENCES artista (idArtista) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE expresion_autor ADD CONSTRAINT FK_195B93273853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE grupo_expresion_artistica ADD CONSTRAINT FK_9015E9749BCAD8CE FOREIGN KEY (idGrupo) REFERENCES grupo (idGrupo) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE grupo_expresion_artistica ADD CONSTRAINT FK_9015E9743853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE obra ADD CONSTRAINT FK_2EEE6DBD3853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE opinion_usuario ADD CONSTRAINT FK_CFD47A435D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE opinion_usuario ADD CONSTRAINT FK_CFD47A4332DCDBAF FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE opinion_usuario ADD CONSTRAINT FK_CFD47A43D4A456E9 FOREIGN KEY (idCalificacion) REFERENCES calificacion (idCalificacion) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE portafolio ADD CONSTRAINT FK_FE2BE66A5D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE portafolio ADD CONSTRAINT FK_FE2BE66A8BD39AA4 FOREIGN KEY (idArtista) REFERENCES artista (idArtista) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE referencia_obra_usuario ADD CONSTRAINT FK_FF1BBBE15D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE referencia_obra_usuario ADD CONSTRAINT FK_FF1BBBE132DCDBAF FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE ruta ADD CONSTRAINT FK_C3AEF08C32DCDBAF FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE ruta ADD CONSTRAINT FK_C3AEF08C454C4979 FOREIGN KEY (idEstado) REFERENCES estado (idEstado) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE ruta_expresion_artistica ADD CONSTRAINT FK_90269BE6B053AE12 FOREIGN KEY (idRuta) REFERENCES ruta (idRuta) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE ruta_expresion_artistica ADD CONSTRAINT FK_90269BE63853B78C FOREIGN KEY (idExpresionArtistica) REFERENCES expresion_artistica (idExpresionArtistica) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE ruta_obra ADD CONSTRAINT FK_B28AA275B053AE12 FOREIGN KEY (idRuta) REFERENCES ruta (idRuta) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE ruta_obra ADD CONSTRAINT FK_B28AA2755D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE soporte ADD CONSTRAINT FK_2273AC65D133323 FOREIGN KEY (idObra) REFERENCES obra (idObra) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE soporte ADD CONSTRAINT FK_2273AC6E14DEDB9 FOREIGN KEY (idTipoSoporte) REFERENCES tipo_soporte (idTipoSoporte) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE soporte_lugar ADD CONSTRAINT FK_D10D58575EB0E9B1 FOREIGN KEY (idLugar) REFERENCES lugar (idLugar) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE soporte_lugar ADD CONSTRAINT FK_D10D5857E14DEDB9 FOREIGN KEY (idTipoSoporte) REFERENCES tipo_soporte (idTipoSoporte) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE tipo_lugar_lugar ADD CONSTRAINT FK_3937BFEE5EB0E9B1 FOREIGN KEY (idLugar) REFERENCES lugar (idLugar) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE tipo_lugar_lugar ADD CONSTRAINT FK_3937BFEE235509A0 FOREIGN KEY (idTipoLugar) REFERENCES tipo_lugar (idTipoLugar) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE usuario ADD CONSTRAINT FK_2265B05DDA07061 FOREIGN KEY (idPais) REFERENCES pais (idPais) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE usuario ADD CONSTRAINT FK_2265B05D2F1D22B0 FOREIGN KEY (idRol) REFERENCES rol (idRol) NOT DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE valor_caracteristica_obra ADD CONSTRAINT FK_70DA354E458147DA FOREIGN KEY (idCaracteristica) REFERENCES caracteristica (idCaracteristica) NOT DEFERRABLE INITIALLY IMMEDIATE;