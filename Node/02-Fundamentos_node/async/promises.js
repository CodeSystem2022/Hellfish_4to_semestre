function hola(nom) {
    return new Promise(function (resolve, reject) {
        setTimeout( function() {
            console.log("Hola " + nom);
            resolve(nom);
        }, 1000);
    })
}

function hablar(nombre) {
    return new Promise((res, rej) => {
        setTimeout( function () {
            console.log("bla bla bla");
            res(nombre);
        }, 1000);
    })
}

function adios(nom) {
    return new Promise((res, rej) => {
        setTimeout( function() {
            console.log("Adios " + nom);
            // res();
            rej("hay un error");
        }, 1500);
    })
}

// ejejej
console.log("iniciando proceso");
hola("Ariel")
    .then(hablar)
    .then(hablar)
    .then(hablar)
    .then(adios)
    .then((nombre) => {
        console.log("Terminando proceso");
    })
    .catch( e => {
        console.log("Ha habido un error: ");
        console.log(e);
    })
