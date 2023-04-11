CREATE TABLE CLIENTE
(
	Id varchar (10),
	Nombre varchar (255) NOT NULL,
	Correo varchar(255) NOT NULL,
	Telefono varchar (10) NOT NULL,
	TipoMiembro varchar(15) NOT NULL,
	CHECK (TipoMiembro in ('Estudiante', 'Profesor', 'Empleado', 'Egresado', 'PadreEstudiante')),
	CONSTRAINT Cliente_PK PRIMARY KEY (Id)
);
CREATE TABLE OPERADOR
(
	Id varchar (10),
	Nombre varchar (255) NOT NULL,
	TipoOperador varchar (21) NOT NULL,
	CHECK (TipoOperador in ('Estudiante','Vecino', 'Profesor', 'ServicioHotelero', 'Egresado', 'PadreEstudiante', 'ViviendaUniversitaria')),
	CONSTRAINT Operador_PK PRIMARY KEY (Id)
);
CREATE TABLE INMUEBLE
(
	Id varchar (10),
    Operador varchar (10),
	CostoBase numeric (7,0) NOT NULL,
	FOREIGN KEY (Operador) REFERENCES operador(Id),
	CONSTRAINT Inmueble_PK PRIMARY KEY (Id)
);
CREATE TABLE SERVICIO
(
	Id varchar (10),
	Nombre varchar(20) NOT NULL, 
	Descripcion varchar(255) NOT NULL,
	CONSTRAINT Servicio_PK PRIMARY KEY (Id)
);
CREATE TABLE APARTAMENTO
(
    Id varchar (10),
	CantHabitaciones numeric (2,0) NOT NULL,
	Amoblado varchar(5) NOT NULL,
	FOREIGN KEY (Id) REFERENCES Inmueble(Id),
	CONSTRAINT Apartamento_PK PRIMARY KEY (Id)
);
CREATE TABLE CASA
(
    Id varchar(10),
	CantHabitaciones numeric (2,0) NOT NULL,
	Seguro varchar (255),
	FOREIGN KEY (Id) REFERENCES Inmueble(Id),
	CONSTRAINT Casa_PK PRIMARY KEY (Id)
);
CREATE TABLE HABITACION
(
    Id varchar(10),
	Capacidad numeric (2,0) NOT NULL,
	Compartida varchar(5) NOT NULL,
	Tipo varchar(9) NOT NULL,
	CHECK (Tipo in ('Suite', 'Estandar', 'Semisuite')),
	FOREIGN KEY (Id) REFERENCES Inmueble(Id),
	CONSTRAINT Habitacion_PK PRIMARY KEY (Id)
);
CREATE TABLE HOSTAL
(
    Id varchar(10),
	CantHabitaciones numeric (2,0) NOT NULL,
	RegistroCamaraComercio varchar (255) NOT NULL,
	RegistroSuperintendencia varchar (255) NOT NULL,
	HoraApertura varchar(255) NOT NULL,
	HoraCierre varchar(255) NOT NULL,
	FOREIGN KEY (Id) REFERENCES Operador(Id),
	CONSTRAINT Hostal_PK PRIMARY KEY (Id)
);
CREATE TABLE HOTEL
(
    Id varchar(10),
	CantHabitaciones numeric (2,0) NOT NULL,
	RegistroCamaraComercio varchar (255) NOT NULL,
	RegistroSuperintendencia varchar (255) NOT NULL,
	FOREIGN KEY (Id) REFERENCES Operador(Id),
	CONSTRAINT Hotel_PK PRIMARY KEY (Id)
);
CREATE TABLE PERSONANATURAL
(
    Id varchar(10),
	Correo varchar (255) NOT NULL,
	Telefono varchar (10) NOT NULL,
	FOREIGN KEY (Id) REFERENCES Operador(Id),
	CONSTRAINT PersonaNatural_PK PRIMARY KEY (Id)
);
CREATE TABLE RESERVA
(
	Id varchar (10),
    Cliente varchar(10),
    Inmueble varchar(10),
	FechaInicio varchar(10) NOT NULL,
	FechaFin varchar(10) NOT NULL,
	FOREIGN KEY (Cliente) REFERENCES Cliente(Id),
	FOREIGN KEY (Inmueble) REFERENCES Inmueble(Id), 
	CONSTRAINT Reserva_PK PRIMARY KEY (Id)
);
CREATE TABLE SERVICIOINMUEBLE
(
    Servicio varchar(10),
    Inmueble varchar(10),
	Incluido varchar(5) NOT NULL, 
	ValorAdicional numeric(6) NOT NULL,
	FOREIGN KEY (Servicio) REFERENCES Servicio(Id),
	FOREIGN KEY (Inmueble) REFERENCES Inmueble(Id),
	CONSTRAINT ServicioInmueble_PK PRIMARY KEY (Servicio, Inmueble)
);
CREATE TABLE SERVICIOSUSADOS
(
    Servicio varchar(10),
    Inmueble varchar(10),
    Reserva varchar(10),
	FOREIGN KEY (Servicio, Inmueble) REFERENCES ServicioInmueble(Servicio, Inmueble),
	FOREIGN KEY (Reserva) REFERENCES Reserva(Id),
	CONSTRAINT ServiciosUsados_PK PRIMARY KEY (Servicio, Inmueble, Reserva)
);
CREATE TABLE VIVIENDAUNIVERSITARIA
(
    Id varchar(10),
	CantHabitaciones numeric (3) NOT NULL,
	FOREIGN KEY (Id) REFERENCES Operador(Id),
	CONSTRAINT Vivienda_PK PRIMARY KEY (Id)
);