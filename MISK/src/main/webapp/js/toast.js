function showToast(message, type) {
  var toastHtml = `
            <div class="position-fixed top-0 end-0 p-3" style="z-index: 1050;">
                <div class="toast align-items-center text-white bg-${type} border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
                    <div class="d-flex">
                        <div class="toast-body">${message}</div>
                        <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
                    </div>
                </div>
            </div>
        `;

  $("body").append(toastHtml);

  var toastEl = document.getElementById("liveToast");
  if (toastEl) {
    var toast = new bootstrap.Toast(toastEl, { delay: 4000 });
    toast.show();
  }
}

function addToCart(productId) {
  $.ajax({
    url: "/show-toast", 
    type: "POST",
    data: {
      alertMessage: "Product added successfully!", 
      alertType: "success", 
    },
    success: function (response) {
      var msg = response.alertMessage;
      var type = response.alertType;

      showToast(msg, type);
    },
    error: function (xhr, status, error) {
      console.error("Request failed: " + error);
    },
  });
}

$("#addToCartBtn").click(function () {
  var productId = $(this).data("productId");
  addToCart(productId);
});
