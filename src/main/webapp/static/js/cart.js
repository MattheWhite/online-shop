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

    let cartItems = document.querySelectorAll(".cart-item");
    cartItems.forEach(item => {
        displayPrice(item);

        let productId = item.dataset.id;
        let trashIcon = item.querySelector(".trash-icon");
        trashIcon.addEventListener('click', () => {
            sendProductId(productId, HTTP_DELETE);
            item.remove();
        });
        let incrementButton = item.querySelector(".prod-increment");
        incrementButton.addEventListener("click", () => {
            sendProductIdWithFlag(productId, HTTP_PUT, INCREMENT_TYPE);
            displayPrice(item);
        })
        let decrementButton = item.querySelector(".prod-decrement");
        decrementButton.addEventListener("click", () => {
            sendProductIdWithFlag(productId, HTTP_PUT, DECREMENT_TYPE);
            displayPrice(item);
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

function displayPrice(product) {
    let productQuantity = product.querySelector(".quantity");
    let productPrice = product.querySelector(".product-price");
    let price = productPrice.dataset.price;
    productPrice.innerHTML = `${parseInt(price) * +productQuantity.getAttribute("value")}.00 GBP`;
}

main();
