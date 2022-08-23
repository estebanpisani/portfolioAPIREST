# Portfolio Web (API REST)
API REST desarrollada con Spring Boot para [Argentina Programa](https://argentinaprograma.inti.gob.ar/)

## Funcionalidades

- [ ] CRUD Trabajo
- [ ] CRUD Proyecto
- [ ] CRUD Educacion
- [ ] CRUD Persona
- [ ] Autenticacion y Autorización de Usuario vía JWT

## Endpoints

**Nota:** Salvo solicitudes GET, todas requieren autenticación.

### Authenticación de Usuario:

- `/api/auth/login`
- `/api/auth/signup`

### Persona

- `[GET] /api/persona`: Obtiene datos personales del dueño del portfolio.
- `[POST] /api/persona`: Guarda uno nuevo perfil personal (por ahora deshabilitado).
- `[PUT] /api/persona`: Actualiza los datos del perfil personal.
- `[DELETE] /persona/:id`: Elimina la información del perfil.

### Trabajos

- `[GET] /api/trabajo/list`: lista todas las experiencias laborales disponibles en la base de datos.
- `[POST] /api/trabajo/save`: Agrega un nueva experiencia laboral.
- `[GET] /api/trabajo/:id`: Obtiene información de una experiencia laboral específica.
- `[PUT] /api/educacion/edit/:id`: Actualiza la información de una experiencia laboral específica.
- `[DELETE] /api/trabajo/delete/:id`: Elimina una experiencia laboral de la base de datos.

### Estudios

- `[GET] /api/educacion/list`: lista todos los estudios disponibles en la base de datos.
- `[POST] /api/educacion/save`: Agrega un nuevo estudio.
- `[GET] /api/educacion/:id`: Obtiene información de un estudio en específico.
- `[PUT] /api/educacion/edit/:id`: Actualiza la información de un estudio específico.
- `[DELETE] /api/educacion/delete/:id`: Elimina un estudio de la base de datos.

### Proyectos

- `[GET] /api/proyecto/list`: lista todos los proyectos disponibles en la base de datos.
- `[POST] /api/proyecto/save`: Agrega un nuevo proyecto.
- `[GET] /api/proyecto/:id`: Obtiene información de un proyecto en específico.
- `[PUT] /api/proyecto/edit/:id`: Actualiza la información de un proyecto específico.
- `[DELETE] /api/proyecto/delete/:id`: Elimina un proyecto de la base de datos.


## Autor
Esteban Pisani
