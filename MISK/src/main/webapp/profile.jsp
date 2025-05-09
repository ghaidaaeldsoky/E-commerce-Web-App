<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>MISK Perfumes - Profile</title>
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
    <!-- Include Choices.js CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/choices.js/public/assets/styles/choices.min.css"
    />

    <!-- Include Choices.js JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/choices.js/public/assets/scripts/choices.min.js"></script>

    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <!--================ Start Header Menu Area =================-->
    <jsp:include page="nav.jsp" />
    <!--================ End Header Menu Area =================-->

    <!-- ================ start banner area ================= -->
    <!-- ================ end banner area ================= -->

    <!-- ================ Account section start ================= -->
    <!-- <section class="section-margin--small mb-5"> -->
    <!-- <div class="container"> -->
    <!-- <div class="row"> -->

    <!-- My Account Start -->
    <div class="my-account">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <div
              class="nav flex-column nav-pills"
              role="tablist"
              aria-orientation="vertical"
            >
              <a
                class="nav-link active"
                id="account-nav"
                data-toggle="pill"
                href="#account-tab"
                role="tab"
                >Account Details</a
              >
              <a
                class="nav-link"
                id="address-nav"
                data-toggle="pill"
                href="#address-tab"
                role="tab"
                >Manage Addresses</a
              >
              <a
                class="nav-link"
                id="credit-limit-nav"
                data-toggle="pill"
                href="#credit-limit-tab"
                role="tab"
                >Credit Limit</a
              >
              <a
                class="nav-link"
                id="password-nav"
                data-toggle="pill"
                href="#password-tab"
                role="tab"
                >Change Password</a
              >
            </div>
          </div>
          <div class="col-md-9">
            <div class="tab-content">
              <!-- Account Details Tab -->
              <div
                class="tab-pane fade show active"
                id="account-tab"
                role="tabpanel"
              >
                <h4>Account Details</h4>
                <div class="form-group">
                  <label>First Name</label>
                  <input
                    type="text"
                    class="form-control input-field"
                    id="first-name"
                    disabled
                  />
                </div>
                <div class="form-group">
                  <label>Email</label>
                  <input
                    type="email"
                    class="form-control input-field"
                    id="email"
                    disabled
                  />
                </div>
                <div class="form-group">
                  <label>Phone</label>
                  <input
                    type="text"
                    class="form-control input-field"
                    id="phone"
                    disabled
                  />
                </div>
                <button id="edit-account" class="btn btn-primary">Edit</button>
                <button id="save-account" class="btn btn-success d-none">
                  Save
                </button>

                <p id="update-message" class="update-message d-none">
                  Updated successfully!
                </p>
              </div>

              <!-- Address Tab -->
              <div class="tab-pane fade" id="address-tab" role="tabpanel">
                <h4>Manage Addresses</h4>
                <button class="btn btn-success mb-2" id="add-address-btn">
                  Add New Address
                </button>

                <div id="address-list" class="row">
                  <!-- Addresses will be dynamically added here -->
                </div>

                <!-- Address Form (Hidden by default) -->
                <div id="address-form-overlay" class="d-none">
                  <div id="address-form-container">
                    <h5 class="text-center mb-4">Add New Address</h5>
                    <div class="form-group mb-3">
                      <label class="d-block fw-bold">State *</label>
                      <select
                        class="form-control w-100 mt-1"
                        id="address-state"
                      >
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
                      <!-- <small class="error-message text-danger d-none">State is required</small>             -->
                    </div>
                    <div class="form-group">
                      <label>City *</label>
                      <input
                        type="text"
                        class="form-control"
                        id="address-city"
                      />
                      <!-- <small class="error-message text-danger d-none">City is required</small> -->
                    </div>
                    <div class="form-group">
                      <label>Street *</label>
                      <input
                        type="text"
                        class="form-control"
                        id="address-street"
                      />
                      <!-- <small class="error-message text-danger d-none">Street is required</small> -->
                    </div>
                    <div class="form-group">
                      <label>Department Number</label>
                      <input
                        type="number"
                        class="form-control"
                        id="address-department"
                      />
                    </div>
                    <div class="form-buttons">
                      <button class="btn btn-primary" id="save-address-btn">
                        Save Address
                      </button>
                      <button class="btn btn-secondary" id="cancel-address-btn">
                        Cancel
                      </button>
                    </div>
                  </div>
                </div>
              </div>

              <!-- credit-limit Tab -->
              <div class="tab-pane fade" id="credit-limit-tab" role="tabpanel">
                <h4>Credit Limit</h4>
                <div class="form-group">
                  <label>Enter your credit limit</label>
                  <input
                    type="number"
                    class="form-control"
                    id="credit-limit"
                    min="1"
                    max="9999"
                  />
                  <small id="credit-error" class="text-danger d-none"
                    >Value must be between 1 and 10000</small
                  >
                </div>
                <button class="btn btn-success d-none" id="save-credit-limit">
                  Save Changes
                </button>
                <p id="credit-update-message" class="text-success d-none">
                  Credit limit updated successfully!
                </p>
              </div>

              <!-- Change Password Tab -->
              <div class="tab-pane fade" id="password-tab">
                <div class="password-change">
                  <h4>Change Password</h4>
                  <div class="form-group">
                    <label for="current-password">Current Password *</label>
                    <input
                      type="password"
                      id="current-password"
                      class="form-control"
                    />
                  </div>
                  <div class="form-group">
                    <label for="new-password">New Password *</label>
                    <input
                      type="password"
                      id="new-password"
                      class="form-control"
                    />
                  </div>
                  <div class="form-group">
                    <label for="confirm-password">Confirm New Password *</label>
                    <input
                      type="password"
                      id="confirm-password"
                      class="form-control"
                    />
                  </div>
                  <button id="save-password" class="btn">Save Changes</button>
                  <p id="password-update-message" class="update-message d-none">
                    Password updated successfully!
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- My Account End -->
    <!-- </div> -->
    <!-- </div> -->
    <!-- </section> -->
    <!-- ================ Account section end ================= -->

    <!--================ Start footer Area  =================-->
    <jsp:include page="footer.jsp" />
    <!--================ End footer Area  =================-->

    <script src="vendors/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
    <script src="vendors/skrollr.min.js"></script>
    <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="vendors/nice-select/jquery.nice-select.min.js"></script>
    <script src="vendors/nouislider/nouislider.min.js"></script>
    <script src="vendors/jquery.ajaxchimp.min.js"></script>
    <script src="vendors/mail-script.js"></script>
    <script src="js/main.js"></script>
    <script src="./js/profile.js"></script>
  </body>
</html>
