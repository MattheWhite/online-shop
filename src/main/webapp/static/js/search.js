function setProductsVisibility(products, filterExpression) {
    for (const product of products) {
        if (product.dataset.category.toLowerCase() === filterExpression.toLowerCase()) {
            product.style.display = "inline-block";
        } else if (filterExpression === "None") {
            product.style.display = "inline-block";
        } else {
            product.style.display = "none";
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