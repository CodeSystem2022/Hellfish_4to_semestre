const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");

const cartBtn = document.getElementById("cart-btn");
const cartCounter = document.getElementById("cart-counter");

const displayCart = () => {
    modalContainer.innerHTML = "";
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";
    
    // Modal header
    const modalHeader = document.createElement("div");

    const modalClose = document.createElement("div");
    modalClose.innerText = "❌"
    modalClose.className = "modal-close";
    modalHeader.append(modalClose);

    modalClose.addEventListener("click", () => {
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    });
    
    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Cart";
    modalTitle.className = "modal-title"
    modalHeader.append(modalTitle);

    modalContainer.append(modalHeader);
    
    // Modal body
    cart.forEach((p) => {
        const modalBody = document.createElement("div");
        modalBody.className = "modal-body";
        modalBody.innerHTML = `
        <div class="product">
            <img class="product-img" src="${p.img}">
            <div class="product-info">
                <h4>${p.productName}</h4>
            </div>
            <div class="quantity">
                <span class="quantity-btn-decrease">-</span>
                <span class="quantity-input">${p.quantity}</span>
                <span class="quantity-btn-increase">+</span>
            </div>
            <div class="price">$ ${p.price * p.quantity}</div>
            <div class="delete-product">X</div>
        </div>
        `;
        modalContainer.append(modalBody);

        // decrease product
        const d = modalBody.querySelector(".quantity-btn-decrease");
        d.addEventListener("click", () => {
            if (p.quantity !== 1) {
                p.quantity--;
                displayCart();
            }
            displayCartCounter();
        })

        // increase product
        const i = modalBody.querySelector(".quantity-btn-increase");
        i.addEventListener("click", () => {
            p.quantity++;
            displayCart();
            displayCartCounter();
        })
        
        // delete product
        const dP = modalBody.querySelector(".delete-product");
        dP.addEventListener("click", () => {
            deleteCartProduct(p.id);
        })
    });

    // total
    const total = cart.reduce((acc, el) => acc + el.price * el.quantity, 0);
    
    // Modal footer
    const modalFooter = document.createElement("div");
    modalFooter.className = "modal-footer";
    modalFooter.innerHTML = `
    <div class="total-price">Total: ${total}</div>
    `;
    modalContainer.append(modalFooter);
};

cartBtn.addEventListener("click",displayCart);

const deleteCartProduct = (id) => {
    const fId = cart.findIndex((elem) => elem.id === id);
    cart.splice(fId, 1);
    displayCart();
    displayCartCounter();
};

const displayCartCounter = () => {
    const cartLength = cart.reduce((acc, el) => acc + el.quantity, 0);
    
    if (cartLength > 0) {
        cartCounter.style.display = "block";
        cartCounter.innerText = cartLength;
        
    } else {
        cart.style.display = "none";
    }
};
