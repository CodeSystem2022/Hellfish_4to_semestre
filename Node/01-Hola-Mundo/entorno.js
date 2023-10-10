let nombre = process.env.NOMBRE || "Sin nombre";
let web = process.env.MI_WEB || "Sin web";

// para introducir esa variable de entorno al ejecutar
// $env:NOMBRE="Carlos"; node entorno

// Si no se establece, será undefined, a menos que || "a"

// El valor se guarda como en una memoria cache
// por lo que solo es necesario declarar estas variables de
// esa forma, solo una vez

console.log("Hola " + nombre);
console.log("web: " + web);
