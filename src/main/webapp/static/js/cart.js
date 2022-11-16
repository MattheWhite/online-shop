function main() {
    let addToCartButtons = document.querySelectorAll(".add-to-cart");
    addToCartButtons.forEach(button => button.addEventListener('click', () => {
        let productId = button.dataset.id;
        sendProductId(productId);
    }))
    let navBar = document.querySelector('#mainNav');
    navBar.classList.add("navbar-shrink");
}

function sendProductId(productId) {
    fetch('/cart', {
        method:"POST",
        headers: {
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            id: productId
        })
    });
}

main();
