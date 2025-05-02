from abc import ABC, abstractmethod

# Interfaz Handler
class Approver(ABC):
    def __init__(self):
        self.next_approver = None

    def set_next(self, approver):
        self.next_approver = approver
        return approver  # Permite encadenar

    @abstractmethod
    def handle(self, amount):
        pass

# Handler concreto: Supervisor
class Supervisor(Approver):
    def handle(self, amount):
        if amount <= 1000:
            print(f"Supervisor aprueba el gasto de ${amount}")
        elif self.next_approver:
            self.next_approver.handle(amount)
        else:
            print("No se pudo aprobar el gasto.")

# Handler concreto: Jefe de Área
class JefeArea(Approver):
    def handle(self, amount):
        if amount <= 3000:
            print(f"Jefe de Área aprueba el gasto de ${amount}")
        elif self.next_approver:
            self.next_approver.handle(amount)
        else:
            print("No se pudo aprobar el gasto.")

# Handler concreto: Gerente
class Gerente(Approver):
    def handle(self, amount):
        if amount <= 10000:
            print(f"Gerente aprueba el gasto de ${amount}")
        elif self.next_approver:
            self.next_approver.handle(amount)
        else:
            print("No se pudo aprobar el gasto.")

# Handler concreto: Director
class Director(Approver):
    def handle(self, amount):
        print(f"Director aprueba el gasto de ${amount}")

# Cliente
if __name__ == "__main__":
    # Crear manejadores
    supervisor = Supervisor()
    jefe_area = JefeArea()
    gerente = Gerente()
    director = Director()

    # Configurar cadena
    supervisor.set_next(jefe_area).set_next(gerente).set_next(director)

    # Solicitudes
    supervisor.handle(500)       # Supervisor lo aprueba
    supervisor.handle(2000)      # Jefe de Área lo aprueba
    supervisor.handle(5000)      # Gerente lo aprueba
    supervisor.handle(15000)     # Director lo aprueba