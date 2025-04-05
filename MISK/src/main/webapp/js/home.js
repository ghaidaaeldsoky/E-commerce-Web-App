// document.addEventListener("DOMContentLoaded", function () {
//     const products = [
//         { name: "Dior Sauvage", price: 120, brand: "Dior", size: "100ml", gender: "Men", image: "../img/product/dior_sauvage.jpg" },
//         { name: "Chanel No. 5", price: 150, brand: "Chanel", size: "50ml", gender: "Women", image: "../img/product/chanel_no5.jpg" },
//         { name: "Tom Ford Oud Wood", price: 200, brand: "Tom Ford", size: "100ml", gender: "Unisex", image: "../img/product/tom_ford_oud_wood.jpg" },
//         { name: "Versace Eros", price: 100, brand: "Versace", size: "100ml", gender: "Men", image: "../img/product/versace_eros.jpg" },
//         { name: "Gucci Bloom", price: 130, brand: "Gucci", size: "75ml", gender: "Women", image: "../img/product/gucci_bloom.jpg" },
//         { name: "Creed Aventus", price: 250, brand: "Creed", size: "100ml", gender: "Men", image: "../img/product/creed_aventus.jpg" },
//         { name: "YSL Libre", price: 140, brand: "YSL", size: "90ml", gender: "Women", image: "../img/product/ysl_libre.jpg" },
//         { name: "Armani Code", price: 110, brand: "Armani", size: "100ml", gender: "Men", image: "../img/product/armani_code.jpg" },
//         { name: "Lancôme La Vie Est Belle", price: 135, brand: "Lancôme", size: "75ml", gender: "Women", image: "../img/product/lancome_la_vie_est_belle.jpg" },
//         { name: "Dolce & Gabbana Light Blue", price: 120, brand: "D&G", size: "100ml", gender: "Unisex", image: "../img/product/dg_light_blue.jpg" }
//     ];

//     const productContainer = document.getElementById("product-list");
//     const filterGenderRadios = document.querySelectorAll("input[name='gender']");
//     const priceRange = document.getElementById("price-range");
//     const lowerValue = document.getElementById("lower-value");
//     const upperValue = document.getElementById("upper-value");
//     const searchField = document.getElementById("searchField");

//     function displayProducts(filteredProducts) {
//         productContainer.innerHTML = "";
//         filteredProducts.forEach(product => {
//             const productElement = document.createElement("div");
//             productElement.classList.add("col-md-6", "col-lg-4");
//             productElement.innerHTML = `
//                 <div class="card text-center card-product">
//                     <div class="card-product__img">
//                         <img class="card-img" src="${product.image}" alt="${product.name}">
//                         <ul class="card-product__imgOverlay">
//                             <li><button><i class="ti-search"></i></button></li>
//                             <li><button><i class="ti-shopping-cart"></i></button></li>
//                             <li><button><i class="ti-heart"></i></button></li>
//                         </ul>
//                     </div>
//                     <div class="card-body">
//                         <p>${product.brand}</p>
//                         <h4 class="card-product__title"><a href="#">${product.name}</a></h4>
//                         <p class="card-product__price">${product.price}EGP</p>
//                     </div>
//                 </div>
//             `;
//             productContainer.appendChild(productElement);
//         });
//     }

//     function filterProducts() {
//         let selectedGender = document.querySelector("input[name='gender']:checked")?.id || "all";
//         let minPrice = parseInt(lowerValue.textContent);
//         let maxPrice = parseInt(upperValue.textContent);
//         let searchText = searchField.value.trim().toLowerCase();

//         let filteredProducts = products.filter(product =>
//             (selectedGender === "all" || product.gender.toLowerCase() === selectedGender) &&
//             (product.price >= minPrice && product.price <= maxPrice) &&
//             (product.name.toLowerCase().includes(searchText) || product.brand.toLowerCase().includes(searchText)) // البحث بالاسم أو البراند
//         );

//         displayProducts(filteredProducts);
//     }

//     filterGenderRadios.forEach(radio => radio.addEventListener("change", filterProducts));

//     noUiSlider.create(priceRange, {
//         start: [50, 300],
//         connect: true,
//         step: 50,
//         range: {
//             'min': 50,
//             'max': 300
//         }
//     });

//     priceRange.noUiSlider.on("update", function (values) {
//         lowerValue.textContent = Math.round(values[0]);
//         upperValue.textContent = Math.round(values[1]);
//         filterProducts();
//     });

//     searchField.addEventListener("input", filterProducts);

//     displayProducts(products);
// });

// // const productContainer = document.getElementById("productContainer"); 
// // const paginationContainer = document.getElementById("paginationContainer"); 

// // const productsPerPage = 9;
// // let currentPage = 1;
// // let allProducts = [];

// // function displayProducts(products, page) {
// //   productContainer.innerHTML = "";
// //   const start = (page - 1) * productsPerPage;
// //   const end = start + productsPerPage;
// //   const paginatedProducts = products.slice(start, end);

