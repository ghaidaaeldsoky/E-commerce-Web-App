<%@ page session="false"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<<<<<<< HEAD
<%@taglib prefix="c" uri="jakarta.tags.core" %>
=======


>>>>>>> 4e8c42ef76a8d8949b9c241dd7e6bb93a159bab2
<%
    HttpSession sessionUser = request.getSession(false);
    String userId = (sessionUser != null) ? (String) request.getAttribute("userId") : null;
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Aroma Shop - Login</title>
    <link rel="icon" href="img/Fevicon.png" type="image/png">
    <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="vendors/linericon/style.css">
    <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="vendors/nice-select/nice-select.css">
    <link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header class="header_area">
        <div class="main_menu">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container">
                    <a class="navbar-brand logo_h" href="home"><img src="img/logo1.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
                            <li class="nav-item"><a class="nav-link" href="home">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="category.html">Shop Category</a></li>

                            <%
                                if(userId != null) {
                            %>
                            <li class="nav-item"><a class="nav-link" href="LogoutController">LogOut</a></li>
                            <%
                                } else {
                            %>
                                    <li class="nav-item"><a class="nav-link" href="login.jsp">LogIn</a></li>
                                    <li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>
                            <%
                                }
                            %>

                            <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact</a></li>
                        </ul>

                        <ul class="nav-shop">
                            <li class="nav-item"><button><i class="ti-search"></i></button></li>
                            <li class="nav-item">

                                    <%--    *******cart counter********                           --%>
                                <button class="cart-button" onclick="window.location.href='shoppingCartServlet'"><i class="ti-shopping-cart"></i>
                                    <c:if test="${not empty sessionScope.productIds}">
                                        <span class="nav-shop__circle">${sessionScope.productIds.size()}</span>
                                    </c:if>
                                    <c:if test="${ empty sessionScope.productIds}">
                                        <span class="nav-shop__circle"></span>
                                    </c:if>

                                </button>
                            </li>
                            <li class="nav-item"><a class="button button-header" href="checkoutServlet">Buy Now</a></li>
                        </ul>
                    </div>
                </div> <!-- إغلاق container -->
            </nav>
        </div> <!-- إغلاق main_menu -->
    </header>
    <!--================ End Header Menu Area =================-->

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
