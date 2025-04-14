<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>MISK Perfumes - Checkout</title>
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
    <style>
      .toast {
        visibility: hidden;
        min-width: 250px;
        background-color: #333;
        color: #fff;
        text-align: center;
        border-radius: 12px;
        padding: 16px;
        position: fixed;
        z-index: 9999;
        left: 50%;
        bottom: 30px;
        transform: translateX(-50%);
        font-size: 16px;
        opacity: 0;
        transition: opacity 0.5s ease, bottom 0.5s ease;
      }

      .toast.show {
        visibility: visible;
        opacity: 1;
        bottom: 50px;
      }

    </style>
    <script>
      function showToast(message) {
        const toast = document.getElementById("toast");
        toast.textContent = message;
        toast.className = "toast show";
        setTimeout(() => {
          toast.className = "toast";
        }, 3000);
      }

      function totalMoney() {
        let items = document.querySelectorAll(".t-pro");
        items.forEach(function (row) {
          let price = parseFloat(row.getAttribute("data-price"));
          let quantity = parseInt(row.getAttribute("data-quantity"));
          let total = price * quantity;
          row.querySelector(".item-price").textContent =
            total.toFixed(2) + " EGP";
        });
      }

      function setAddressValue() {
        const selected = document.querySelector(
                'input[name="shipping-address"]:checked'
        );
        if (selected) {
          document.getElementById("addID").value = selected.value;
          console.log(
                  "addID set to: " + document.getElementById("addID").value
          );
        }
      }


      function submitForm(servlet) {
        if (servlet === "ValidateOrder") {
          let terms = document.getElementById("accept-terms").checked;
          let selectedAddress = document.querySelector(
            'input[name="shipping-address"]:checked'
          );

          if (!selectedAddress) {
            alert("Please select a shipping address!");
            return;
          } else if (!terms) {
            alert("You must agree to the terms first!");
            return;
          } else {

            // // Get dynamic values (replace with actual logic)
            // var selectedAddressval = document.querySelector(
            //   'input[name="shipping-address"]:checked'
            // ).value;
            //
            // console.log("Selected Address: ", selectedAddressval);
            // var totalordrmoney =
            //   document.getElementById("overallPriceSpan").textContent;
            //
            // // Update hidden input fields before submission
            // document.getElementById("addID").value = selectedAddressval;
            // console.log(document.getElementById("addID").value);
            // document.getElementById("totalvalue").value = totalordrmoney;
              document.getElementById("orderForm").action =servlet;
                document.getElementById("orderForm").method = "post";
                document.getElementById("orderForm").submit();


          }
        } else {
          document.getElementById("orderForm").method = "get";
          // Set form action and submit
          document.getElementById("orderForm").action = servlet;
            document.getElementById("orderForm").submit();
        }


      }

      document.addEventListener("DOMContentLoaded", function () {
        totalMoney();

        calculateTotal();
      });

      function calculateTotal() {
        let itemPrices = document.querySelectorAll(".item-price");
        let subtotal = 0;

        // Calculate subtotal by iterating over item prices
        itemPrices.forEach((item) => {
          let priceText = item.innerText.replace(" EGP", "").trim();
          let price = parseFloat(priceText);
          subtotal += price;
        });

        document.querySelector(".subtotal-price").innerText =
          subtotal.toFixed(2) + " EGP";
        let shippingText = document
          .querySelector(".shipping-price")
          .innerText.replace("shipping fees: ", "")
          .replace(" EGP", "")
          .trim();
        let shipping = parseFloat(shippingText) || 0;
        let total = subtotal + shipping;
        document.querySelector(".overall-price").innerText =
          total.toFixed(2) + " EGP";
      }
    </script>
  </head>

  <body>
    <!--================ Start Header Menu Area =================-->
    <jsp:include page="nav.jsp" />
    <!--================ End Header Menu Area =================-->

    <!-- ================ start banner area ================= -->

    <!-- ================ end banner area ================= -->

    <!--================Checkout Area =================-->
    <section class="checkout_area section-margin--small">
      <div
        class="order-address"
        style="
          font-size: 16px;
          margin: 100px;
          padding: 20px;
          background-color: #f8f9fa;
          border-radius: 8px;
        "
      >
        <h3 style="font-size: 30px; margin-bottom: 15px">
          Select Shipping Address
        </h3>


        <c:forEach var="address" items="${sessionScope.adr}">
          <label style="display: block; margin-bottom: 8px; font-size: 18px">
            <input type="radio"  name="shipping-address" value="${address.addressId}"  onchange="setAddressValue()"/>
            ${address.state} - ${address.city} - ${address.street} - ${address.departmentNumber}
          </label>
        </c:forEach>
      </div>

      <div class="container">
        <div class="order-box" style="font-size: 20px">
          <h2 class="order-title" style="font-size: 30px">Your Order</h2>
          <table
            class="order-table"
            style="width: 100%; border-collapse: collapse; font-size: 22px"
          >
            <thead>
              <tr style="border-bottom: 2px solid #000">
                <th style="text-align: left; padding: 10px">Product</th>
                <th style="text-align: center; padding: 10px">Quantity</th>
                <th style="text-align: right; padding: 10px">Total</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${sessionScope.cartItems}" var="product">
                <tr
                  style="border-bottom: 1px solid #ddd"
                  class="t-pro"
                  data-price="${product.dprice}"
                  data-quantity="${product.quantity}"
                >
                  <td style="padding: 10px">${product.name}</td>
                  <td style="text-align: center; padding: 10px">
                    x ${product.quantity}
                  </td>
                  <td
                    style="text-align: right; padding: 10px"
                    class="item-price"
                  ></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>

          <ul class="order-summary" style="font-size: 22px; margin-top: 20px">
            <li
              class="order-subtotal"
              style="display: flex; justify-content: space-between"
            >
              <span>Subtotal</span>
              <span class="subtotal-price">EGP</span>
            </li>
            <li
              class="order-shipping"
              style="display: flex; justify-content: space-between"
            >
              <span>Shipping</span>
              <span class="shipping-price">shipping fees: 50.00 EGP</span>
            </li>
            <li
              class="order-total"
              style="
                display: flex;
                justify-content: space-between;
                font-weight: bold;
                font-size: 24px;
              "
            >
              <span>Total</span>
              <span class="overall-price" id="overallPriceSpan"> EGP</span>
            </li>
          </ul>

          <div class="order-terms" style="font-size: 20px; margin-top: 20px">
            <input type="checkbox" id="accept-terms" name="terms" />
            <label for="accept-terms"> I’ve read and accept the </label>
            <a href="#" data-bs-toggle="modal" data-bs-target="#termsModal"
              >terms & conditions*</a
            >
          </div>

          <div
            class="order-confirm"
            style="text-align: center; margin-top: 20px"
          >
            <form method="post" id="orderForm">

            <input type="hidden" name="addID" id="addID" />