// //   paginatedProducts.forEach((product) => {
// //     const productElement = document.createElement("div");
// //     productElement.classList.add("col-md-6", "col-lg-4");
// //     productElement.innerHTML = `
// //                 <div class="card text-center card-product">
// //                     <div class="card-product__img">
// //                         <img class="card-img" src="${product.image}" alt="${product.name}">
// //                         <ul class="card-product__imgOverlay">
// //                             <li><button><i class="ti-search"></i></button></li>
// //                             <li><button><i class="ti-shopping-cart"></i></button></li>
// //                             <li><button><i class="ti-heart"></i></button></li>
// //                         </ul>
// //                     </div>
// //                     <div class="card-body">
// //                         <p>${product.brand}</p>
// //                         <h4 class="card-product__title"><a href="#">${product.name}</a></h4>
// //                         <p class="card-product__price">${product.price}EGP</p>
// //                     </div>
// //                 </div>
// //             `;
// //     productContainer.appendChild(productElement);
// //   });
// // }

// // function setupPagination(products) {
// //   paginationContainer.innerHTML = "";
// //   const pageCount = Math.ceil(products.length / productsPerPage);
// //   for (let i = 1; i <= pageCount; i++) {
// //     const btn = document.createElement("button");
// //     btn.innerText = i;
// //     btn.classList.add("btn", "btn-sm", "mx-1", "btn-outline-dark");
// //     if (i === currentPage) btn.classList.add("active");

// //     btn.addEventListener("click", () => {
// //       currentPage = i;
// //       displayProducts(products, currentPage);
// //       setupPagination(products);
// //     });

// //     paginationContainer.appendChild(btn);
// //   }
// // }

// // window.addEventListener("DOMContentLoaded", () => {
// //   allProducts = JSON.parse(document.getElementById("productsJson").textContent);
// //   displayProducts(allProducts, currentPage);
// //   setupPagination(allProducts);
// // });

// document.addEventListener('DOMContentLoaded', function() {
//     // تهيئة السلايدر
//     const priceSlider = document.getElementById('price-range');
//     const minPriceInput = document.getElementById('minPrice');
//     const maxPriceInput = document.getElementById('maxPrice');
//     const lowerValue = document.getElementById('lower-value');
//     const upperValue = document.getElementById('upper-value');

//     noUiSlider.create(priceSlider, {
//         start: [0, 300],
//         connect: true,
//         range: { 'min': 0, 'max': 300 },
//         step: 1
//     });

//     // تحديث القيم المخفية والمعروضة
//     priceSlider.noUiSlider.on('update', function(values) {
//         const min = Math.round(values[0]);
//         const max = Math.round(values[1]);
//         lowerValue.textContent = min;
//         upperValue.textContent = max;
//         minPriceInput.value = min;
//         maxPriceInput.value = max;
//     });

//     // إرسال الفورم عند تغيير السعر
//     priceSlider.noUiSlider.on('end', function() {
//         submitFilterForm();
//     });
// });

// // دالة إرسال الفورم عبر AJAX
// function submitFilterForm() {
//     const formData = new URLSearchParams(new FormData(document.getElementById('filterForm')));
    
//     fetch('/home?' + formData, {
//         headers: { 'X-Requested-With': 'XMLHttpRequest' }
//     })
//     .then(response => response.text())
//     .then(html => {
//         const parser = new DOMParser();
//         const doc = parser.parseFromString(html, 'text/html');
        
//         // تحديث الأقسام الديناميكية
//         document.getElementById('product-list').innerHTML = 
//             doc.getElementById('product-list').innerHTML;
//         document.getElementById('pagination').innerHTML = 
//             doc.getElementById('pagination').innerHTML;
//     })
//     .catch(error => console.error('Error:', error));
// }


document.addEventListener('DOMContentLoaded', function() {
    // Initialize price slider
    const priceSlider = document.getElementById('price-range');
    const minPriceInput = document.getElementById('minPrice');
    const maxPriceInput = document.getElementById('maxPrice');
    const lowerValue = document.getElementById('lower-value');
    const upperValue = document.getElementById('upper-value');

    noUiSlider.create(priceSlider, {
        start: [0, 300],
        connect: true,
        range: { 'min': 0, 'max': 300 },
        step: 50
    });

    // Update hidden inputs and display values
    priceSlider.noUiSlider.on('update', function(values) {
        const min = Math.round(values[0]);
        const max = Math.round(values[1]);
        lowerValue.textContent = min;
        upperValue.textContent = max;
        minPriceInput.value = min;
        maxPriceInput.value = max;
    });

    // Handle filter changes
    const handleFilterChange = () => {
        const formData = new URLSearchParams(new FormData(document.getElementById('filterForm')));
        
        fetch('/home?' + formData, {
            headers: { 'X-Requested-With': 'XMLHttpRequest' }
        })
        .then(response => response.text())
        .then(html => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(html, 'text/html');
            
            // Update product list
            document.getElementById('product-list').innerHTML = 
                doc.getElementById('product-list').innerHTML;
            
            // Update pagination
            document.getElementById('pagination').innerHTML = 
                doc.getElementById('pagination').innerHTML;
        })
        .catch(error => console.error('Error:', error));
    };

    // Event listeners
    document.querySelectorAll('.pixel-radio').forEach(radio => {
        radio.addEventListener('change', handleFilterChange);
    });
    
    priceSlider.noUiSlider.on('end', handleFilterChange);
});

