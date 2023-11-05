# dar formato a un string

nombre = "Adriel"
edad = 28
mensa_format = "Mi nombre es %s y tengo %d años" % (nombre, edad)

# Creamos una tupla
persona = ("Carla", "Gomez", 5000.00)
mF = "Hola %s %s, tu sueldo es: %.2f"

#print(mF % persona)

nombre = "Juan"
edad = 19
sueldo = 3000

# mF = "Nombre {} Edad {} Sueldo {:.2f}".format(nombre, edad, sueldo)
# print(mF)

# m = "Nombre {0} Edad {1} Sueldo {2:.2f}".format(nombre, edad, sueldo)
# print(m)

m = "Nombre {n} Edad {e} Sueldo {s:.2f}".format(n=nombre, e=edad, s=sueldo)
# print(m)

diccionario = {"nombre": "Juan", "edad": 32, "sueldo": 8000.00}
m = "Nombre {d[nombre]} Edad {d[edad]} Sueldo {d[sueldo]:.2f}".format(d=diccionario)
print(m)
