function setProductsVisibility(products, filterExpression) {
    for (const product of products) {
        if (product.dataset.category.toLowerCase() === filterExpression.toLowerCase()) {
            product.classList.remove("not-visible");
            product.classList.remove("visible");
            product.classList.add("visible");
        } else if (filterExpression === "None") {
            product.classList.remove("not-visible");
            product.classList.remove("visible");
            product.classList.add("visible");
        } else {
            product.classList.remove("not-visible");
            product.classList.remove("visible");
            product.classList.add("not-visible");
        }
    }
}

function filterButtonManager(filterAlcoholic, filterExpression, products) {
    filterAlcoholic.addEventListener('change', function () {
        for (const filterAlcoholicElement of filterAlcoholic) {
            if (filterAlcoholicElement.selected) {
                filterExpression = filterAlcoholicElement.innerText;
            }
        }
        setProductsVisibility(products, filterExpression);
    })
}

function filterDrinks() {
    const products = document.querySelectorAll(".col");
    const filterAlcoholic = document.querySelector("#filter-alcoholic");
    let filterExpression = "";

    filterButtonManager(filterAlcoholic, filterExpression, products);
}

filterDrinks();