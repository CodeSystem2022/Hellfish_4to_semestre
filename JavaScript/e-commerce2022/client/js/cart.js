const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");

const cartBtn = document.getElementById("cart-btn");

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
        const mB = document.createElement("div");
        mB.className = "modal-body";
        mB.innerHTML = `
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
        
        const d = modalBody.querySelector(".quantity-btn-decrease");
        d.addEventListener("click", () => {
            if (p.quantity !== 1) {
                p.quantity--;
                displayCart();
            }
        })

        const i = modalBody.querySelector(".quantity-btn-increase");
        i.addEventListener("click", () => {
            p.quantity++;
            displayCart();
        })
    });
    
    // Modal footer
    const modalFooter = document.createElement("div");
    modalFooter.className = "modal-footer";
    modalFooter.innerHTML = `
    <div class="total-price">Total: </div>
    `;
    modalContainer.append(modalFooter);
};

cartBtn.addEventListener("click",displayCart);
