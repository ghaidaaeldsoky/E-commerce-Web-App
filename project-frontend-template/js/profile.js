document.addEventListener("DOMContentLoaded", function () {
    let lastId = 2;
    const user = {
        firstName: "Ghaidaa",
        email: "ghaidaa@example.com",
        phone: "0123456789",
        password: "12345678",
        creditLimit: 5000,
        addresses: [
            { id: 1, state: "Cairo", city: "Nasr City", street: "Street 10", department: 5},
            { id: 2, state: "Giza", city: "Dokki", street: "Street 15", department: 3 }
        ],
    };

    // account detail tab
    const firstNameInput = document.getElementById("first-name");
    const emailInput = document.getElementById("email");
    const phoneInput = document.getElementById("phone");
    const editBtn = document.getElementById("edit-account");
    const saveBtn = document.getElementById("save-account");
    const updateMessage = document.getElementById("update-message");

    // Change Password tab
    const currentPasswordInput = document.getElementById("current-password");
    const newPasswordInput = document.getElementById("new-password");
    const confirmPasswordInput = document.getElementById("confirm-password");
    const savePasswordBtn = document.getElementById("save-password");
    const passwordUpdateMessage = document.getElementById("password-update-message");

    // Credit Limit tab
    const creditLimitInput = document.getElementById("credit-limit");
    const saveCreditBtn = document.getElementById("save-credit-limit");
    const creditError = document.getElementById("credit-error");
    const creditUpdateMessage = document.getElementById("credit-update-message");

    // Address tab
    const addressList = document.getElementById("address-list");
    const addAddressBtn = document.getElementById("add-address-btn");
    const addressFormOverlay = document.getElementById("address-form-overlay");
    const saveAddressBtn = document.getElementById("save-address-btn");
    const cancelAddressBtn = document.getElementById("cancel-address-btn");

    const stateInput = document.getElementById("address-state");
    const cityInput = document.getElementById("address-city");
    const streetInput = document.getElementById("address-street");
    const departmentInput = document.getElementById("address-department");

    function loadUserData() {
        firstNameInput.value = user.firstName;
        emailInput.value = user.email;
        phoneInput.value = user.phone;
        creditLimitInput.value = user.creditLimit;
    }

    loadUserData();

    // Buttons Handling:
    // 1- Edit (Account Details)
    editBtn.addEventListener("click", function () {
        [firstNameInput, emailInput, phoneInput].forEach((input) => {
            input.removeAttribute("disabled");
            input.style.backgroundColor = "#fff";
        });

        editBtn.classList.add("d-none");
        saveBtn.classList.remove("d-none");
    });

    // 2- Save (Account Details)
    // Save New account details Tab //
    saveBtn.addEventListener("click", function () {
        const updatedFirstName = firstNameInput.value.trim();
        const updatedEmail = emailInput.value.trim();
        const updatedPhone = phoneInput.value.trim();

        const hasChanged =
            updatedFirstName !== user.firstName ||
            updatedEmail !== user.email ||
            updatedPhone !== user.phone;

        [firstNameInput, emailInput, phoneInput].forEach((input) => {
            input.setAttribute("disabled", "true");
            input.style.backgroundColor = "transparent";
        });

        saveBtn.classList.add("d-none");
        editBtn.classList.remove("d-none");

        if (hasChanged) {
            user.firstName = updatedFirstName;
            user.email = updatedEmail;
            user.phone = updatedPhone;

            updateMessage.classList.remove("d-none");

            setTimeout(() => {
                updateMessage.classList.add("d-none");
            }, 3000);
        }
    });

    // 3- Save (Password)
    // Save new Password Tab //
    savePasswordBtn.addEventListener("click", function () {
        const currentPassword = currentPasswordInput.value.trim();
        const newPassword = newPasswordInput.value.trim();
        const confirmPassword = confirmPasswordInput.value.trim();

        if (!currentPassword || !newPassword || !confirmPassword) {
            alert("Please fill in all fields!");
            return;
        }

        if (currentPassword !== user.password) {
            alert("Current password is incorrect!");
            return;
        }

        if (newPassword !== confirmPassword) {
            alert("New passwords do not match!");
            return;
        }

        if (newPassword === user.password) {
            alert("Already your password");
            return;
        }

        // const strongPasswordRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        // if (!strongPasswordRegex.test(newPassword)) {
        //     alert("Password must be at least 8 characters long and include letters, numbers, and symbols.");
        //     return;
        // }

        user.password = newPassword;

        [currentPasswordInput, newPasswordInput, confirmPasswordInput].forEach(input => {
            input.value = "";
        });

        passwordUpdateMessage.classList.remove("d-none");

        setTimeout(() => {
            passwordUpdateMessage.classList.add("d-none");
        }, 3000);
    });


    // 4- Credit limit
    creditLimitInput.addEventListener("input", function () {
        let value = parseInt(creditLimitInput.value, 10);

        if (isNaN(value) || value < 1 || value > 10000) {
            creditError.classList.remove("d-none");
            saveCreditBtn.classList.add("d-none");
        } else {
            creditError.classList.add("d-none");
            saveCreditBtn.classList.remove("d-none");
        }
    });

    saveCreditBtn.addEventListener("click", function () {
        let newLimit = parseInt(creditLimitInput.value, 10);

        if (isNaN(newLimit) || newLimit < 1 || newLimit > 9999) {
            alert("Invalid credit limit! Must be between 1 and 10000.");
            return;
        }

        user.creditLimit = newLimit;
        saveCreditBtn.classList.add("d-none");
        creditUpdateMessage.classList.remove("d-none");

        console.log("Credit limit now = "+ user.creditLimit);
        setTimeout(() => {
            creditUpdateMessage.classList.add("d-none");
        }, 3000);
    });


    // Address :
    function renderAddresses() {
        addressList.innerHTML = "";

        user.addresses.forEach((address) => {
            const addressDiv = document.createElement("div");
            addressDiv.className = `col-md-6 mb-3`;

            addressDiv.innerHTML = `
                <div class="address-item card p-3">
                    <p><strong>${address.state}, ${address.city}</strong></p>
                    <p>${address.street}, Dept: ${address.department || "N/A"}</p>
                    <div class="address-actions mt-2">
                        <button class="btn btn-sm btn-danger delete-address" data-id="${address.id}">Delete</button>
                    </div>
                </div>
            `;

            addressList.appendChild(addressDiv);
        });
    }

    renderAddresses();


    // Popup Add address
    addAddressBtn.addEventListener("click", function () {
        addressFormOverlay.classList.remove("d-none");
    });

    // Remove popup
    cancelAddressBtn.addEventListener("click", function () {
        addressFormOverlay.classList.add("d-none");
        clearForm();
    });

    // Save New Address
    saveAddressBtn.addEventListener("click", function () {
        const requiredFields = [
            { input: stateInput, message: "State is required" },
            { input: cityInput, message: "City is required" },
            { input: streetInput, message: "Street is required" }
        ];
    
        let isValid = true;
    
        requiredFields.forEach(({ input, message }) => {
            let parent = input.parentNode;
            let errorMessage = parent.querySelector(".error-message");
    
            if (!input.value.trim()) {
                input.classList.add("border-danger");
    
                if (!errorMessage) {
                    let small = document.createElement("small");
                    small.classList.add("text-danger", "error-message", "d-block", "mt-1");
                    small.textContent = message;
                    parent.appendChild(small);
                }
                isValid = false;
            } else {
                input.classList.remove("border-danger");
                if (errorMessage) {
                    errorMessage.remove();
                }
            }
        });
    
        if (!isValid) return;
    
        // إنشاء العنوان الجديد
        const newAddress = {
            id: ++lastId,
            state: stateInput.value.trim(),
            city: cityInput.value.trim(),
            street: streetInput.value.trim(),
            department: departmentInput.value.trim() || null,
        };
    
        // إضافة العنوان وحفظه
        user.addresses.push(newAddress);
        renderAddresses();
        addressFormOverlay.classList.add("d-none");
        clearForm();
    });
    
    
    

    // Delete Selected Address
    addressList.addEventListener("click", function (e) {
        if (e.target.classList.contains("delete-address")) {
            const addressId = parseInt(e.target.getAttribute("data-id"));
            user.addresses = user.addresses.filter((address) => address.id !== addressId);
            renderAddresses();
        }
    });

        const stateSelect = document.getElementById("address-state");
        
        new Choices(stateSelect, {
            removeItemButton: true,
            searchEnabled: true, 
            shouldSort: false 
        });
    

    function clearForm() {
        stateInput.value = "";
        cityInput.value = "";
        streetInput.value = "";
        departmentInput.value = "";
    }
});
