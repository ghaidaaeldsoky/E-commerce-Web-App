<!DOCTYPE html>
<%@ page session="false" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>MISK Perfumes - Confirm</title>
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
    <jsp:include page="nav.jsp" />
    <!--================ End Header Menu Area =================-->

    <!-- ================ start banner area ================= -->

    <!-- ================ end banner area ================= -->

    <!--================Cart Area =================-->
    <section class="order_confirmation_area section_gap" style="margin: 50px">
      <div class="container text-center">
        <h2 class="confirmation_title">Thank You for Your Purchase!</h2>
        <p class="confirmation_message">
          <!--    only to check that the parameters reaches here  <%
           String selectedAddressId = request.getParameter("addID");
           String totalOrderPrice = request.getParameter("totalvalue");
           %>
           <p>Selected Address ID: <%= selectedAddressId %></p>
           <p>Total Order Price: <%= totalOrderPrice %></p> -->

          Your order has been successfully placed. You should expect delivery
          within <strong>3 days</strong>.
        </p>
        <img
          src="img/order_confirmed.png"
          alt="Order Confirmed"
          class="confirmation_image"
        />
        <div class="button_container mt-4">
          <form action="home" method="get">
            <button type="submit" class="btn btn-primary">Back to Home</button>
          </form>
        </div>
      </div>
    </section>
    <!--================End Cart Area =================-->

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
  </body>
</html>
