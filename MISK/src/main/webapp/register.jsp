
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
					<h1>Register</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Register</li>
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
							<h4>Already have an account?</h4>
							<p>There are advances being made in science and technology everyday, and a good example of
								this is the</p>
							<a class="button button-account" href="login.jsp">Login Now</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner register_form_inner">
						<h3>Create an account</h3>
						<form class="row login_form" action="registerController" id="register_form" method="post">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="name" name="name" placeholder="Username"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="date" class="form-control" id="birthday" name="birthday"
									placeholder="birthday" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'birthday'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="Email Address" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Email Address'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="job" name="job" placeholder="job"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'job'">
							</div>
							<div class="col-md-12 form-group">
								<input type="number" class="form-control" id="creditCardLimit" name="creditCardLimit"
									placeholder="creditCardLimit" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'creditCard Limit'"
									min="1000" max="50000" step="500">
							</div>

							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
									placeholder="phoneNumber" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'phoneNumber'">
							</div>


						<!-- State Dropdown -->
<div class="col-md-12 form-group">
    <select class="form-control" id="address-state" name="state" onfocus="this.placeholder = ''" onblur="this.placeholder = 'State'">
        <option value="" disabled selected>Select State</option>
        <option value="Alexandria">Alexandria</option>
        <option value="Aswan">Aswan</option>
        <option value="Asyut">Asyut</option>
        <option value="Beheira">Beheira</option>
        <option value="Beni Suef">Beni Suef</option>
        <option value="Cairo">Cairo</option>
        <option value="Dakahlia">Dakahlia</option>
        <option value="Damietta">Damietta</option>
        <option value="Fayoum">Fayoum</option>
        <option value="Gharbia">Gharbia</option>
        <option value="Giza">Giza</option>
        <option value="Ismailia">Ismailia</option>
        <option value="Kafr El-Sheikh">Kafr El-Sheikh</option>
        <option value="Luxor">Luxor</option>
        <option value="Matrouh">Matrouh</option>
        <option value="Minya">Minya</option>
        <option value="Monufia">Monufia</option>
        <option value="New Valley">New Valley</option>
        <option value="North Sinai">North Sinai</option>
        <option value="Port Said">Port Said</option>
        <option value="Qalyubia">Qalyubia</option>
        <option value="Qena">Qena</option>
        <option value="Red Sea">Red Sea</option>
        <option value="Sharqia">Sharqia</option>
        <option value="Sohag">Sohag</option>
        <option value="South Sinai">South Sinai</option>
        <option value="Suez">Suez</option>
    </select>
</div>

<!-- City Input -->
<div class="col-md-12 form-group">
    <input type="text" class="form-control" id="address-city" name="city" placeholder="City" onfocus="this.placeholder = ''" onblur="this.placeholder = 'City'">
</div>

<!-- Street Input -->
<div class="col-md-12 form-group">
    <input type="text" class="form-control" id="address-street" name="street" placeholder="Street" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Street'">
</div>

<!-- Department Number Input -->
<div class="col-md-12 form-group">
    <input type="number" class="form-control" id="address-department" name="department" placeholder="Department Number" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Department Number'">
</div>


							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="interests" name="interests"
									placeholder="interests" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'interests'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="password" name="password"
									placeholder="password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Password'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="confirmPassword" name="confirmPassword"
									placeholder="Confirm Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Confirm Password'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<input type="checkbox" id="f-option2" name="selector">
									<label for="f-option2">Keep me logged in</label>
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit"
								id="button-register"
									class="button button-register w-100">Register</button>
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

var isValidEmail = true;
  
    var isValidPassword = false;
    var isValidConfirmPassword = false;
	var isValidName = false;
var isValidBirthday = false;




		$(document).ready(function () {
			$("#email").blur(function () {
				let email = document.getElementById("email").value;

				if (email != "" && checkEmailValidation(email)) {
					$.post("loginController",
						{
							type: "email",
							email: email
						},
						emailCallBack
					)
				}
			});
			$("#name").blur(function () {
        let name = $(this).val().trim();
        isValidName = name.length >= 3;
        updateFieldStyle("name", isValidName);
        updateButton();
    });

    $("#birthday").blur(function () {
        let birthday = $(this).val().trim();
        isValidBirthday = birthday !== "";
        updateFieldStyle("birthday", isValidBirthday);
        updateButton();
    });

		});
		document.getElementById("password").addEventListener("blur", function() {
    let password = document.getElementById("password").value;
    isValidPassword = checkPasswordValidation(password);
    updateFieldStyle("password", isValidPassword);
    updateButton();
});

document.getElementById("confirmPassword").addEventListener("blur", function() {
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    isValidConfirmPassword = checkConfirmPassword(password, confirmPassword);
    updateFieldStyle("confirmPassword", isValidConfirmPassword);
    updateButton();
});


		function emailCallBack(response ,statusTxt, xhr) {

		

	isValidEmail  =response.valid ;

	updateButton();

}
function updateButton() {
    let registerButton = document.getElementById("button-register"); 
    if (!isValidEmail && isValidPassword && isValidConfirmPassword && isValidName && isValidBirthday) {
        registerButton.disabled = false;
        registerButton.style.opacity = "1"; 
    } else {
        registerButton.disabled = true;
        registerButton.style.opacity = "0.5"; 
    }
}



		
		
		function checkEmailValidation(email) {
			let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
			 return emailPattern.test(email);
    }


	function checkPasswordValidation(password)
	{
		let passwordPattern = /^\w{8,12}$/;

		return passwordPattern.test(password);
	}
	function checkConfirmPassword(password , confirmPassword)
	{	
		if (!password || !confirmPassword) return false;
		return password.trim()== confirmPassword.trim();
	}
	function updateFieldStyle(fieldId, isValid) {
    let field = $("#" + fieldId);
    if (isValid) {
        field.removeClass("error valid"); 
    } else {
        field.removeClass("valid").addClass("error"); 
    }
}

document.getElementById("button-register").addEventListener("click",function(){

	let formData = {};

	let formElements = document.querySelectorAll("#register_form input");

	formElements.forEach(element =>{

		if(element.type==="checkbox")
	{
		formData[element.name] = element.checked;
	}
	else if (element.tagName.toLowerCase() === "select") {
           
            formData[element.name] = element.value;
        }
	else
	formData[element.name] = element.value ;

	});

	console.log(formData);


	$.post("RegisterServlet" ,formData);


});


	</script>
</body>

</html>