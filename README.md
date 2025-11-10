# Gestor de turnos hospitalarios

Mini-ecommerce en consola en C# para Practicas de Patrones de Diseno.

---

## Resumen rapido
Sistema de gestion hospitalaria en Java, centrado en el agendamiento de citas medicas.  
Desarrollado con enfoque en Programacion Orientada a Objetos (POO).
Incluye operaciones **CRUD** (Crear, Leer, Actualizar y Eliminar) con persistencia en una **base de datos SQL Server**.

---

## Equipo
- <img src="https://avatars.githubusercontent.com/u/179079172?v=4" width="24" height="24"> [Lautaro Vallejo](https://github.com/lautaro-vallejo)
- <img src="https://avatars.githubusercontent.com/u/100593063?v=4" width="24" height="24"> [Lucas Varela](https://github.com/LucasfVarela) 
- <img src="https://avatars.githubusercontent.com/u/179088507?v=4" width="24" height="24"> [Lautaro Nuccitelli](https://github.com/lautaronuccitelli)

---

## Caracteristicas
### Gestion de Pacientes
CRUD completo para registrar, modificar y eliminar pacientes.  
Campos: nombre, apellido, documento, contacto, fecha de nacimiento y sexo.

### Gestion de Medicos
Registra medicos con sus datos personales, especialidad y horarios de atencion  
(Horario_Desde / Horario_Hasta).

### Gestion de Turnos
Permite crear citas medicas, asignando un paciente y un medico con detalles de  
fecha, horario y observaciones.

### Persistencia de Datos
Utiliza un DAO Generico para comunicarse con la base de datos mediante JDBC.

---

 **Lenguaje:** Java 21  
- **Base de datos:** Microsoft SQL Server  
- **Interfaz grafica:** Java Swing (`javax.swing`)  
- **Conexion:** JDBC (Driver: `mssql-jdbc-13.2.1.jre11.jar`)

---


## Requisitos
- **JDK:** 21 o superior  
- **Base de datos:** Instancia local de SQL Server  
- **Driver JDBC:** `mssql-jdbc-13.2.1.jre11.jar`

---

## Uso rapido (menu principal)
El menu principal permite acceder a las siguientes secciones:

- **Pacientes:** Abre la ventana de gestion CRUD de pacientes.  
- **Medicos:** Abre la ventana de gestion CRUD de medicos.
- **Turnos:** Abre la ventana de gestion CRUD de medicos.

---

## Patrones de diseño aplicados

### DAO (Data Access Object)
Implementado mediante interfaces GenericDAO y clases abstractas GenericDAOImpl,  
separa la logica de negocio del acceso a datos.

### MVC (Modelo - Vista - Controlador)
Estructura del proyecto basada en el patron MVC:
- Modelos: entidades del sistema (Paciente, Medico, Turno).  
- Vistas: formularios  (Forms).  
- Controladores: manejan la logica y comunicacion entre modelo y vista.

---
### DIAGRAMA DE FRECUENCIA:

![diagrama de frecuencia](https://github.com/user-attachments/assets/28fe0fe0-c838-4620-a992-c0f726a99825)

---

### CASO DE USO

![caso de uso](https://github.com/user-attachments/assets/97108999-4e47-43e0-b174-1bbe2883be79)


