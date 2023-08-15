from conexion import Conexion
from Persona import Persona
from logger_base import log
from cursor_del_pool import CursorDelPool


class PersonaDAO:
    """
    Data Access Object
    Contiene elementos CRUD
    """
    _SELECCIONAR = "SELECT * FROM persona ORDER BY \"idPersona\";"
    _INSERTAR = "INSERT INTO persona(nombre, apellido, email) VALUES (%s, %s, %s)"
    _ACTUALIZAR = "UPDATE persona SET nombre=%s, apellido=%s, email=%s WHERE \"idPersona\"=%s"
    _ELIMINAR = "DELETE FROM persona WHERE \"idPersona\"=%s"

    # definimos los métodos de clase
    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            cursor.execute(cls._SELECCIONAR)
            registros = cursor.fetchall()
            personas = []
            for r in registros:
                p = Persona(r[0], r[1], r[2], r[3])
                personas.append(p)
            return personas

    @classmethod
    def insertar(cls, p):
        with CursorDelPool() as cursor:
            valores = (p.nombre, p.apellido, p.email)
            cursor.execute(cls._INSERTAR, valores)
            log.debug(f"Persona insertada: {p}")
            return cursor.rowcount

    @classmethod
    def actualizar(cls, p):
        with CursorDelPool() as cursor:
            valores = (p.nombre, p.apellido, p.email, p.id_persona)
            cursor.execute(cls._ACTUALIZAR, valores)
            log.debug(f"Persona actualizada: {p}")
            return cursor.rowcount

    @classmethod
    def eliminar(cls, p):
        with CursorDelPool() as cursor:
            valores = (p.id_persona,)
            cursor.execute(cls._ELIMINAR, valores)
            log.debug(f"Persona eliminada: {p}")
            return cursor.rowcount


if __name__ == "__main__":
    # Eliminar
    p1 = Persona(id_persona=12)
    pe = PersonaDAO.eliminar(p1)
    log.debug(f"Personas eliminadas: {pe}")

    # Actualizar
    p1 = Persona(1, "Josefina", "Nopenaxd", "Asdff@sss.ddd")
    pa = PersonaDAO.actualizar(p1)
    log.debug(f"Personas actualizadas: {pa}")

    # Insertar
    p1 = Persona(nombre="Mateo", apellido="Omg", email="jklñ@fdsa.asd")
    personas_insertadas = PersonaDAO.insertar(p1)
    log.debug(f"Personas insertadas: {personas_insertadas}")

    # Seleccionar
    personas = PersonaDAO.seleccionar()
    for p in personas:
        log.debug(p)
