import math
from decimal import Decimal

# NAN (Not a Number)
a= float('NaN')
print(f'a: {a}')

# Módulo Math
a = float('nan')
print(f'Es el tipo NaN(Not a Number)?: {math.isnan(a)}')

# Módulo Decimal
a = Decimal('nan')
print(f'Es el tipo NaN(Not a Number)?: {math.isnan(a)}')