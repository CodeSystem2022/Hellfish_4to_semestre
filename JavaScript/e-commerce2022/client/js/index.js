const shopContent = document.getElementById("shopContent");
const cart = []; //Este es nuestro carrito, un array vacio

productos.forEach((product) => {
    const content = document.createElement("div");
    content.innerHTML = `
    <img src="${product.img}">
    <h3>${product.productName}</h3>
    <p class="price">${product.price} $</p>
    `;
    shopContent.append(content);

    const buyButton = document.createElement("button");
    buyButton.innerText = "Comprar";

    content.append(buyButton);

    buyButton.addEventListener("click", ()=>{
        const repeat = cart.some((prodRepe) => prodRepe.id === product.id);

        if (repeat) {
            cart.map((p) => {
                if (p.id === product.id) {p.quantity++};
            })
        } else {
            cart.push({
                id: product.id,
                productName: product.productName,
                price: product.price,
                quantity: product.quantity,
                img: product.img,
            })
        }
    })
});
