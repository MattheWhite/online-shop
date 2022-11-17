function getFilteredItems(items, filterValue) {
    if (filterValue.length === 0) {
        return items
    } else {
        return items.filter(productNode => (productNode.dataset.productName).toLowerCase().includes(filterValue.toLowerCase()));
    }
}

function getNonFilteredItems(items, filterValue) {
    if (filterValue.length === 0) {
        return items
    } else {
        return items.filter(productNode => !(productNode.dataset.productName).toLowerCase().includes(filterValue.toLowerCase()));
    }
}

function setNodesVisibility(nonFilteredNodes, filteredNodes) {
    for (const filteredNode of nonFilteredNodes) {
        filteredNode.classList.remove("not-visible");
        filteredNode.classList.remove("visible");
        filteredNode.classList.add("not-visible");
    }
    for (const filteredNode of filteredNodes) {
        filteredNode.classList.remove("not-visible");
        filteredNode.classList.remove("visible");
        filteredNode.classList.add("visible");
    }
}

function filterInputHandler(e) {
    const filterAlcoholic = document.querySelector("#filter-alcoholic")
    let filterExpression = ""
    for (const filterAlcoholicElement of filterAlcoholic) {
        if (filterAlcoholicElement.selected) {
            filterExpression = filterAlcoholicElement.innerText;
        }
    }
    console.log(filterExpression)
    const products = document.querySelectorAll(".col");
    const neededProds = Array.from(products).filter(product =>
        product.dataset.category.toLowerCase() === filterExpression.toLowerCase())
    let product_filter = e.target.value
    const nonFilteredNodes = getNonFilteredItems(neededProds, product_filter)
    const filteredNodes = getFilteredItems(neededProds, product_filter)

    setNodesVisibility(nonFilteredNodes, filteredNodes);
}

function main() {
    const searchBar = document.querySelector("#searchExp");
    searchBar.addEventListener("input", filterInputHandler)
}

main()