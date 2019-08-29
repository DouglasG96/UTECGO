# Host: localhost  (Version 5.5.5-10.1.39-MariaDB)
# Date: 2019-08-28 17:46:05
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "coordenadas"
#

DROP TABLE IF EXISTS `coordenadas`;
CREATE TABLE `coordenadas` (
  `id_coor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `latitud` varchar(250) NOT NULL,
  `longitud` varchar(250) NOT NULL,
  PRIMARY KEY (`id_coor`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

#
# Data for table "coordenadas"
#

INSERT INTO `coordenadas` VALUES (1,'Benito Juarez','13.700376','-89.201921'),(2,'Francisco Morazan','13.700401','-89.202056'),(3,'Simon Bolivar','13.700183','-89.2004710'),(4,'Los Fundadores','13.701637','-89.201612'),(5,'Anastacio Aquino','13.700448','-89.200250'),(6,'José Martí','13.700218','-89.200013'),(7,'Claudia Lars','13.701427','-89.199715'),(8,'Garcia Lorca','13.699973','-89.199545'),(9,'Laboratorio 10','13.700678','-89.201921'),(10,'Laboratorio nº 3','13.700678','-89.201921'),(11,'Thomas Jefferson','13.699520','-89.199499'),(12,'Gabriela Mistral','13.700734','-89.200819'),(13,'Dr. Jose Adolfo Araujo Ramagoza','13.699610','-89.201001'),(14,'Giuseppe Garibaldi','13.701160','-89.200928'),(15,'Jorge Luis Borges','13.700912','-89.202151'),(16,'','13.700656','-89.201982'),(17,'','13.700656','-89.201982'),(18,'Auditorio de la paz','13.700401','-89.202056'),(19,'Auditorio Dr. Rufino Garay','13.700547','-89.200549'),(20,'Laboratorio 8 de Redes','13.700349','-89.201970'),(21,'Laboratorio de Cisco','13.700349','-89.201970'),(22,'Biblioteca Central','13.700376','-89.201921'),(23,'Edificio Giusseppe Garibaldi','13.701155','-89.200949'),(24,'Biblioteca de negocios','13.700338','-89.201991');

#
# Structure for table "tipo_usuario"
#

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
  `id_tipo` varchar(20) NOT NULL,
  `tipo` int(11) NOT NULL,
  `activities` varchar(20) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tipo_usuario"
#

INSERT INTO `tipo_usuario` VALUES ('1',1,'main_activities_menu'),('2',2,'main_activities_visi');

#
# Structure for table "tipos_lugares"
#

DROP TABLE IF EXISTS `tipos_lugares`;
CREATE TABLE `tipos_lugares` (
  `id_tipo_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "tipos_lugares"
#

INSERT INTO `tipos_lugares` VALUES (1,'Edificios'),(2,'Laboratorios'),(3,'Auditorios'),(4,'Bibliotecas');

#
# Structure for table "lugares"
#

DROP TABLE IF EXISTS `lugares`;
CREATE TABLE `lugares` (
  `id_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `descripcion` longtext NOT NULL,
  `foto` varchar(200) NOT NULL,
  `id_tipo_lugar` int(11) NOT NULL,
  `dependencias` longtext,
  PRIMARY KEY (`id_lugar`),
  KEY `id_tipo_lugar` (`id_tipo_lugar`),
  CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`id_tipo_lugar`) REFERENCES `tipos_lugares` (`id_tipo_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

#
# Data for table "lugares"
#

INSERT INTO `lugares` VALUES (1,'Benito Juarez','Calle arce 1114 (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/bj.jpg',1,'Dependencias \n\n-Biblioteca Central\n-Plaza Benito Juarez\n-Laboratorio 3 de Informatica\n-Laboratorio 10 de Academia de Microsoft\n-Coordinacion de diseño grafico\n-Sala de calidad de procesos industriales\n\n\n\n'),(2,'Francisco Morazan','Calle arce 1026 (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/fm.JPG',1,'Dependencias\n\n-Decanato de la Facultad de Ciencias Empresariales\n-Direccion de Escuela de Administracion y Finazas\n-Coordinacion de Administracion y Contabilidad\n-Coordinacion de Mercadeo, economia y turismo\n-Auditorio De La Paz\n-Laboratorios 1 y 2 de Informatica\n-Laboratorio de Redes\n-Laboratorio 7 de Hardware\n-Laboratorio 4 de Cisco\n-Biblioteca especializada de negocios\n-Biblioteca para docentes de negocios\n'),(3,'Simon Bolivar','Calle arce 1020 (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/sb.jpg',1,' Dependencias\n\n-Decanato de la Facultad de Derecho\n-Direccion de Escuela de Derecho\n-Biblioteca especializada de  Derecho Dr. Abraham Rodriguez\n-Biblioteca para docentes de  Derecho\n-Auditorio Dr. Rufino Garay\n-Camara Gesell\n-Sala de jurados Dr. José Enrique Burgos\n-Sala de Audiencia de Familia\n-Laboratorio 12 Diseño Grafico\n-Laboratorio 14 Tecnologia  Multimedia\n-Centro de copias Didáctica\n-Sala de deportes '),(4,'Los Fundadores','1ª calle Poniente ,1138  (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/fd.jpg',1,'Dependencias\n\n-Rectoria Honoraria\n-Presidencia\n-Vicepresidencia\n-Asistente de Presidencia\n-Salón Ignacio Ellacuria\n-Dirección de Planificación\n-Jefatura de Presupuestos\n-Vicerrectoría Académica\n-Vicerrectoría de Educación virtual\n-Secretaría General\n-Vicerrectoría de Desarrollo Educativo\n-Rectoría \n-Sala de sesiones'),(5,'Anastasio Aquino','Calle Arce 1006 (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/aq.jpg',1,'Museo Universitario de Antropología,MUA\n\n\nJefatura de Diseño gráfico,MUA'),(6,'Jose Marti','Calle Arce y 17.ª avenida Norte (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/jm.jpg',1,'Dependencias \n\n-Dirección de Informatica (DIN)\n-Gestion de educación media\n-Derección de Relaciones Internacionales\n-Dirección de docencia de Educacion Virtual\n-Dirección de metodología de Educación virtual\n-Dirección administrativa de Educacion Virtual\n-Jefatura de Investigacion y proyección social virtual\n'),(7,'Claudia Lars','1ª calle Poniente y 17.ª avenida Norte (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/cl.jpg',1,'Dependencias \n\n-Dirección de la Escuela de Antropología\n-Docentes de la Escuela de Antropología \n-Área virtual de Antropología\n-Curaduria MUA\n-Museografia MUA\n-Coordinacion Coro'),(8,'Federico Garcia Lorca','Calle Arce y 17ª avenida Sur (San Salvador,El Salvador)','http://utecgo.000webhostapp.com/images/edificios/fgl.jpg',1,'Dependencias\n\n-Decanato de Ciencias Sociales \n-Dirección de Escuela de Comunicaciones\n-Estudio de Television\n-Laboratorio de Radio\n-Radio Utec,970 AM\n-Sala de Redacción\n-Biblioteca especializada de Comunicaciones\n-Salón de usos multiples\n-Departamento de Periodismo\n-Departamento de Relaciones Publicas\n-Departamento de Publicidad y audiovisuales\n-Cátedra de Genero\n-Aulas'),(9,'Laboratorio 10','Edificio Benito Juarez','http://utecgo.000webhostapp.com/images/laboratorios/Lab10.jpg',2,'Laboratorio de Academía de Microsoft\r\n\r\nEdificio Benito Juarez, 2ª planta'),(10,'Laboratorio 3','Edificio Benito Juarez','http://utecgo.000webhostapp.com/images/laboratorios/Lab3.jpg',2,'Laboratorio nº 3 de Informática\r\n\r\nEdificio Benito Juarez, sotano'),(11,'Thomas Jefferson','Calle Arce y 17ª avenida Sur','http://utecgo.000webhostapp.com/images/edificios/tf.jpg',1,'Dependencias\n\n-Biblioteca de Maestrias\n-Aulas 1 a 9\n-Aula Magna\n-Instituto de Graduados\n-Laboratorio 11 de Informatica\n-Dirección de Centro de formación profesional\n-Centro de Desarrollo de Micro y Pequeñas Empresas,Ç\nCDMYPE'),(12,'Gabriela Mistral','1ª calle Poniente y 19ª avenida Norte','http://utecgo.000webhostapp.com/images/edificios/GM.jpg',1,'\r\n\r\nDependencias\r\n\r\n-Administración Academica\r\n-Nuevo Ingreso\r\n-Colecturia\r\n-Archivo\r\n-Dirección de la Escuela de Ciencias Aplicadas\r\n-Derección de la Escuela de Informática\r\n-Coordinación de Procesos Industriales\r\n-Coordinación del área de Arquitectura y Diseño\r\n-Decanato de Informática y Ciencias aplicadas\r\n-Decanato de estudiantes\r\n-Doncentes de Redes\r\n-Incubadora Genius\r\n-Bolsa de Empleo\r\n'),(13,'Dr. Jose Adolfo Araujo Ramagoza','19ª avenida Sur, 1045','http://utecgo.000webhostapp.com/images/edificios/JAA.PNG',1,'Dependencias\r\n\r\n-Vicerrectoria de Investigación y Proyección Social\r\n-Dirección de Investigaciones\r\n-Sala de docentes investigadores\r\n-Biblioteca de Investigaciones\r\n-Dirección de Desarrollo Academico\r\n-Dirección de Proyección Social\r\n-Dirección de inteligencia corporativa'),(14,'Giuseppe Garibaldi','1ª calle poniente y 19ª avenida Norte','http://utecgo.000webhostapp.com/images/edificios/GG.jpg',1,'Dependencias\r\n\r\n-Dirección de Escuela de Idiomas\r\n-Biblioteca especializada de Idiomas\r\n-Laboratorio 5 y 6 de Informática aplicada al Ingles\r\n-Sala de docentes\r\n-Aula Magna\r\n-Departamento de Castellano\r\n-Unidad de Egresados\r\n-Laboratorio 9 de Arquitectura y diseño\r\n-Aulas'),(15,'Jorge Luis Borges','1ª Calle Poniente, 1137','https://utecgo.000webhostapp.com/images/edificios/JLB.jpg',1,'Dependencias\r\n\r\n-Librería Multilibros\r\n-Laboratorio de fotografía\r\n-Estudio de fotografía publicitaria\r\n-Aula 201\r\n-Aula 301'),(16,'Laboratorio 2 de Informatica','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/laboratorios/Lab2.jpg',2,'Laboratorio nº 2 de Informática\r\n\r\nEdificio Francisco Morazan, 5ª planta'),(17,'Laboratorio 1 ','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/laboratorios/Lab1-7.jpg',2,'Laboratorio nº 1 de Informática \r\n\r\nEdificio Francisco Morazan, 5ª planta'),(18,'Auditorio de la paz','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/auditorios/au_delapaz.jpg',3,'Ubicación \r\n\r\nCalle Arce, 1026 , 1ª planta\r\nEdificio Francisco Morazan'),(19,'Auditorio Dr. Rufino Garay','Edificio \r\nSimon Bolivar','http://utecgo.000webhostapp.com/images/auditorios/au_rufino.jpg',3,'Ubicación \r\n\r\nCalle Arce, 1020 , 1ª planta\r\nEdificio Simon Bolivar'),(20,'Laboratorio 8 de Redes','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/laboratorios/Lab8.jpg',2,'Laboratorio de Redes\r\n\r\nEdificio Francisco Morazan, 4ª planta'),(21,'Laboratorio de Cisco','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/laboratorios/LabCisco.jpg',2,'Laboratorio de Cisco\r\n\r\nEdificio Francisco Morazan, 1ª planta'),(22,'Biblioteca central','Edificio Benito Juarez','http://utecgo.000webhostapp.com/images/bibliotecas/b_bj.jpg',4,'Biblioteca Central\r\n\r\nCalle Arce,1114,1ª planta\r\nEdificio Benito Juarez\r\n\r\nEs una biblioteca general,caracterizada por contener los recursos de informacion de las areas comunes a todas las carreras,como Matematica, Estadistica y Metodología de la investigacion,ademas contiene recursos de informacion de Ingenieria ,Informática y Arquitectura.'),(23,'Biblioteca de Idiomas','Edificio Giusseppe Garibaldi','http://utecgo.000webhostapp.com/images/bibliotecas/b_ingles.jpg',4,'Biblioteca de Idiomas\r\n\r\n1ª calle poniente y 19 Av. Norte\r\nEdificio Giuseppe Garibaldi\r\n\r\nEspecializada en recursos de información para\r\nla enseñanza del idioma inglés, y cuenta con\r\nrecursos informativos en diferentes idiomas,\r\ncomo inglés, portugués, alemán, francés, entre\r\notros; su orientación principal es prestar servicio\r\na los estudiantes de la escuela de Idiomas.'),(24,'Biblioteca de negocios','Edificio Francisco Morazan','http://utecgo.000webhostapp.com/images/bibliotecas/b_morazan.jpg',4,'Biblioteca de Negocios\r\n\r\nCalle Arce, 1026, 1.ª planta\r\nEdificio Francisco Morazán\r\n\r\nEspecializada en recursos de información de\r\nnegocios, turismo, economía, mercadeo, comercio\r\nnacional e internacional, contabilidad,\r\nentre otros.\r\n\r\nOrientada principalmente a usuarios de las\r\ncarreras de Administración de Empresas,\r\nContaduría Pública y Mercadeo. Se cuenta\r\ncon un área de lectura para docentes.');

#
# Structure for table "lugares_coordenadas"
#

DROP TABLE IF EXISTS `lugares_coordenadas`;
CREATE TABLE `lugares_coordenadas` (
  `id_lugares_coordenadas` int(11) NOT NULL AUTO_INCREMENT,
  `id_coor` int(11) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  PRIMARY KEY (`id_lugares_coordenadas`),
  KEY `id_coor` (`id_coor`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `lugares_coordenadas_ibfk_1` FOREIGN KEY (`id_coor`) REFERENCES `coordenadas` (`id_coor`),
  CONSTRAINT `lugares_coordenadas_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

#
# Data for table "lugares_coordenadas"
#

INSERT INTO `lugares_coordenadas` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,10),(11,11,11),(12,12,12),(13,13,13),(14,14,14),(15,15,15),(16,16,16),(17,17,17),(18,18,18),(19,19,19),(20,20,20),(21,21,21),(22,22,22),(23,23,23),(24,24,24);

#
# Structure for table "horarios"
#

DROP TABLE IF EXISTS `horarios`;
CREATE TABLE `horarios` (
  `id_horario` varchar(200) NOT NULL,
  `dia` varchar(10) NOT NULL,
  `hora` time NOT NULL,
  `materia` varchar(20) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "horarios"
#


#
# Structure for table "usuarios"
#

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` varchar(15) NOT NULL,
  `contrasena` varchar(200) NOT NULL,
  `recuperacion` varchar(20) NOT NULL,
  `id_tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_tipo` (`id_tipo`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "usuarios"
#

INSERT INTO `usuarios` VALUES ('1531232014','202cb962ac59075b964b07152d234b70','ellaksjssj','1'),('1712352015','04062f9ee6b48c8c329a03a474622a2e','ellaniamor','1'),('2512732014','bd63ffcfe0c6beb1c66852282f257b94','comida','1'),('2515642015','8e27f99c93d1370f3bd04575082696df','xd todo','1'),('2532492016','360af55e0e182fa1588743956fb14e99','sodas1','1');

#
# Structure for table "recordatorios"
#

DROP TABLE IF EXISTS `recordatorios`;
CREATE TABLE `recordatorios` (
  `id_recordatorio` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `descripcion` longtext NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_usuario` varchar(15) NOT NULL,
  PRIMARY KEY (`id_recordatorio`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `recordatorios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "recordatorios"
#


#
# Structure for table "lugares_recordados"
#

DROP TABLE IF EXISTS `lugares_recordados`;
CREATE TABLE `lugares_recordados` (
  `id_lugares_re` varchar(100) NOT NULL,
  `id_lugares_coordenadas` int(11) NOT NULL,
  `id_recordatorio` varchar(10) NOT NULL,
  PRIMARY KEY (`id_lugares_re`),
  KEY `id_lugares_coordenadas` (`id_lugares_coordenadas`),
  KEY `id_recordatorio` (`id_recordatorio`),
  CONSTRAINT `lugares_recordados_ibfk_1` FOREIGN KEY (`id_lugares_coordenadas`) REFERENCES `lugares_coordenadas` (`id_lugares_coordenadas`),
  CONSTRAINT `lugares_recordados_ibfk_2` FOREIGN KEY (`id_recordatorio`) REFERENCES `recordatorios` (`id_recordatorio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "lugares_recordados"
#

