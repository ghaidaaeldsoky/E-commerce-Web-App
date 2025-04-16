<!DOCTYPE html>
<%@ page session="false" %>
<%@ page isErrorPage="true" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>MISK Perfumes - Error</title>
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
        <h2 class="confirmation_title">Error!</h2>
        <p class="confirmation_message">
          Can't find this page  
        </p>
        <img
          src="img/error2.jpg"
          alt="error"
          class="confirmation_image"
          style="width: 50%;"
        />
        <div class="button_container mt-4">
          <form action="home" method="get">
            <button
            type="submit"
            class="button btn-outline-primary btn-lg m-3"
          >Back to Home</button>
            <!-- <button type="submit" class="btn btn-primary">Back to Home</button> -->
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