<%--              <input type="hidden" name="totalvalue" id="totalvalue" />--%>

              <button
                type="button"
                class="button button-confirm"
                id="conf"
                style="font-size: 22px; padding: 10px 20px"
                onclick="submitForm('ValidateOrder')"
              >
                Confirm Order
              </button>
              <button
                type="button"
                onclick="submitForm('shoppingCartServlet')"
                class="button button-confirm"
                style="font-size: 22px; padding: 10px 20px"
              >
                Discard Order
              </button>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!--================End Checkout Area =================-->

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
    <!--================ Terms&conditions moder  =================-->
    <div
      class="modal fade"
      id="termsModal"
      tabindex="-1"
      aria-labelledby="termsModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="termsModalLabel">
              Terms and Conditions
            </h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <h2 style="font-size: 20px">Terms and Conditions</h2>
            <p><strong>Effective Date:</strong> [28-3-2025]</p>

            <h3 style="font-size: 16px">1. Acceptance of Terms</h3>
            <p>
              By accessing or purchasing from our website (<a
                href="https://www.yourperfumestore.com"
                >www.yourperfumestore.com</a
              >), you agree to comply with these Terms and Conditions.
            </p>

            <h3 style="font-size: 16px">
              2. Product Information & Availability
            </h3>
            <p>
              We strive to provide accurate product descriptions and images.
              However, actual fragrances may vary slightly.
            </p>
            <p>
              All products are subject to availability. If an item is out of
              stock, we will notify you and offer an alternative or refund.
            </p>

            <h3 style="font-size: 16px">3. Pricing & Payments</h3>
            <p>
              Prices are listed in [Currency] and may be subject to change
              without notice.
            </p>
            <p>
              We accept payments via [Visa, Mastercard, PayPal, etc.]. Your
              payment details are securely processed.
            </p>

            <h3 style="font-size: 16px">4. Shipping & Delivery</h3>
            <p>
              We offer domestic and international shipping. Shipping times vary
              based on location.
            </p>
            <p>
              Delays due to customs or unforeseen circumstances are beyond our
              control.
            </p>

            <h3 style="font-size: 16px">5. Returns & Refunds</h3>
            <p>
              Unopened and unused products can be returned within
              <strong>14 days</strong> of receipt.
            </p>
            <p>
              Refunds are processed within
              <strong>7 business days</strong> after receiving the returned
              item.
            </p>
            <p>Custom or personalized fragrances are non-refundable.</p>

            <h3 style="font-size: 16px">6. Privacy & Data Protection</h3>
            <p>
              Your personal data is handled securely in compliance with
              [GDPR/Other Relevant Laws].
            </p>
            <p>
              We do not share your data with third parties without your consent.
            </p>

            <h3 style="font-size: 16px">7. Prohibited Activities</h3>
            <p>You agree not to:</p>
            <ul>
              <li>Use our website for fraudulent activities.</li>
              <li>Attempt to access restricted areas of the site.</li>
              <li>Copy or distribute content without permission.</li>
            </ul>

            <h3 style="font-size: 16px">8. Contact Information</h3>
            <p>
              For inquiries, please contact us at
              <a href="mailto:support@yourperfumestore.com"
                >support@yourperfumestore.com</a
              >
              or call [Your Phone Number].
            </p>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
    <!--================ End Terms&conditions moder  =================-->
    <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="vendors/skrollr.min.js"></script>
    <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
    <script src="vendors/jquery.ajaxchimp.min.js"></script>
    <script src="vendors/mail-script.js"></script>
    <script src="js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
