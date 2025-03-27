document.addEventListener("DOMContentLoaded", function () {
    const products = [
        { name: "Dior Sauvage", price: 120, brand: "Dior", size: "100ml", gender: "Men", image: "../img/product/dior_sauvage.jpg" },
        { name: "Chanel No. 5", price: 150, brand: "Chanel", size: "50ml", gender: "Women", image: "../img/product/chanel_no5.jpg" },
        { name: "Tom Ford Oud Wood", price: 200, brand: "Tom Ford", size: "100ml", gender: "Unisex", image: "../img/product/tom_ford_oud_wood.jpg" },
        { name: "Versace Eros", price: 100, brand: "Versace", size: "100ml", gender: "Men", image: "../img/product/versace_eros.jpg" },
        { name: "Gucci Bloom", price: 130, brand: "Gucci", size: "75ml", gender: "Women", image: "../img/product/gucci_bloom.jpg" },
        { name: "Creed Aventus", price: 250, brand: "Creed", size: "100ml", gender: "Men", image: "../img/product/creed_aventus.jpg" },
        { name: "YSL Libre", price: 140, brand: "YSL", size: "90ml", gender: "Women", image: "../img/product/ysl_libre.jpg" },
        { name: "Armani Code", price: 110, brand: "Armani", size: "100ml", gender: "Men", image: "../img/product/armani_code.jpg" },
        { name: "Lancôme La Vie Est Belle", price: 135, brand: "Lancôme", size: "75ml", gender: "Women", image: "../img/product/lancome_la_vie_est_belle.jpg" },
        { name: "Dolce & Gabbana Light Blue", price: 120, brand: "D&G", size: "100ml", gender: "Unisex", image: "../img/product/dg_light_blue.jpg" }
    ];
    
    const productContainer = document.getElementById("product-list");
    const filterGenderRadios = document.querySelectorAll("input[name='gender']");
    const priceRange = document.getElementById("price-range");
    const lowerValue = document.getElementById("lower-value");
    const upperValue = document.getElementById("upper-value");
    const searchField = document.getElementById("searchField");

    function displayProducts(filteredProducts) {
        productContainer.innerHTML = "";
        filteredProducts.forEach(product => {
            const productElement = document.createElement("div");
            productElement.classList.add("col-md-6", "col-lg-4");
            productElement.innerHTML = `
                <div class="card text-center card-product">
                    <div class="card-product__img">
                        <img class="card-img" src="${product.image}" alt="${product.name}">
                        <ul class="card-product__imgOverlay">
                            <li><button><i class="ti-search"></i></button></li>
                            <li><button><i class="ti-shopping-cart"></i></button></li>
                            <li><button><i class="ti-heart"></i></button></li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <p>${product.brand}</p>
                        <h4 class="card-product__title"><a href="#">${product.name}</a></h4>
                        <p class="card-product__price">$${product.price}</p>
                    </div>
                </div>
            `;
            productContainer.appendChild(productElement);
        });
    }

    function filterProducts() {
        let selectedGender = document.querySelector("input[name='gender']:checked")?.id || "all";
        let minPrice = parseInt(lowerValue.textContent);
        let maxPrice = parseInt(upperValue.textContent);
        let searchText = searchField.value.trim().toLowerCase(); 

        let filteredProducts = products.filter(product => 
            (selectedGender === "all" || product.gender.toLowerCase() === selectedGender) &&
            (product.price >= minPrice && product.price <= maxPrice) &&
            (product.name.toLowerCase().includes(searchText) || product.brand.toLowerCase().includes(searchText)) // البحث بالاسم أو البراند
        );

        displayProducts(filteredProducts);
    }

    filterGenderRadios.forEach(radio => radio.addEventListener("change", filterProducts));
    
    noUiSlider.create(priceRange, {
        start: [50, 300],
        connect: true,
        step: 50,
        range: {
            'min': 50,
            'max': 300
        }
    });

    priceRange.noUiSlider.on("update", function (values) {
        lowerValue.textContent = Math.round(values[0]);
        upperValue.textContent = Math.round(values[1]);
        filterProducts();
    });

    searchField.addEventListener("input", filterProducts);

    displayProducts(products);
});

