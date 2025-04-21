
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>MISK Admin</title>
  <!-- base:css -->
  <link rel="stylesheet" href="css/materialdesignicons.min.css">
  <link rel="stylesheet" href="css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/styleAdmin.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="img/Fevicon.png" />
  <link rel="icon" href="img/Fevicon.png" type="image/png" />
</head>

<body>
  <div class="container-scroller d-flex">
    <!-- partial:../../partials/_sidebar.html -->
    <nav class="sidebar sidebar-offcanvas" id="sidebar">
      <ul class="nav">
      
        <li class="nav-item sidebar-category">
          <p>Components</p>
          <span></span>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Users.jsp">
            <i class="mdi mdi-account-multiple-outline menu-icon"></i>
            <span class="menu-title">Users</span>
          </a>

        <li class="nav-item">
          <a class="nav-link" href="Products.html">
            <i class="mdi mdi-package-variant-closed
            menu-icon"></i>
            <span class="menu-title">Products</span>
          </a>

        </li>
        <li class="nav-item">
          <a class="nav-link" href="Orders.jsp">
            <i class="mdi mdi-cart-outline menu-icon"></i>
            <span class="menu-title">Orders</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="LogoutController" >
            <i class="mdi mdi-export" style="margin-right: 20px;"></i>
            <span class="menu-title">  LogOut</span>
          </a>
        </li>






      </ul>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper" style="margin: 20px;">
      <!-- partial:../../partials/_navbar.html -->
      <h1 style="margin-bottom: 30px;">Users Management</h1>
      <!---table-->
      <div class="table-responsive d-flex justify-content-center" >
        <table class="table table-hover" id="usersTable" >
          <thead>
            <tr>
              <th>User Name</th>
              <th>phone Number</th>
              <th>email</th>
              <th>birthday</th>
              <th>job</th>
              <th>credit Limit</th>
              <th>intersets</th>


            </tr>
          </thead>
          <tbody>

          </tbody>
        </table>
      </div>

      <!-- content-wrapper ends -->
      <!-- partial:../../partials/_footer.html -->
   
      <!-- partial -->
    </div>
    <!-- main-panel ends -->
  </div>
  <!-- page-body-wrapper ends -->

  <!-- container-scroller -->
  <!-- base:js -->
 


  <script src="vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <script src="js/jquery.cookie.js" type="text/javascript"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>



  <script>




function displayUser(user) {
    let usersTable = document.getElementById("usersTable");

    let row = usersTable.insertRow();

    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);
    let cell6 = row.insertCell(5);
    let cell7 = row.insertCell(6);

    cell1.textContent = user.userName;
    cell2.textContent = user.phoneNumber;
    cell3.textContent = user.email;
    cell4.textContent = user.birthDay;
    cell5.textContent = user.job;
    cell6.textContent = user.creditLimit;
    cell7.textContent = user.intersets;
}

function loadUsers() {
    fetch('loadUsers') 
        .then(response => {
            console.log("Response Status:", response.status);  
            console.log("Response Headers:", response.headers.get("Content-Type"));  
            
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            
           
            const contentType = response.headers.get("Content-Type");
            if (!contentType || !contentType.includes("application/json")) {
                throw new Error("Expected JSON response but got: " + contentType);
            }
            
            return response.json();
        })
        .then(data => {
            console.log("Data received from server:", data);  
            

            if (!Array.isArray(data)) {
                throw new Error("Expected an array but got: " + typeof data);
            }
            
            data.forEach(user => displayUser(user));
        })
        .catch(error => console.error('Error fetching users:', error));
}

loadUsers();


  </script>
  <!-- endinject -->
  <!-- End custom js for this page-->
</body>

</html>