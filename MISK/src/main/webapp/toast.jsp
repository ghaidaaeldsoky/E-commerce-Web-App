<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>

<%
    String msg = (String) session.getAttribute("message");
    String type = (String) session.getAttribute("type");
    session.removeAttribute("message");
    session.removeAttribute("type");

    if (msg != null && type != null) {
%>
    <div class="position-fixed top-0 end-0 p-3" style="z-index: 1050;">
        <div class="toast align-items-center text-white bg-<%= type %> border-0" role="alert" aria-live="assertive" aria-atomic="true" id="liveToast">
            <div class="d-flex">
                <div class="toast-body"><%= msg %></div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast"></button>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const toastEl = document.getElementById("liveToast");
            const toast = new bootstrap.Toast(toastEl, { delay: 4000 });
            toast.show();
        });
    </script>
<%
    }
%>
