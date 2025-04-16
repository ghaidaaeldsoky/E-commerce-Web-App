<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page session="false" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="X-UA-Compatible" content="ie=edge" />
      <title>MISK Perfumes - All Perfumes</title>
      <link rel="icon" href="img/Fevicon.png" type="image/png" />
      <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css" />
      <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css" />
      <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css" />
      <link rel="stylesheet" href="vendors/linericon/style.css" />
      <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css" />
      <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css" />
      <link rel="stylesheet" href="vendors/nice-select/nice-select.css" />
      <link rel="stylesheet" href="vendors/nouislider/nouislider.min.css" />

      <link rel="stylesheet" href="css/style.css" />
    </head>

    <body>
      <!--================ Start Header Menu Area =================-->
      <jsp:include page="nav.jsp" />
      <!--================ End Header Menu Area =================-->

      <!-- ================ start banner area ================= -->
      <section class="blog-banner-area" id="category">
        <div class="container h-100">
          <div class="blog-banner">
            <div class="text-center">
              <h1>All Products</h1>
              <nav aria-label="breadcrumb" class="banner-breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item"><a href="#">Home</a></li>
                  <li class="breadcrumb-item active" aria-current="page">All Products</li>
                </ol>
              </nav>
            </div>
          </div>
        </div>
      </section>
      <!-- ================ end banner area ================= -->

      <!-- ================ category section start ================= -->
      <section class="section-margin--small mb-5">
        <div class="container">
          <div class="row">
            <div class="col-xl-3 col-lg-4 col-md-5">
              <!-- Category Section -->
              <div class="sidebar-categories">
                <div class="head">Browse Categories</div>
                <ul class="main-categories">
                  <li class="common-filter">
                    <form id="filterForm" onsubmit="return false;">
                      <ul>
                        <li class="filter-list">
                          <input class="pixel-radio" type="radio" id="all" name="gender" value="all"
                            ${param.gender=='all' || empty param.gender ? 'checked' : '' } />
                          <label for="all">All</label>
                        </li>
                        <li class="filter-list">
                          <input class="pixel-radio" type="radio" id="men" name="gender" value="Men"
                            ${param.gender=='Men' ? 'checked' : '' } />
                          <label for="men">Men</label>
                        </li>
                        <li class="filter-list">
                          <input class="pixel-radio" type="radio" id="women" name="gender" value="Women"
                            ${param.gender=='Women' ? 'checked' : '' } />
                          <label for="women">Women</label>
                        </li>
                        <li class="filter-list">
                          <input class="pixel-radio" type="radio" id="unisex" name="gender" value="Unisex"
                            ${param.gender=='Unisex' ? 'checked' : '' } />
                          <label for="unisex">Unisex</label>
                        </li>
                      </ul>
                      <!-- Filter By Price -->
                      <div class="head">Price</div>
                      <div class="common-filter">
                        <!-- <div class="head">Price</div> -->
                        <div class="price-range-area">
                          <div id="price-range" data-min="${actualMinPrice}" data-max="${actualMaxPrice}"
                            data-selected-min="${not empty selectedMinPrice ? selectedMinPrice : actualMinPrice}"
                            data-selected-max="${not empty selectedMaxPrice ? selectedMaxPrice : actualMaxPrice}">
                          </div>
                          <div class="value-wrapper d-flex">
                            <div class="price">Price:</div>
                            <div id="lower-value"></div>
                            <span>EGP</span>
                            <div class="to">to</div>
                            <div id="upper-value"></div>
                            <span>EGP</span>
                          </div>
                        </div>
                      </div>
                      <input type="submit" style="display: none;" />
                      <input type="hidden" id="minPrice" name="minPrice"
                        value="${not empty param.minPrice ? param.minPrice : 0}">
                      <input type="hidden" id="maxPrice" name="maxPrice"
                        value="${not empty param.maxPrice ? param.maxPrice : 300}">
                    </form>
                  </li>
                </ul>
              </div>
              <div class="sidebar-filter">
                <!-- Filters -->
              </div>
            </div>
            <div class="col-xl-9 col-lg-8 col-md-7">
              <!-- Start Filter Bar -->
              <div class="filter-bar d-flex flex-wrap align-items-center">
                <div>
                  <div class="input-group filter-bar-search" style="min-width: 335px;">
                    <input type="text" placeholder="Search" id="searchField"
                      value="${not empty searchQuery ? searchQuery : ''}" 
                       style="width: 88%;"/>
                    <div class="input-group-append">
                      <button type="button" id="startSearch">
                        <i class="ti-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- End Filter Bar -->
              <!-- Start Best Seller -->
              <section class="lattest-product-area pb-40 category-list">
                <div class="row" id="product-list">
                  <c:choose>
                    <c:when test="${not empty perfumesPage && !perfumesPage.isEmpty()}">
                      <c:forEach var="perfume" items="${perfumesPage}">
                        <div class="col-md-6 col-lg-4">
                          <div class="card text-center card-product">
                            <a href="ProductDetails?id=${perfume.id}&name=${perfume.name}"
                              style="text-decoration: none; color: inherit;">

                              <div class="card-product__img position-relative">

                                <c:if test="${perfume.quantity == 0}">
                                  <span class="badge position-absolute top-0 end-0 m-2" style="font-size: 0.8rem; 
                      background-color: #384AEB;
                      border: 1px solid white; 
                      color: white; 
                      padding: 5px 10px; 
                      font-weight: bold;">
                                    SOLD OUT
                                  </span>
                                </c:if>

                                <img class="card-img" src="${perfume.photo}" alt="${perfume.name}">

                                <ul class="card-product__imgOverlay">
                                  <c:if test="${perfume.quantity > 0}">
                                    <li>
                                      <form action="addSingleToCart" method="get">
                                        <input type="hidden" name="id" value="${perfume.id}">
                                        <input type="hidden" name="name" value="${perfume.name}">
                                        <input type="hidden" name="brand" value="${perfume.brand}">
                                        <input type="hidden" name="price" value="${perfume.price}">
                                        <input type="hidden" name="photo" value="${perfume.photo}">
                                        <button type="submit" style="color: white;"
                                          onclick="return addToCart(${perfume.id});">
                                          <i class="ti-shopping-cart" style="margin-right: 5px;"></i>Add to cart
                                        </button>
                                      </form>
                                    </li>
                                  </c:if>
                                </ul>
                              </div>

                              <div class="card-body">
                                <p>${perfume.brand}</p>
                                <h4 class="card-product__title">${perfume.name}</h4>
                                <p class="card-product__price">${perfume.price} EGP</p>
                              </div>
                            </a>
                          </div>
                        </div>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <div class="col-12 text-center py-5">
                        <div class="no-results-container">
                          <i class="fas fa-search fa-3x text-muted mb-4"></i>
                          <h3 class="mb-3">No Results Found</h3>
                          <p class="text-muted">We couldn't find any items matching your search<br>
                            Try adjusting your filters or search terms</p>
                        </div>
                      </div>
                    </c:otherwise>

                  </c:choose>




                </div>

                <c:set var="startPage" value="${currentPage - 2}" />
                <c:set var="endPage" value="${currentPage + 2}" />

                <c:if test="${startPage < 1}">
                  <c:set var="endPage" value="${endPage + (1 - startPage)}" />
                  <c:set var="startPage" value="1" />
                </c:if>

                <c:if test="${endPage > noOfPages}">
                  <c:set var="startPage" value="${startPage - (endPage - noOfPages)}" />
                  <c:set var="endPage" value="${noOfPages}" />
                </c:if>


                <c:if test="${startPage < 1}">
                  <c:set var="startPage" value="1" />
                </c:if>

                <div id="pagination" class="pagination">
                  <c:if test="${currentPage > 1}">
                    <c:url value="/home" var="prevUrl">
                      <c:param name="page" value="${currentPage - 1}" />
                      <c:if test="${not empty param.gender}">
                        <c:param name="gender" value="${param.gender}" />
                      </c:if>
                      <c:if test="${not empty param.minPrice}">
                        <c:param name="minPrice" value="${param.minPrice}" />
                      </c:if>
                      <c:if test="${not empty param.maxPrice}">
                        <c:param name="maxPrice" value="${param.maxPrice}" />
                      </c:if>
                    </c:url>
                    <a href="${prevUrl}" class="btn btn-sm btn-outline-dark mx-1">Previous</a>
                  </c:if>

                  <c:forEach begin="${startPage}" end="${endPage}" var="i">
                    <c:url value="/home" var="pageUrl">
                      <c:param name="page" value="${i}" />
                      <c:if test="${not empty param.gender}">
                        <c:param name="gender" value="${param.gender}" />
                      </c:if>
                      <c:if test="${not empty param.minPrice}">
                        <c:param name="minPrice" value="${param.minPrice}" />
                      </c:if>
                      <c:if test="${not empty param.maxPrice}">
                        <c:param name="maxPrice" value="${param.maxPrice}" />
                      </c:if>
                    </c:url>
                    <a href="${pageUrl}"
                      class="btn btn-sm mx-1 ${i == currentPage ? 'btn-dark active' : 'btn-outline-dark'}">${i}</a>
                  </c:forEach>

                  <c:if test="${currentPage < noOfPages}">
                    <c:url value="/home" var="nextUrl">
                      <c:param name="page" value="${currentPage + 1}" />
                      <c:if test="${not empty param.gender}">
                        <c:param name="gender" value="${param.gender}" />
                      </c:if>
                      <c:if test="${not empty param.minPrice}">
                        <c:param name="minPrice" value="${param.minPrice}" />
                      </c:if>
                      <c:if test="${not empty param.maxPrice}">
                        <c:param name="maxPrice" value="${param.maxPrice}" />
                      </c:if>
                    </c:url>
                    <a href="${nextUrl}" class="btn btn-sm btn-outline-dark mx-1">Next</a>
                  </c:if>
                </div>

              </section>
              <!-- End Best Seller -->
            </div>
          </div>
        </div>
      </section>

      <div class="toast-container position-fixed bottom-0 end-0 p-3" style="z-index: 9999">
        <div id="loginToast" class="toast align-items-center text-bg-danger border-0" role="alert" aria-live="assertive"
          aria-atomic="true">
          <div class="d-flex">
            <div class="toast-body">
              You must log in to add items to the cart.
            </div>
            <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"
              aria-label="Close"></button>
          </div>
        </div>
      </div>
      <!--================ Start footer Area  =================-->
      <jsp:include page="footer.jsp" />
      <!--================ End footer Area  =================-->

      <!-- Bootstrap 5 CSS -->

      <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
      <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
      <script src="vendors/skrollr.min.js"></script>
      <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
      <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
      <script src="vendors/nouislider/nouislider.min.js"></script>
      <script src="vendors/jquery.ajaxchimp.min.js"></script>
      <script src="vendors/mail-script.js"></script>
      <script src="js/main.js"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>


      <script>
        // document.querySelectorAll('.pixel-radio').forEach(radio => {
        //   radio.addEventListener('change', function () {
        //     document.getElementById('filterForm').submit();
        //   });
        // });


        function showLoginToast(isSuccess) {
          const toastElement = document.getElementById('loginToast');
          const toast = new bootstrap.Toast(toastElement);

          const toastBody = toastElement.querySelector('.toast-body');
          const toastCloseButton = toastElement.querySelector('.btn-close');

          if (isSuccess) {
            toastBody.textContent = "Item successfully added to your cart.";
            toastElement.classList.remove('text-bg-danger');
            toastElement.classList.add('text-bg-success');
          }

          else {
            toastBody.textContent = "You must log in to add items to the cart.";
            toastElement.classList.remove('text-bg-success');
            toastElement.classList.add('text-bg-danger');
          }

          toast.show();
        }


        function addToCart(id) {
          event.preventDefault();
          $.ajax({
            url: "/MISK/CartCounter",
            type: "POST",
            data: { productId: id },
            success: function (response) {

              document.querySelector(".nav-shop__circle").textContent = response;
              showLoginToast(true);

            },
            error: function (xhr, status, error) {
              showLoginToast(false);
              // showLoginToast();
              console.error("Error:", error);
            },
          });


          $.ajax({
            url: "/MISK/addSingleToCart",
            type: "GET",
            data: { productId: id },
            success: function (response) {
              console.log("cart updated successfully");
            },
            error: function (xhr, status, error) {

              console.error("Error:", error);
            },
          });



          return false;
        }

      </script>

      <!-- the price slider script -->
      <!-- <script>
        document.addEventListener('DOMContentLoaded', function () {
          
  });
      </script> -->

      <!-- Search -->
      <script>
        $(document).ready(function () {
          const searchField = $('#searchField');
          let timeoutId;

          $('#filterForm').on('submit', function (e) {
            e.preventDefault();
          });

          searchField.on('input', function () {
            clearTimeout(timeoutId);
            timeoutId = setTimeout(() => {
              performSearch();  // -> filterProducts()
            }, 300); // 300ms delay after typing stops
          });

          document.querySelectorAll('.pixel-radio').forEach(radio => {
            radio.addEventListener('change', function () {
              performSearch();
              // document.getElementById('filterForm').submit(); // -> filterProducts()
            });
          });

          document.querySelectorAll('input[name="gender"]').forEach(radio => {
            radio.addEventListener('change', () => {
              performSearch();
            });
          });

          var priceSlider = document.getElementById('price-range');
          var minPriceInput = document.getElementById('minPrice');
          var maxPriceInput = document.getElementById('maxPrice');
          var lowerValue = document.getElementById('lower-value');
          var upperValue = document.getElementById('upper-value');

          var actualMin = parseInt(priceSlider.dataset.min);
          var actualMax = parseInt(priceSlider.dataset.max);
          var selectedMin = parseInt(priceSlider.dataset.selectedMin);
          var selectedMax = parseInt(priceSlider.dataset.selectedMax);

          if (!priceSlider.noUiSlider) {
            noUiSlider.create(priceSlider, {
              start: [selectedMin, selectedMax],
              connect: true,
              range: {
                'min': actualMin,
                'max': actualMax
              },
              step: 10
            });

            priceSlider.noUiSlider.on('update', function (values, handle) {
              var minVal = Math.round(values[0]);
              var maxVal = Math.round(values[1]);
              lowerValue.textContent = minVal;
              upperValue.textContent = maxVal;
              minPriceInput.value = minVal;
              maxPriceInput.value = maxVal;
            });

            priceSlider.noUiSlider.on('set', function () {
              performSearch();
              // document.getElementById('filterForm').submit(); // filterProducts()
            });
          }

          function performSearch(page = 1) {
            const searchQuery = searchField.val();
            const gender = $('input[name="gender"]:checked').val();
            const minPrice = $('#minPrice').val();
            const maxPrice = $('#maxPrice').val();

            $.ajax({
              url: 'home',
              type: 'GET',
              data: {
                search: searchQuery,
                gender: gender,
                minPrice: minPrice,
                maxPrice: maxPrice,
                page: page // Reset to first page when searching
              },
              success: function (response) {
                const tempDiv = $('<div>').html(response);
                const productList = tempDiv.find('#product-list');
                const pagination = tempDiv.find('#pagination');

                // Only replace if we have content
                $('#product-list').html(productList.html());

                // Hide pagination when no results
                if (productList.find('.no-results-container').length > 0) {
                  $('#pagination').hide();
                } else {
                  $('#pagination').html(pagination.html()).show();
                }
              },
              error: function (xhr, status, error) {
                console.error("Error while filtering:", error);
              }
            });
          }

          $(document).on('click', '#pagination a', function (e) {
            e.preventDefault();
            const page = $(this).text().trim();
            performSearch(page);
          });
        });
      </script>

    </body>

    </html>