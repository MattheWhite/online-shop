function setProducts(products, filterExpression) {
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

function filterButtonManager(filterButton, filterAlcoholic, filterExpression, products) {
    filterButton.addEventListener('click', function () {
        for (const filterAlcoholicElement of filterAlcoholic) {
            if (filterAlcoholicElement.selected) {
                filterExpression = filterAlcoholicElement.innerText;
            }
        }
        setProducts(products, filterExpression);
    })
}

function filterDrinks() {
    const products = document.querySelectorAll(".col");
    const filterButton = document.querySelector("#filter-button");
    const filterAlcoholic = document.querySelector("#filter-alcoholic");
    let filterExpression = "";

    filterButtonManager(filterButton, filterAlcoholic, filterExpression, products);
}

filterDrinks();