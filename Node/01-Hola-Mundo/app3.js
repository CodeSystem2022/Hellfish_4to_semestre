console.log("Inicio del programa");  // 1

setTimeout(() => {
    console.log("Primer Timeout");  // 5
}, 3000)

setTimeout(() => {
    console.log("Segundo Timeout");  // 3
}, 3000)

setTimeout(() => {
    console.log("Tercer Timeout");  // 4
}, 3000)

console.log("Fin del programa");  // 2
