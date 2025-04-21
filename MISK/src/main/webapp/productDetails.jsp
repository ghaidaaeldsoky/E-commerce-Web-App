<%@ page isELIgnored="false" %>
  <%@ page session="false" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <meta http-equiv="X-UA-Compatible" content="ie=edge" />
      <title>MISK Perfumes - Product Details</title>
      <link rel="icon" href="img/Fevicon.png" type="image/png" />
      <link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css" />
      <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css" />
      <link rel="stylesheet" href="vendors/themify-icons/themify-icons.css" />
      <link rel="stylesheet" href="vendors/linericon/style.css" />
      <link rel="stylesheet" href="vendors/nice-select/nice-select.css" />
      <link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css" />
      <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css" />

      <link rel="stylesheet" href="css/style.css" />
      <link rel="stylesheet" href="css/main.css" />
    </head>

    <script>
      //this is for the counter
      const productId = "${pro.id}";



      document.addEventListener("DOMContentLoaded", function () {
        var productQuantity = ${ pro.quantity };

        if (productQuantity == 0) {
          document.getElementById("sst").value = 0;
          const messageContainer = document.getElementById('stock-message');
          messageContainer.textContent = "Out of stock";
        }

        // Increase button event listener
        document.getElementById("increase-btn").addEventListener("click", function () {
          var result = document.getElementById("sst");
          var sst = result.value;
          if (!isNaN(sst) && sst < productQuantity) {
            result.value++;
          }
        });

        // Decrease button event listener
        document.getElementById("decrease-btn").addEventListener("click", function () {
          var result = document.getElementById("sst");
          var sst = parseInt(result.value, 10);
          if (!isNaN(sst) && sst > 1) {  // Prevent going below 1
            result.value = sst - 1;
          }
        });


      });
      // *******************************************************************************************

      function submitForm() {

        //let Currentuser = "${sessionScope.user}";
        // if (Currentuser == null || Currentuser == "") {
        //   alert("Please login to add items to your cart.");
        //   return false; // Prevent form submission
        // } else {

        if (document.getElementById("sst").value == 0) {
          const messageContainer = document.getElementById('stock-add-message');
          messageContainer.textContent = "Cannot add 0 items to the cart";
          setTimeout(() => {
            messageContainer.textContent = "";
          }, 2000);
          return false;

        }

        let qtyValue = document.getElementById("sst").value;
        document.getElementById("quant").value = qtyValue;

        $.ajax({
          url: "/MISK/CartCounter",
          type: "POST",
          data: { productId: productId },
          success: function (response) {
            console.log("cart updated successfully");
            document.querySelector(".nav-shop__circle").textContent = response;

          },
          error: function (xhr, status, error) {
            console.error("Error:", error);
          },
        });
        document.getElementById("subform").submit();


      }
    </script>

    <body>
      t
      <!--================ Start Header Menu Area =================-->
      <jsp:include page="nav.jsp" />
      <!--================ End Header Menu Area =================-->

      <!--================Single Product Area =================-->
      <div class="product_image_area" style="margin-bottom: 100px">
        <div class="container">
          <div class="row s_product_inner">
            <div class="col-lg-6">
              <div class="owl-carousel owl-theme s_Product_carousel">
                <div class="single-prd-item">
                  <img class="img-fluid" src="${pro.photo}" alt="" />
                </div>
                <div class="single-prd-item">
                  <img class="img-fluid" src="${pro.photo}" alt="" />
                </div>
                <div class="single-prd-item">
                  <img class="img-fluid" src="${pro.photo}" alt="" />
                </div>
              </div>
            </div>
            <div class="col-lg-5 offset-lg-1">
              <div class="s_product_text">
                <h2 class="singleProductnameInSingleProductDetailsPage">
                  ${pro.name}
                </h2>
                <div id="stock-message" style="color: red; font-weight: bold"></div>
                <h3 class="singleProductPriceInSingleProductDetailsPage">
                  ${pro.price} EGP
                </h3>
                <h4>Brand : <span>${pro.brand}</span></h4>
                <h4>Gender : <span>${pro.gender}</span></h4>
                <h4>Size : <span>${pro.size}</span></h4>

                <p class="pro_desc">${pro.description}</p>
                <div style="
                  display: flex;
                  align-items: center;
                  justify-content: space-between;
                  margin: 20px;
                  padding: 10px;
                  border: 1px solid #ddd;
                  border-radius: 5px;
                ">
                  <!-- Quantity Section -->
                  <div style="display: flex; align-items: center" id="theone">
                    <label style="margin-right: 10px; font-weight: bold">Quantity:</label>
                    <button id="increase-btn" class="increase items-count" type="button" style="
                      padding: 5px 10px;
                      border: none;
                      background-color: #ddd;
                      cursor: pointer;
                      margin-right: 5px;
                    ">
                      <i class="ti-angle-up"></i>
                    </button>
                    <input type="text" name="qty" id="sst" size="2" maxlength="12" value="1" title="Quantity:"
                      class="input-text qty" readonly style="
                      width: 40px;
                      text-align: center;
                      border: 1px solid #ccc;
                      margin-right: 5px;
                    " />
                    <button id="decrease-btn" class="reduced items-count" type="button" style="
                      padding: 5px 10px;
                      border: none;
                      background-color: #ddd;
                      cursor: pointer;
                    ">
                      <i class="ti-angle-down"></i>
                    </button>
                  </div>

                  <!-- Add to Cart Button -->
                  <form action="addSingleToCart" method="post" id="subform" style="margin-left: auto">
                    <input type="hidden" name="proId" value="${pro.id}" />
                    <input type="hidden" name="quantity" id="quant" />
                    <button type="submit" class="button primary-btn ml-2" onclick="return submitForm();">
                      Add to Cart
                    </button>
                  </form>
                </div>
                <div id="stock-add-message" style="color: red; font-weight: bold; text-align: center"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--================End Single Product Area =================-->

      <!--================Product Description Area =================-->

      <!--================End Product Description Area =================-->

      <!--================ Start related Product area =================-->
      <!--================ end related Product area =================-->

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