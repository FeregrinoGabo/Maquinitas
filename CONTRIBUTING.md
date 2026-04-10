# INFORMACIÓN NECESARIA

### Reglas de bases de datos
La finalidad de las reglas es que todos los involucrados sepan que hay acciones que no deben cometerse, esto dado que se 
podría ver comprometida la información de la base de datos.

* No HARD DELETES: Nunca debe ser usado repository.delete(). El sistema requiere la integridad de los datos.
* Solo se debe usar SOFT DELETES: Usar campos que permitan filtrar la información por elementos activos o inactivos. 
Ejemplo: el modelo "Usuario" tiene este campo "    private LocalDateTime fechaRetiro;", esto me permite identificar 
cuando no debo tomar en cuenta a ciertos usuarios. 
* Auditoria: asegurarse siempre que el usuario esta relacionado con Corte y Asignación.