// const myForm = document.querySelector("#registerForm");
//
// let nameErrorMsg = document.getElementById('nameErrorMsg');
// let mobileErrorMsg = document.getElementById('mobileErrorMsg');
// let passErrorMsg = document.getElementById('passErrorMsg');
// let cPassErrorMsg = document.getElementById('cPassErrorMsg');
// let totalValidate = 0;
//
// let message;
//
// myForm.addEventListener("submit", function(e) {
//     e.preventDefault();
//     formValues();
//     checkEmpty();
//     if (totalValidate === 4) {
//         myForm.submit();
//     }
//
//
// });
//
// const checkEmpty = function() {
//
//     const fullName = myForm.fullname.value;
//     const mobile = myForm.mobile.value;
//     const password = myForm.password.value;
//     const cPassword = myForm.cpassword.value;
//
//     if (fullName === '') {
//         nameErrorMsg.textContent = "Do not leave empty";
//     } else {
//         nameErrorMsg.textContent = ""
//         totalValidate += 1;
//     }
//
//     if (mobile === '') {
//         mobileErrorMsg.textContent = "Do not leave empty"
//     } else {
//         mobileErrorMsg.textContent = "";
//         totalValidate += 1;
//     }
//
//     if (password === '') {
//         passErrorMsg.textContent = "Do not leave empty";
//     } else {
//         passErrorMsg.textContent = "";
//         totalValidate += 1;
//     }
//
//     if (cPassword === '') {
//         cPassErrorMsg.textContent = "Do not leave empty";
//     } else {
//         cPassErrorMsg.textContent = "";
//         totalValidate += 1;
//     }
//
// }
//
// const formValues = function () {
//     let fullName = myForm.fullname;
//     let mobile = myForm.mobile;
//     let password = myForm.password;
//     let cPassword = myForm.cpassword;
//
//     const fullNameArr = fullName.split(" ");
//     const firstName = fullNameArr[0];
//     const lastName = fullNameArr[1].trim();
//
//     const firstLetterOfFirstName = firstName[0].toUpperCase();
//     const restOfFirstName = firstName.slice(1).toLowerCase();
//     const cappedFirstName = firstLetterOfFirstName + restOfFirstName;
//
//     const firstLetterOfLastName = lastName[0].toUpperCase();
//     const restOfLastName = lastName.slice(1).toLowerCase();
//     const cappedLastName = firstLetterOfLastName + restOfLastName;
//
//     const newFullnameArr = [cappedFirstName, cappedLastName];
//     const newFullname = newFullnameArr.join(" ");
//
//     fullName.value = newFullname;
//
//     if (mobile.value.length !== 10) {
//         mobileErrorMsg.textContent = "Mobile length must be 10";
//     } else {
//         mobileErrorMsg.textContent = "";
//     }
//
//     if (password.value.length < 6 || password.value.length > 8) {
//         passErrorMsg.textContent = "Password should be between 6 and 8 characters long";
//     } else if (password.value !== cPassword.value) {
//         passErrorMsg.textContent = "Password do not match"
//     } else {
//         passErrorMsg.textContent = "";
//     }
//
//
// }

const myForm = document.querySelector("#registerForm");
const nameErrorMsg = document.getElementById('nameErrorMsg');
const mobileErrorMsg = document.getElementById('mobileErrorMsg');
const passErrorMsg = document.getElementById('passErrorMsg');
const cPassErrorMsg = document.getElementById('cPassErrorMsg');
let totalValidate = 0;

myForm.addEventListener("submit", function(e) {
    e.preventDefault();
    const formData = getFormData();
    const validationErrors = validateForm(formData);

    clearErrorMessages();
    if (validationErrors.length === 0) {
        myForm.submit();
    } else {
        displayErrors(validationErrors);
    }
});

function getFormData() {
    const fullNameInput = myForm.fullname;
    const fullName = fullNameInput.value.trim();
    const mobile = myForm.mobile.value;
    const password = myForm.password.value;
    const cPassword = myForm.cpassword.value;

    // Capitalize the first letter of the first name and last name
    const fullNameArr = fullName.split(" ");
    const firstName = fullNameArr[0];
    const lastName = fullNameArr[1] ? fullNameArr[1].trim() : '';

    const firstLetterOfFirstName = firstName.charAt(0).toUpperCase();
    const restOfFirstName = firstName.slice(1).toLowerCase();
    const cappedFirstName = firstLetterOfFirstName + restOfFirstName;

    const firstLetterOfLastName = lastName.charAt(0).toUpperCase();
    const restOfLastName = lastName.slice(1).toLowerCase();
    const cappedLastName = firstLetterOfLastName + restOfLastName;

    const newFullnameArr = [cappedFirstName, cappedLastName];
    const newFullname = newFullnameArr.join(" ");

    fullNameInput.value = newFullname;

    return {
        fullName: newFullname,
        mobile,
        password,
        cPassword,
    };
}

function validateForm(formData) {
    const errors = [];

    if (formData.fullName.trim() === '') {
        errors.push("Name cannot be empty");
    } else {
        totalValidate += 1;
    }

    if (formData.mobile.length !== 10) {
        errors.push("Mobile length must be 10");
    } else {
        totalValidate += 1;
    }

    if (formData.password.length < 6 || formData.password.length > 8) {
        errors.push("Password should be between 6 and 8 characters long");
    } else if (formData.password !== formData.cPassword) {
        errors.push("Passwords do not match");
    }

    return errors;
}

function clearErrorMessages() {
    nameErrorMsg.textContent = "";
    mobileErrorMsg.textContent = "";
    passErrorMsg.textContent = "";
    cPassErrorMsg.textContent = "";
}

function displayErrors(errors) {
    errors.forEach(error => {
        if (error.includes("Name cannot be empty")) {
            nameErrorMsg.textContent = error;
        } else if (error.includes("Mobile length must be 10")) {
            mobileErrorMsg.textContent = error;
        } else if (error.includes("Password should be between 6 and 8 characters long") || error.includes("Passwords do not match")) {
            passErrorMsg.textContent = error;
        }
    });
}
