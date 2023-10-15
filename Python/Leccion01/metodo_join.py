
#help(str.join)

tupla_str = ('Hola','alumnos','Tecnicatura','Universitaria')
mensaje = ' '.join(tupla_str)
print(f'Mensaje: {mensaje}')

lista_cursos = ['Java','Python','Angular','Spring']
mensaje = ', '.join(lista_cursos)
print(f'mensaje: {mensaje}')

cadena = 'Hola Mundo'
mensaje = ', '.join(cadena)
print(f'mensaje: {mensaje}')

diccionario = {'nombre':'Juan','apellido':'Perez','edad':'24'}
llaves = '-'.join(diccionario.keys())
valores = '-'.join(diccionario.values())
print(f'Llaves: {llaves}, Type: {type(llaves)}')
print(f'Valores: {valores}, Type: {type(valores)}')