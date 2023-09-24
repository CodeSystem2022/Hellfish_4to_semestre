# Profundizando en tipo float
a = 3.0

# float() puede recibir str e int
a = float(10)
a = float("10")
print(f"a: {a:.2f}")

# Notacion exponencial (positivos negativos)
a = 3e5
print(f"a: {a:.2f}")

a = 3e-5
print(f"a: {a:.5f}")

# Cualquier cálculo que incluya a un float, resulta en un tipo float
a = 4.0 + 5
print(a)
print(type(a))
