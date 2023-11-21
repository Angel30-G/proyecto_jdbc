#Integrantes:

#Nombre: Angel Gabriel Vargas Varela 
#Carnet: 2021080292

#Nombre: Jose Daniel Montero Mora
#Carnet: 2020148558

create database TallerCR;
show databases;
use TallerCR;


create table taller(
  id int not null auto_increment,
  nombre varchar(50) not null,
  provincia varchar(50) not null,
  canton varchar(50) not null,
  distrito varchar(50) not null,
  otras_señas varchar(50) not null,
  costo_operacion int not null,
  horas_de_trabajo int,
  telefono int not null,
  nombre_usuario varchar(50) not null,
  email varchar(50) not null,
  contraseña varchar(50) not null,
  primary key(id)
);

  
  
create table cliente(
  id int not null auto_increment,
  numero_cliente int not null,
  cedula int not null,
  tipo_cedula varchar(50) not null,
  telefono int not null,
  email varchar(50) not null,
  taller int,
  primary key(id),
  foreign key(taller) references taller(id)
);

create table vehiculo(
  id int not null auto_increment,
  numero_placa varchar(50) not null,
  marca varchar(50) not null,
  modelo varchar(50) not null,
  año_fabricacion date not null,
  VIN varchar(50) not null,
  cliente int,
  primary key(id),
  foreign key(cliente) references cliente(id)
);
  

create table pieza(
  id int not null auto_increment,
  codigo varchar(50) not null,
  descripcion varchar(50) not null,
  costo int not null,
  primary key(id)
);

create table servicio(
  id int not null auto_increment,
  fecha_ingreso date not null,
  fecha_conclusion date,
  descripcion varchar(50) not null,
  horas_invertidas int not null,
  costo_total_mano_de_obra int not null,
  costo_total_facturado int,
  porcentaje_utilidad int,
  vehiculo int,
  primary key(id),
  foreign key(vehiculo) references vehiculo(id)
);

create table piezas_compradas(
  id int not null auto_increment,
  codigo varchar(50) not null,
  cantidad int not null,
  costo_total int not null,
  pieza int,
  servicio int,
  primary key(id),
  foreign key(pieza) references pieza(id),
  foreign key(servicio) references servicio(id)
);

-- Procedimiento almacenado para calcular datos financieros
delimiter //
create procedure calcular_datos_financieros(servicio_id int)
begin
    declare costo_minimo_operacion_hora int;
    declare costo_unitario_mano_obra_hora int;
    declare costo_total_facturado int;
    declare costo_total_piezas int;
    declare porcentaje_utilidad_p int;
    
   SELECT (SELECT taller.costo_operacion / taller.horas_de_trabajo FROM taller, servicio WHERE taller.id = servicio.id) INTO costo_minimo_operacion_hora;
    
   SELECT (SELECT costo_total_mano_de_obra / horas_invertidas  FROM servicio WHERE servicio.id = servicio_id) INTO costo_unitario_mano_obra_hora;

   SELECT SUM(pc.costo_total) INTO costo_total_piezas FROM piezas_compradas pc WHERE pc.pieza = servicio_id;
    
    set porcentaje_utilidad_p = ((costo_unitario_mano_obra_hora / costo_minimo_operacion_hora) - 1) * 100;
    
    if porcentaje_utilidad_p < 0 then
        signal sqlstate '45000'
        set message_text = 'El porcentaje de utilidad es negativo';
    end if;

    update servicio
    set 
        costo_total_facturado = costo_total_mano_de_obra + costo_total_piezas,
        porcentaje_utilidad = porcentaje_utilidad_p
    where id = servicio_id;
end;
//
delimiter ;



delimiter //
create trigger validar_costo_unitario
before insert on servicio
for each row
begin
    declare costo_minimo_operacion_hora int;
    declare costo_unitario_mano_obra_hora int;

    -- Obtener el costo mínimo de operación por hora del taller
    SELECT taller.costo_operacion / taller.horas_de_trabajo INTO costo_minimo_operacion_hora
    FROM taller, servicio
    WHERE taller.id = servicio.id;

    -- Obtener el costo unitario de mano de obra por hora del servicio
    SELECT NEW.horas_invertidas / NEW.costo_total_mano_de_obra INTO costo_unitario_mano_obra_hora;

    -- Validar la condición
    if costo_unitario_mano_obra_hora < costo_minimo_operacion_hora then
        signal sqlstate '45000'
        set message_text = 'El costo unitario de mano de obra por hora es menor al costo mínimo de operación por hora';
    end if;
end;
//
delimiter ;




  
-- Insert into taller table
INSERT INTO taller (nombre, provincia, canton, distrito, otras_señas, costo_operacion, horas_de_trabajo, telefono, nombre_usuario, email, contraseña) 
VALUES
  ('Taller A', 'San Jose', 'Escazu', 'San Rafael', 'Dos cuadras a la derecha del chino', 500000, 165, 22334455, 'Usuario1', 'tallerA@gmail.com', 'Contraseña1');
  
-- Insert into cliente table
INSERT INTO cliente (numero_cliente, cedula, tipo_cedula, telefono, email, taller) 
VALUES
  (1, 123456789, 'Física', 22223333, 'cliente1@gmail.com', 1);

-- Insert into vehiculo table
INSERT INTO vehiculo (numero_placa, marca, modelo, año_fabricacion, VIN, cliente) 
VALUES
  ('ABC123', 'Toyota', 'Camry', '2020-01-01', '123ABC', 1);


-- Insert into pieza table
INSERT INTO pieza (codigo, descripcion, costo) 
VALUES
  ('P001', 'Batería', 100);
  
-- Insert into servicio table
INSERT INTO servicio (fecha_ingreso, fecha_conclusion, descripcion, horas_invertidas, costo_total_mano_de_obra, costo_total_facturado, porcentaje_utilidad, vehiculo) 
VALUES
  ('2023-01-01', '2023-01-05', 'Reparación de motor', 7, 40000, null, null, 1);
  

INSERT INTO servicio (fecha_ingreso, fecha_conclusion, descripcion, horas_invertidas, costo_total_mano_de_obra, costo_total_facturado, porcentaje_utilidad, vehiculo) 
VALUES
  ('2023-01-01', '2023-01-05', 'Reparación de motor', 7, 21000, null, null, 1);

-- Insert into piezas_compradas table
INSERT INTO piezas_compradas (codigo, cantidad, costo_total, pieza, servicio) 
VALUES
  ('P001', 2, 200, 1, 1);


  
call calcular_datos_financieros(1);

select * from servicio;


