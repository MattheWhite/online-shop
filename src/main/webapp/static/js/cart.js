const HTTP_POST = "POST";
const HTTP_DELETE = "DELETE";
const HTTP_PUT = "PUT";
const INCREMENT_TYPE = "INCREMENT";
const DECREMENT_TYPE = "DECREMENT";

function main() {
    // let productPrice = document.querySelectorAll(".product-price");
    // productPrice.forEach(product => {
    //     let price = product.dataset.price;
    //     product.innerHTML =
    // })
    let addToCartButtons = document.querySelectorAll(".add-to-cart");
    addToCartButtons.forEach(button => button.addEventListener('click', () => {
        let productId = button.dataset.id;
        sendProductId(productId, HTTP_POST);
    }))
    let navBar = document.querySelector('#mainNav');
    navBar.classList.add("navbar-shrink");

    let subtotalElement = document.querySelector(".subtotal");
    let subtotal = 0;

    let cartItems = document.querySelectorAll(".cart-item");
    cartItems.forEach(item => {

        let productQuantity = item.querySelector(".quantity");
        let productPrice = item.querySelector(".product-price");
        let price = productPrice.dataset.price;
        subtotal += parseInt(price) * +productQuantity.getAttribute("value");
        subtotalElement.innerHTML = `£${subtotal}.00`;
        productPrice.innerHTML = `${parseInt(price) * +productQuantity.getAttribute("value")}.00 GBP`;

        let productId = item.dataset.id;
        let trashIcon = item.querySelector(".trash-icon");
        trashIcon.addEventListener('click', () => {
            sendProductId(productId, HTTP_DELETE);
            item.remove();
        });

        let incrementButton = item.querySelector(".prod-increment");
        incrementButton.addEventListener("click", () => {
            sendProductIdWithFlag(productId, HTTP_PUT, INCREMENT_TYPE);
            let productQuantityInput = item.querySelector(".quantity");
            let productQuantity = +productQuantityInput.dataset.value + 1;
            productQuantityInput.dataset.value = String(productQuantity);
            let productPrice = item.querySelector(".product-price");
            let price = productPrice.dataset.price;
            let totalPrice = parseInt(price) * +productQuantity;
            productPrice.innerHTML = `${totalPrice}.00 GBP`;
            subtotal += parseInt(price);
            subtotalElement.innerHTML = `£${subtotal}.00`;
        })
        let decrementButton = item.querySelector(".prod-decrement");

        decrementButton.addEventListener("click", () => {
            sendProductIdWithFlag(productId, HTTP_PUT, DECREMENT_TYPE);
            let productQuantityInput = item.querySelector(".quantity");
            let productQuantity = +productQuantityInput.dataset.value - 1;
            productQuantityInput.dataset.value = String(productQuantity);
            let productPrice = item.querySelector(".product-price");
            let price = productPrice.dataset.price;
            if (productQuantity === 0) {
                item.remove();
            }
            let totalPrice = parseInt(price) * +productQuantity;
            productPrice.innerHTML = `${totalPrice}.00 GBP`;
            subtotal -= parseInt(price);
            subtotalElement.innerHTML = `£${subtotal}.00`;
        })
    });
}

function sendProductId(productId, requestType) {
    fetch('/cart', {
        method:requestType,
        headers: {
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            id: productId
        })
    });
}

function sendProductIdWithFlag(productId, requestType, incrOrDecr) {
    fetch('/cart', {
        method:requestType,
        headers: {
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            id: productId,
            type: incrOrDecr

        })
    });
}


main();
