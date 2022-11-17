const HTTP_POST = "POST";
const HTTP_DELETE = "DELETE";

function main() {
    let addToCartButtons = document.querySelectorAll(".add-to-cart");
    addToCartButtons.forEach(button => button.addEventListener('click', () => {
        let productId = button.dataset.id;
        sendProductId(productId, HTTP_POST);
    }))
    let navBar = document.querySelector('#mainNav');
    navBar.classList.add("navbar-shrink");

    let deleteButtons = document.querySelectorAll(".trash-icon");
    deleteButtons.forEach(button => button.addEventListener('click', () => {
        let productId = button.dataset.id;
        sendProductId(productId, HTTP_DELETE);
    }))
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

main();
