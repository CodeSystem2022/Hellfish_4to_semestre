class Usuario:
    def __init__(self, id_usuario=None, username=None, pw=None):
        self._id_usuario = id_usuario
        self._username = username
        self._password = pw

    def __str__(self):
        return f"Usuario: {self._id_usuario}, {self._username}, {self._username}"

    # Metodos get y set
    @property
    def id_usuario(self):
        return f"{self._id_usuario}"

    @property
    def username(self):
        return f"{self._username}"

    @property
    def password(self):
        return f"{self._password}"

    @id_usuario.setter
    def id_usuario(self, id):
        self._id_usuario = id

    @username.setter
    def username(self, n):
        self._username = n

    @password.setter
    def password(self, p):
        self._password = p