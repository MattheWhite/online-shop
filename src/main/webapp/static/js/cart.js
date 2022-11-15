function main() {
    let addToCartButtons = document.querySelectorAll(".add-to-cart");
    addToCartButtons.forEach(button => button.addEventListener('click', () => {
        let productId = button.dataset.id;
        sendProductId(productId);
    }))
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
