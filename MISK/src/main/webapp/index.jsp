<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Aroma Shop - Category</title>
    <link rel="icon" href="img/Fevicon.png" type="image/png" />
    <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css" />
    <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css" />
    <link rel="stylesheet" href="vendors/linericon/style.css" />
    <link
      rel="stylesheet"
      href="vendors/owl-carousel/owl.theme.default.min.css"
    />
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="vendors/nice-select/nice-select.css" />
    <link rel="stylesheet" href="vendors/nouislider/nouislider.min.css" />

    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <!--================ Start Header Menu Area =================-->
    <header class="header_area">
      <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light">
          <div class="container">
            <a class="navbar-brand logo_h" href="index.html"
              ><img src="img/logo.png" alt=""
            /></a>
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <div
              class="collapse navbar-collapse offset"
              id="navbarSupportedContent"
            >
              <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item active submenu dropdown">
                  <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    role="button"
                    aria-haspopup="true"
                    aria-expanded="false"
                    >Shop</a
                  >
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="category.html">Shop Category</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="single-product.html"
                        >Product Details</a
                      >
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="checkout.html"
                        >Product Checkout</a
                      >
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="confirmation.html"
                        >Confirmation</a
                      >
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="cart.html">Shopping Cart</a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item submenu dropdown">
                  <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    role="button"
                    aria-haspopup="true"
                    aria-expanded="false"
                    >Blog</a
                  >
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="blog.html">Blog</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="single-blog.html"
                        >Blog Details</a
                      >
                    </li>
                  </ul>
                </li>
                <li class="nav-item submenu dropdown">
                  <a
                    href="#"
                    class="nav-link dropdown-toggle"
                    data-toggle="dropdown"
                    role="button"
                    aria-haspopup="true"
                    aria-expanded="false"
                    >Pages</a
                  >
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="login.html">Login</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="register.html">Register</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="tracking-order.html"
                        >Tracking</a
                      >
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="contact.html">Contact</a>
                </li>
              </ul>

              <ul class="nav-shop">
                <li class="nav-item">
                  <button><i class="ti-search"></i></button>
                </li>
                <li class="nav-item">
                  <button>
                    <i class="ti-shopping-cart"></i
                    ><span class="nav-shop__circle">3</span>
                  </button>
                </li>
                <li class="nav-item">
                  <a class="button button-header" href="#">Buy Now</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!--================ End Header Menu Area =================-->

    <!-- ================ start banner area ================= -->
    <!-- ================ end banner area ================= -->

    <!-- ================ category section start ================= -->
    <jsp:include page="toast.jsp" />

    <section class="section-margin--small mb-5">
      <div class="container">
        <div class="row">
          <div class="col-xl-3 col-lg-4 col-md-5">
            <!-- Category Section -->
            <div class="sidebar-categories">
              <div class="head">Browse Categories</div>
              <ul class="main-categories">
                <li class="common-filter">
                  <form action="home" method="GET" id="filterForm">
                    <ul>
                        <li class="filter-list">
                            <input 
                                class="pixel-radio" 
                                type="radio" 
                                id="all" 
                                name="gender" 
                                value="all" 
                                ${param.gender == 'all' || empty param.gender ? 'checked' : ''}
                                onchange="document.getElementById('filterForm').submit()"
                            />
                            <label for="all">All</label>
                        </li>
                        <li class="filter-list">
                            <input 
                                class="pixel-radio" 
                                type="radio" 
                                id="men" 
                                name="gender" 
                                value="Men" 
                                ${param.gender == 'Men' ? 'checked' : ''}
                                onchange="document.getElementById('filterForm').submit()"
                            />
                            <label for="men">Men</label>
                        </li>
                        <li class="filter-list">
                            <input 
                                class="pixel-radio" 
                                type="radio" 
                                id="women" 
                                name="gender" 
                                value="Women" 
                                ${param.gender == 'Women' ? 'checked' : ''}
                                onchange="document.getElementById('filterForm').submit()"
                            />
                            <label for="women">Women</label>
                        </li>
                        <li class="filter-list">
                            <input 
                                class="pixel-radio" 
                                type="radio" 
                                id="unisex" 
                                name="gender" 
                                value="Unisex" 
                                ${param.gender == 'Unisex' ? 'checked' : ''}
                                onchange="document.getElementById('filterForm').submit()"
                            />
                            <label for="unisex">Unisex</label>
                        </li>
                    </ul>
                    <!-- Filter By Price -->
                    <div class="head">Price</div>
              <div class="common-filter">
                <!-- <div class="head">Price</div> -->
                <div class="price-range-area">
                  <div id="price-range"></div>
                  <div class="value-wrapper d-flex">
                    <div class="price">Price:</div>
                    <span>$</span>
                    <div id="lower-value"></div>
                    <div class="to">to</div>
                    <span>$</span>
                    <div id="upper-value"></div>
                  </div>
                </div>
              </div>
                    <input type="submit" style="display: none;" />
                    <input type="hidden" id="minPrice" name="minPrice" value="${not empty param.minPrice ? param.minPrice : 0}">
                    <input type="hidden" id="maxPrice" name="maxPrice" value="${not empty param.maxPrice ? param.maxPrice : 300}">
                </form>
                </li>
              </ul>
            </div>
            <div class="sidebar-filter">
              <!-- Filters -->
              

              <!-- Filter By Price
              <div class="common-filter">
                <div class="head">Price</div>
                <div class="price-range-area">
                  <div id="price-range"></div>
                  <div class="value-wrapper d-flex">
                    <div class="price">Price:</div>
                    <span>$</span>
                    <div id="lower-value"></div>
                    <div class="to">to</div>
                    <span>$</span>
                    <div id="upper-value"></div>
                  </div>
                </div>
              </div> -->
            </div>
          </div>
          <div class="col-xl-9 col-lg-8 col-md-7">
            <!-- Start Filter Bar -->
            <div class="filter-bar d-flex flex-wrap align-items-center">
              <div>
                <div class="input-group filter-bar-search">
                  <input type="text" placeholder="Search" id="searchField" />
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
                <!-- <c:forEach var="perfume" items="${perfumesPage}">
        <div class="col-md-6 col-lg-4">
            <div class="card text-center card-product">
                <div class="card-product__img">
                    <img class="card-img" src="${perfume.photo}" alt="${perfume.name}">
                    <ul class="card-product__imgOverlay">
                        <li><button><i class="ti-search"></i></button></li>
                        <li><button><i class="ti-shopping-cart"></i></button></li>
                        <li><button><i class="ti-heart"></i></button></li>
                    </ul>
                </div>
                <div class="card-body">
                    <p>${perfume.brand}</p>
                    <h4 class="card-product__title"><a href="#">${perfume.name}</a></h4>
                    <p class="card-product__price">${perfume.price} EGP</p>
                </div>
            </div>
        </div>
    </c:forEach> -->

    <c:forEach var="perfume" items="${perfumesPage}">
    <div class="col-md-6 col-lg-4">
        <div class="card text-center card-product">
            <a href="ProductDetails?id=${perfume.id}&name=${perfume.name}" style="text-decoration: none; color: inherit;">
                
                <div class="card-product__img position-relative">
                    
                    <c:if test="${perfume.quantity == 0}">
                      <span class="badge position-absolute top-0 end-0 m-2" style="font-size: 0.8rem; 
                      background-color: #384AEB;
                      border: 1px solid white; 
                      color: white; 
                      padding: 5px 10px; 
                      font-weight: bold;">
                      SOLD OUT
                  </span>                    </c:if>

                    <img class="card-img" src="${perfume.photo}" alt="${perfume.name}">

                    <ul class="card-product__imgOverlay">
                        <c:if test="${perfume.quantity > 0}">
                            <li>
                                <form action="testtoast" method="post">
                                    <input type="hidden" name="id" value="${perfume.id}">
                                    <input type="hidden" name="name" value="${perfume.name}">
                                    <input type="hidden" name="brand" value="${perfume.brand}">
                                    <input type="hidden" name="price" value="${perfume.price}">
                                    <input type="hidden" name="photo" value="${perfume.photo}">
                                    <button type="submit" style="color: white;">
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


              </div>
              
              <div id="pagination" class="pagination">
                <c:forEach begin="1" end="${noOfPages}" var="i">
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
                    
                    <a href="${pageUrl}" class="btn btn-sm mx-1 ${i == currentPage ? 'btn-dark active' : 'btn-outline-dark'}">
                        ${i}
                    </a>
                </c:forEach>
            </div>
            </section>
            <!-- End Best Seller -->
          </div>
        </div>
      </div>
    </section>
    <!-- ================ category section end ================= -->

    <!-- ================ top product area start ================= -->

    <!-- ================ top product area end ================= -->

    <!-- ================ Subscribe section start ================= -->

    <!-- ================ Subscribe section end ================= -->

    <!--================ Start footer Area  =================-->
    <footer>
      <div class="footer-area">
        <div class="container">
          <div class="row section_gap">
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="single-footer-widget tp_widgets">
                <h4 class="footer_title large_title">Our Mission</h4>
                <p>
                  So seed seed green that winged cattle in. Gathering thing made
                  fly you're no divided deep moved us lan Gathering thing us
                  land years living.
                </p>
                <p>
                  So seed seed green that winged cattle in. Gathering thing made
                  fly you're no divided deep moved
                </p>
              </div>
            </div>
            <div class="offset-lg-1 col-lg-2 col-md-6 col-sm-6">
              <div class="single-footer-widget tp_widgets">
                <h4 class="footer_title">Quick Links</h4>
                <ul class="list">
                  <li><a href="#">Home</a></li>
                  <li><a href="#">Shop</a></li>
                  <li><a href="#">Blog</a></li>
                  <li><a href="#">Product</a></li>
                  <li><a href="#">Brand</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
              </div>
            </div>
            <div class="col-lg-2 col-md-6 col-sm-6">
              <div class="single-footer-widget instafeed">
                <h4 class="footer_title">Gallery</h4>
                <ul class="list instafeed d-flex flex-wrap">
                  <li><img src="img/gallery/r1.jpg" alt="" /></li>
                  <li><img src="img/gallery/r2.jpg" alt="" /></li>
                  <li><img src="img/gallery/r3.jpg" alt="" /></li>
                  <li><img src="img/gallery/r5.jpg" alt="" /></li>
                  <li><img src="img/gallery/r7.jpg" alt="" /></li>
                  <li><img src="img/gallery/r8.jpg" alt="" /></li>
                </ul>
              </div>
            </div>
            <div class="offset-lg-1 col-lg-3 col-md-6 col-sm-6">
              <div class="single-footer-widget tp_widgets">
                <h4 class="footer_title">Contact Us</h4>
                <div class="ml-40">
                  <p class="sm-head">
                    <span class="fa fa-location-arrow"></span>
                    Head Office
                  </p>
                  <p>123, Main Street, Your City</p>

                  <p class="sm-head">
                    <span class="fa fa-phone"></span>
                    Phone Number
                  </p>
                  <p>
                    +123 456 7890 <br />
                    +123 456 7890
                  </p>

                  <p class="sm-head">
                    <span class="fa fa-envelope"></span>
                    Email
                  </p>
                  <p>
                    free@infoexample.com <br />
                    www.infoexample.com
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="footer-bottom">
        <div class="container">
          <div class="row d-flex">
            <p class="col-lg-12 footer-text text-center">
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              Copyright &copy;
              <script>
                document.write(new Date().getFullYear());
              </script>
              All rights reserved | This template is made with
              <i class="fa fa-heart" aria-hidden="true"></i> by
              <a href="https://colorlib.com" target="_blank">Colorlib</a>
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
          </div>
        </div>
      </div>
    </footer>
    <!--================ End footer Area  =================-->

    <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="vendors/skrollr.min.js"></script>
    <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
    <script src="vendors/nouislider/nouislider.min.js"></script>
    <script src="vendors/jquery.ajaxchimp.min.js"></script>
    <script src="vendors/mail-script.js"></script>
    <script src="js/main.js"></script>

    <script>
      document.querySelectorAll('.pixel-radio').forEach(radio => {
          radio.addEventListener('change', function() {
              document.getElementById('filterForm').submit();
          });
      });
      
  </script>
  
  <!-- <script>
    document.addEventListener('DOMContentLoaded', function() {
      var priceSlider = document.getElementById('price-range');
        var minPriceInput = document.getElementById('minPrice');
        var maxPriceInput = document.getElementById('maxPrice');
        var lowerValue = document.getElementById('lower-value');
        var upperValue = document.getElementById('upper-value');

        var minPrice = 0;
        var maxPrice = 300;

        noUiSlider.create(priceSlider, {
            start: [ minPrice,  maxPrice],
            connect: true,
            range: {
                'min': minPrice,
                'max': maxPrice
            },
            step: 1
        });

        priceSlider.noUiSlider.on('update', function(values, handle) {
            var minVal = Math.round(values[0]);
            var maxVal = Math.round(values[1]);
            lowerValue.textContent = minVal;
            upperValue.textContent = maxVal;
            minPriceInput.value = minVal;
            maxPriceInput.value = maxVal;
            
        });

        priceSlider.noUiSlider.on('set', function() {
            document.getElementById('filterForm').submit();
        });
    });
</script> -->

    <!-- <script id="productsJson" type="application/json">
      ${allPerfumesJson}
    </script> -->

    <!-- <script src="./js/home.js"></script> -->
  </body>
</html>
