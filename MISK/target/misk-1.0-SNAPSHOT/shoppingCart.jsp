<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%--<%@ page session="false" %>--%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Aroma Shop - Cart</title>
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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script>

      function submitForm(servlet) {
      event.preventDefault();
        updateCart();
        if (servlet === "checkoutServlet") {
          document.getElementById("cartForm").method = "post";
          document.getElementById("cartForm").action = servlet;
        }
        if (servlet === "home") {
          document.getElementById("cartForm").method = "get";
          document.getElementById("cartForm").action = servlet;
        }
         document.getElementById("cartForm").submit();
      }


        // Function to update the cart sending the itemslist to the servlet to be updated in the DB
      function updateCart() {
        console.log("Checkout button clicked!");

        var cart_items = [];
        document.querySelectorAll(".product-row").forEach((row) => {

          // Extract product details from each row
          const productId = row.querySelector("#hidden")?.value; // Get product ID
          const name = row.querySelector(".media-body p")?.innerText.trim(); // Get product name
          const price = row.querySelector(".price")?.innerText.trim(); // Get product price
          const quantity = row.querySelector(".qty")?.value; // Get product quantity
          const photopath = row.querySelector("img")?.src; // Get product image URL

          // Create a product object
          const item = {
            id: productId,
            name: name,
            price: price,
            quantity: quantity,
            photopath: photopath,
          };

          // Add the product object to the array
          cart_items.push(item);
        });

        $.ajax({
          url: "/MISK/AddProductsToCart",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify(cart_items),
          success: function (response) {
            console.log("cart updated successfully");
          },
          error: function (xhr, status, error) {
            console.error("Error:", error);
          },
        });
      }

      document.addEventListener("DOMContentLoaded", function () {
        function updateOrderTotal() {
          let totalOrderPrice = 0;
          const productRows = document.querySelectorAll(".product-row");
          const checkoutButton = document.querySelector(".xyz");

          if (productRows.length === 0) {
            checkoutButton.style.display = "none";
            document.getElementById("orderprice").innerText = "0.00 EGP";
            return;
          }

          document.querySelectorAll(".total-price").forEach((element) => {
            const price = parseFloat(
              element.innerText.replace("EGP", "").trim()
            );
            if (!isNaN(price)) {
              totalOrderPrice += price;
            }
          });

          document.getElementById("orderprice").innerText =
            totalOrderPrice.toFixed(2) + " EGP";

          if (totalOrderPrice === 0) {
            checkoutButton.style.display = "none";
          } else {
            checkoutButton.style.display = "block";
          }
        }

        document.querySelectorAll(".product-row").forEach((row) => {
          const quantityInput = row.querySelector(".qty");
          const totalPriceElement = row.querySelector(".total-price");
          const priceElement = row.querySelector(".price");
          const increaseButton = row.querySelector(".increase");
          const decreaseButton = row.querySelector(".reduced");
          const removeButton = row.querySelector(".removeitem");
          const maxQuantity = parseInt(quantityInput.dataset.max);

          if (!quantityInput || !totalPriceElement || !priceElement) return;

          // Get unit price
          const unitPrice =
            parseFloat(priceElement.innerText.replace("EGP", "").trim()) || 0;

          function updateTotal() {
            let quantity = parseInt(quantityInput.value) || 1;
            if (quantity < 1) {
              quantity = 1;
              quantityInput.value = 1;
            }
            const total = (quantity * unitPrice).toFixed(2) + " EGP";
            totalPriceElement.innerText = total; // Ensure total price is updated

            updateOrderTotal();
          }

          // Increase quantity
          increaseButton.addEventListener("click", function () {
            if (quantityInput.value < maxQuantity) {
              quantityInput.value = parseInt(quantityInput.value) + 1;
              updateTotal();
            }
          });

          // Decrease quantity
          decreaseButton.addEventListener("click", function () {
            if (quantityInput.value > 1) {
              quantityInput.value = parseInt(quantityInput.value) - 1;
              updateTotal();
            }
          });

          function updateOrderTotal() {
            let totalOrderPrice = 0;
            const productRows = document.querySelectorAll(".product-row");
            const checkoutButton = document.querySelector(".xyz");

            if (productRows.length === 0) {
              checkoutButton.style.display = "none";
              document.getElementById("orderprice").innerText = "0.00 EGP";
              return;
            }

            document.querySelectorAll(".total-price").forEach((element) => {
              const price = parseFloat(
                element.innerText.replace("EGP", "").trim()
              );
              if (!isNaN(price)) {
                totalOrderPrice += price;
              }
            });

            document.getElementById("orderprice").innerText =
              totalOrderPrice.toFixed(2) + " EGP";

            if (totalOrderPrice === 0) {
              checkoutButton.style.display = "none";
            } else {
              checkoutButton.style.display = "block";
            }
          }

          // Update total on manual input change
          quantityInput.addEventListener("input", updateTotal);

          // Enable remove item
          removeButton.addEventListener("click", function (event) {
            event.preventDefault();
            let proID=row.querySelector("#hidden")?.value
            row.remove();
//*************************************************cart counter related*************************************************
//             $.ajax({
//               url: "/myApp/CartCounter",
//               type: "GET",
//               data: { productId: proID },
//               success: function (response) {
//                 console.log("cart updated successfully");
//                 document.querySelector(".nav-shop__circle").textContent = response;
//
//               },
//               error: function (xhr, status, error) {
//                 console.error("Error:", error);
//               },
//             });



            updateOrderTotal();
          });

          // Initialize total price on page load
          updateTotal();
        });

        // Ensure order total is calculated initially
        updateOrderTotal();
      });
    </script>
  </head>
  <body>
    <!--================ Start Header Menu Area =================-->
    <header class="header_area">
      <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light">
          <div class="container">
            <a class="navbar-brand logo_h" href="index.jsp"
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
                  <a class="nav-link" href="index.jsp">Home</a>
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
                      <a class="nav-link" href="register.html">Register</a>
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

    <!--================Cart Area =================-->
    <section class="cart_area">
      <div class="container">
        <div class="cart_inner">
          <div class="table-responsive">
            <table class="table" style="min-height: 100px">
              <thead>
                <tr>
                  <th scope="col" style="font-size: 20px">Product</th>
                  <th scope="col" style="font-size: 20px">Price</th>
                  <th scope="col" style="font-size: 20px">Quantity</th>
                  <th scope="col" style="font-size: 20px">Total</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="product" items="${prol}">
                  <tr class="product-row">
                    <td>
                      <div class="media">
                        <div class="d-flex">
                          <img src="${product.photopath}" alt="" />
                        </div>
                        <div class="media-body">
                          <p>${product.name}</p>
                          <a href="#" style="font-size: 12px" class="removeitem"
                            >remove item</a
                          >
                        </div>
                      </div>
                    </td>
                    <td>
                      <h5 class="price">${product.price}</h5>
                    </td>
                    <td>
                      <div class="product_count">
                        <input
                          type="hidden"
                          id="hidden"
                          value="${product.id}"
                        />
                        <input
                          type="text"
                          name="qty"
                          maxlength="12"
                          value="${product.quantity}"
                          title="Quantity:"
                          class="input-text qty"
                          data-max="${product.max}"
                          readonly
                        />

                        <button class="increase items-count" type="button">
                          <i class="lnr lnr-chevron-up"></i>
                        </button>
                        <button class="reduced items-count" type="button">
                          <i class="lnr lnr-chevron-down"></i>
                        </button>
                      </div>
                    </td>
                    <td>
                      <h5 class="total-price"></h5>
                    </td>
                  </tr>
                </c:forEach>

                <tr>
                  <td></td>
                  <td></td>
                  <td>
                    <h5 style="font-size: 21px">Subtotal</h5>
                  </td>
                  <td>
                    <h5 style="font-size: 20px" id="orderprice"></h5>
                  </td>
                </tr>

                <tr class="out_button_area">
                  <td class=""></td>
                  <td></td>
                  <td>
<div class="checkout_btn_inner d-flex align-items-center" >
                      <form id="cartForm">
                        <button
                          type="submit"
                          class="primary-btn ml-2"
                          onclick="submitForm('home')"
                          style="margin:4px"
                        >
                          Continue Shopping
                        </button>

                        <button
                          type="submit"
                          class="primary-btn ml-2 xyz"
                          id="proceedtocheckout"
                          onclick="submitForm('checkoutServlet')"
                          style="margin:4px"
                        >
                          Proceed to Checkout
                        </button>
                      </form>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
    <!--================End Cart Area =================-->

    <!--================ Start footer Area  =================-->
    <footer>
      <div class="footer-area footer-only">
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
            <div class="offset-lg-1 col-lg-2 col-md-6 col-sm-6"></div>
            <div class="col-lg-2 col-md-6 col-sm-6"></div>
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
    <script src="vendors/jquery.ajaxchimp.min.js"></script>
    <script src="vendors/mail-script.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
