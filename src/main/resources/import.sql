INSERT INTO alumnos (nombre,apellido,dni,email,telefono,direccion,codigo_postal) VALUES('Jose','Perez','64927502D','jp@hotmail.com',65433223,'Calle Callao','28867');
INSERT INTO alumnos (nombre,apellido,dni,email,telefono,direccion,codigo_postal) VALUES('Carlos','Lopez','19253409U','cl@hotmail.com',65433223,'Avenida de la Paz','28022');
INSERT INTO alumnos (nombre,apellido,dni,email,telefono,direccion,codigo_postal) VALUES('Maria','Orillana','24673420T','mo@hotmail.com',65433223,'Via Complutense','28037'); 
INSERT INTO alumnos (nombre,apellido,dni,email,telefono,direccion,codigo_postal) VALUES('Dina','Ramirez','99816395K','dr@hotmail.com',65433223,'Calle Pepito','28044');

INSERT INTO usuarios (enabled, password, username) VALUES (1, "$2a$10$Hc514jSQyq8Rhvk6FukhEObvmDzy/vOygDf2c.LxwgWuh1K9zxBmi", "ana");
INSERT INTO usuarios (enabled, password, username) VALUES (1, "$2a$10$U.n3HQfYNTB2SZLXSjoIFuomTRx.RZZoSHkZSEk/bUKNqUFkfLgR6", "admin");
INSERT INTO usuarios (enabled, password, username) VALUES (1, "$2a$10$AQvUWSkbSLeNj1/B2af0YO6DdKVB5DyzS3XHY0RX5/xEkFWhHnZU.", "pepe");
INSERT INTO usuarios (enabled, password, username) VALUES (1, "$2a$10$zDxApWKSxhtPTJQyA9iXhOzSmFeBEhFaq.Z4L5LQoLX/k5B9TgyTO", "jose");

INSERT INTO roles (nombre) VALUES ("Developer");
INSERT INTO roles (nombre) VALUES ("DevOps");
INSERT INTO roles (nombre) VALUES ("Full Stack");
INSERT INTO roles (nombre) VALUES ("Frontend Developer");

INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (1, 1);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (1, 2);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (2, 3);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (2, 1);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (3, 4);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (4, 1);
INSERT INTO usuario_roll (id_usuario, id_roles) VALUES (4, 4);