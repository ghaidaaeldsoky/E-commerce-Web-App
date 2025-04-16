<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>MISK Perfumes - Home</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
  <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="vendors/nice-select/nice-select.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
  <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">

  <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <!--================ Start Header Menu Area =================-->
	<jsp:include page="nav.jsp" />
	<!--================ End Header Menu Area =================-->

  <main class="site-main">
    
    <!--================ Hero banner start =================-->
    <section class="hero-banner">
      <div class="container">
        <div class="row no-gutters align-items-center pt-60px">
          <div class="col-5 d-none d-sm-block">
            <div class="hero-banner__img">
              <img class="img-fluid" src="img/home/perfume-banner.jpg" alt="">
            </div>
          </div>
          <div class="col-sm-7 col-lg-6 offset-lg-1 pl-4 pl-md-5 pl-lg-0">
            <div class="hero-banner__content">
              <h4>MISK for Perfumes</h4>
              <h1> You won't find better than this!</h1>
              <p>Capturing the beauty of nature and luxury in every bottle, our scents are crafted to provide a lasting, unforgettable experience!</p>
              <a class="button button-hero" href="home">Browse Now!</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--================ Hero banner start =================-->

    <!--================ Hero Carousel start =================-->
    <!-- <section class="section-margin mt-0">
      <div class="owl-carousel owl-theme hero-carousel">
        <div class="hero-carousel__slide">
          <img src="img/home/hero-slide1.png" alt="" class="img-fluid">
          <a href="#" class="hero-carousel__slideOverlay">
            <h3>Wireless Headphone</h3>
            <p>Accessories Item</p>
          </a>
        </div>
        <div class="hero-carousel__slide">
          <img src="img/home/hero-slide2.png" alt="" class="img-fluid">
          <a href="#" class="hero-carousel__slideOverlay">
            <h3>Wireless Headphone</h3>
            <p>Accessories Item</p>
          </a>
        </div>
        <div class="hero-carousel__slide">
          <img src="img/home/hero-slide3.png" alt="" class="img-fluid">
          <a href="#" class="hero-carousel__slideOverlay">
            <h3>Wireless Headphone</h3>
            <p>Accessories Item</p>
          </a>
        </div>
      </div>
    </section> -->
    <!--================ Hero Carousel end =================-->

    <!-- ================ trending product section start ================= -->  
    <section class="section-margin calc-60px">
      <div class="container">
        <div class="section-intro pb-60px">
          <p>Popular Item in the market</p>
          <h2>Trending <span class="section-intro__style">Product</span></h2>
        </div>
        <div class="row">
          <c:forEach var="perfume" items="${perfumesPage}">
            <div class="col-md-6 col-lg-3 col-xl-4">
              <div class="card text-center card-product" >
                <div class="card-product__img position-relative" style="width: 100%;">
                  <img class="card-img" src="${perfume.photo}" alt="${perfume.name}" style="width: 76%;">
                  <ul class="card-product__imgOverlay">
                    <li><a href="ProductDetails?id=${perfume.id}&name=${perfume.name}"></a></li>
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
                  <c:if test="${perfume.quantity == 0}">
                    <span class="badge position-absolute top-0 end-0 m-2" style="font-size: 0.8rem; background-color: #384AEB; border: 1px solid white; color: white; padding: 5px 10px; font-weight: bold;">
                      SOLD OUT
                    </span>
                  </c:if>
                </div>
                <div class="card-body">
                  <p>${perfume.brand}</p>
                  <h4 class="card-product__title">
                    <a href="ProductDetails?id=${perfume.id}&name=${perfume.name}">${perfume.name}</a>
                  </h4>
                  <p class="card-product__price">${perfume.price} EGP</p>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
        <div class="button_container mt-4 d-flex align-items-center justify-content-center">
          <form action="home" method="get">
            <button
            type="submit"
            class="button btn-outline-primary btn-lg m-3"
          >Discover more</button>
            <!-- <button type="submit" class="btn btn-primary">Back to Home</button> -->
          </form>
        </div>
      </div>
    </section>
    
    <!-- ================ trending product section end ================= -->  


    <!-- ================ offer section start ================= --> 
    <section class="offer" id="parallax-1" data-anchor-target="#parallax-1" data-300-top="background-position: 20px 30px" data-top-bottom="background-position: 0 20px">
      <div class="container">
        <div class="row">
          <div class="col-xl-5">
            <div class="offer__content text-center">
              <h3>Up To 50% Off</h3>
              <h4>Winter Sale</h4>
              <p>Him she'd let them sixth saw light</p>
              <a class="button button--active mt-3 mt-xl-4" href="home">Shop Now</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ================ offer section end ================= -->  

    <!-- ================ Subscribe section start ================= --> 
    <section class="subscribe-position">
      <div class="container">
        <div class="subscribe text-center">
          <h3 class="subscribe__title">Get Update From Anywhere</h3>
          <p>Bearing Void gathering light light his eavening unto dont afraid</p>
          <div id="mc_embed_signup">
            <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe-form form-inline mt-5 pt-1">
              <div class="form-group ml-sm-auto">
                <input class="form-control mb-1" type="email" name="EMAIL" placeholder="Enter your email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '" >
                <div class="info"></div>
              </div>
              <button class="button button-subscribe mr-auto mb-1" type="submit">Subscribe Now</button>
              <div style="position: absolute; left: -5000px;">
                <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
              </div>

            </form>
          </div>
          
        </div>
      </div>
    </section>
    <!-- ================ Subscribe section end ================= --> 

    

  </main>

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



  <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
  <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
  <script src="vendors/skrollr.min.js"></script>
  <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
  <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
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
</body>
</html>