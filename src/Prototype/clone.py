import copy

class Enemigo:
    def clonar(self):
        return copy.deepcopy(self)


class Zombi(Enemigo):
    def __init__(self, vida, daño, velocidad):
        self.vida = vida
        self.daño = daño
        self.velocidad = velocidad

    def __str__(self):
        return f"Zombi {{vida={self.vida}, daño={self.daño}, velocidad={self.velocidad}}}" #como se vera el zombi

class ZombiSaltador(Zombi):
    def __init__(self, vida, daño, velocidad, saltar):
        super().__init__(vida, daño, velocidad)
        self.saltar = saltar

    def __str__(self):
        return f"ZombiSaltador {{vida={self.vida}, daño={self.daño}, velocidad={self.velocidad}, salta={self.saltar}}}"


def juego():
    zombi_base = Zombi(100, 10, 1.5)
    zombi1 = zombi_base.clonar()
    zombi2 = zombi_base.clonar()

    zombi1.vida = 120
    zombi2.velocidad = 2.0

    zombi_Salbase = ZombiSaltador(80, 15, 2.5, True)
    zombi_Sal1 = zombi_Salbase.clonar()
    zombi_Sal1.daño = 18


    print("Zombi base:", zombi_base)
    print("Zombi 1:", zombi1)
    print("Zombi 2:", zombi2)
    print("Zombi saltador base:", zombi_Salbase)
    print("Zombi saltador 1:", zombi_Sal1)


juego()