function hola(nom, miCallback) {
    setTimeout( function() {
        console.log("Hola " + nom);
        miCallback(nom);
    }, 1000);
}

function adios(nom, otroCallback) {
    setTimeout( function() {
        console.log("Adios " + nom);
        otroCallback();
    }, 1500);
}

console.log("Iniciando el programa");

hola("carlos", function(nombre) {

    adios(nombre, function() {
        console.log("Finalizando el programa");
    });
});

//hola("Carlos", function() {})
//adios("Carlos", function() {})
