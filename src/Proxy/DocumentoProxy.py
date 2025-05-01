from abc import ABC, abstractmethod

# Interfaz común
class Documento(ABC):
    @abstractmethod
    def mostrar(self):
        pass

    @abstractmethod
    def editar(self, nuevo_contenido):
        pass

# Documento real
class DocumentoReal(Documento):
    def __init__(self, contenido):
        self.contenido = contenido

    def mostrar(self):
        print("Contenido del documento:", self.contenido)

    def editar(self, nuevo_contenido):
        self.contenido = nuevo_contenido
        print("Documento actualizado. Nuevo contenido:", self.contenido)

# Proxy con control de acceso y permisos
class DocumentoProxy(Documento):
    def __init__(self, contenido, contraseña, permiso):
        """
        permiso: 'read' para solo lectura, 'write' para lectura y edición
        """
        self.documento_real = DocumentoReal(contenido)
        self.contraseña = contraseña
        self.permiso = permiso  # 'read' | 'write'

    def mostrar(self):
        if not self._verificar_acceso():
            print("¡Acceso denegado! Contraseña incorrecta.")
            return

        # lectura siempre permitida si la contraseña es correcta
        self.documento_real.mostrar()

    def editar(self, nuevo_contenido):
        if not self._verificar_acceso():
            print("¡Acceso denegado! Contraseña incorrecta.")
            return

        if self.permiso != 'write':
            print("¡Permiso denegado! No tienes permisos de edición.")
            return

        # solo usuarios con permiso 'write' llegan aquí
        self.documento_real.editar(nuevo_contenido)

    def _verificar_acceso(self):
        intento = input("Ingrese la contraseña para ver o editar el documento: ")
        return intento == self.contraseña

# Uso
if __name__ == "__main__":
    # Usuario con solo permiso de lectura
    proxy_read = DocumentoProxy("Documento confidencial v1", "1234", permiso="read")
    proxy_read.mostrar()   # → muestra el contenido
    proxy_read.editar("Intento de edición")  # → deniega el permiso de edición

    print("---")

    # Usuario con permiso de lectura y escritura
    proxy_write = DocumentoProxy("Documento confidencial v1", "abcd", permiso="write")
    proxy_write.mostrar()   # → muestra el contenido
    proxy_write.editar("Documento confidencial v2")  # → actualiza el contenido
    proxy_write.mostrar()   # → muestra el contenido actualizado
