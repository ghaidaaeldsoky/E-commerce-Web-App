<%@ page session="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>MISK Perfumes - Login</title>
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
  <style>
		.error {
    border: 2px solid red !important;
    background-color: #ffebeb;
}

.valid {
    border: 2px solid green !important;
    background-color: #eaffea;
}

	</style>
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
					<h1>Login / Register</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Login/Register</li>
            </ol>
          </nav>
				</div>
			</div>
    </div>
	</section>
	<!-- ================ end banner area ================= -->
  
  <!--================Login Box Area =================-->
	<section class="login_box_area section-margin">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
						<div class="hover">
							<h4>New to our website?</h4>
							<p>There are advances being made in science and technology everyday, and a good example of this is the</p>
							<a class="button button-account" href="register.jsp">Create an Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>Log in to enter</h3>
						<form class="row login_form"  id="contactForm" >
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'" >
							
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<input type="checkbox" id="f-option2" name="selector">
									<label for="f-option2">Keep me logged in</label>
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" id="submitButton" value="submit" class="button button-login w-100">Log In</button>
								<a href="#">Forgot Password?</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->



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
  <script>
var isValidEmail = false;
var isValidPassword = false;

$(document).ready(function() {
    
   
    $("#email").blur(function() {
        let emailVal = $("#email").val().trim();
        if (emailVal !== "") {
            $.post("loginController", {
                type: "email",
                email: emailVal
            }, emailCallBack);
        }
    });


    $("#password").blur(function() {
        let passwordVal = $("#password").val().trim();
        let emailVal = $("#email").val().trim();
        if (passwordVal !== "") {
            $.post("loginController", {
                type: "password",
                password: passwordVal,
                email: emailVal
            }, passwordCallBack);
        }
    });

  
    $("#submitButton").click(function(event) {
        event.preventDefault(); 

        let passwordVal = $("#password").val().trim();
        let emailVal = $("#email").val().trim();

     
        $.post("loginController", {
            type: "login",
            password: passwordVal,
            email: emailVal
        },loginCallBack);
    });
});


function emailCallBack(responseText, statusTxt, xhr) {
    if (statusTxt === "success") {
        
        isValidEmail = responseText.valid;
        updateFieldStyle("email", isValidEmail);
        updateButton();
    }
}


function passwordCallBack(responseText, statusTxt, xhr) {
    if (statusTxt === "success") {
      
        isValidPassword = responseText.valid;
        updateFieldStyle("password", isValidPassword);
        updateButton();
    }
}


function loginCallBack(response, statusTxt, xhr) {
    console.log("loginCallBack without IF");
    
    
    try {
        response = JSON.parse(response);
    } catch (error) {
        console.error("Failed to parse response as JSON:", error);
        console.log(response); 
        return;
    }

    if (response.redirect === true) {
        console.log("loginCallBack");
        window.location.href = response.redirectUrl;
    } else {
        console.log(response);
    }
}



function updateButton() {
    if (isValidEmail && isValidPassword) {
        $("#submitButton").prop("disabled", false);
    } else {
        $("#submitButton").prop("disabled", true);
    }
}

function updateFieldStyle(fieldId, isValid) {
    let field = $("#" + fieldId);
    if (isValid) {
        field.removeClass("error").addClass("valid");
    } else {
        field.removeClass("valid").addClass("error");
    }
}


</script>


</body>
</html>