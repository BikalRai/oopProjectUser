<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Register</title>
  <link rel="stylesheet" href="../css/style.css" />
  <link rel="stylesheet" href="../css/modal.css">
  <link rel="stylesheet" href="../css/register.css" />
</head>
<body>
<div class="register">
  <div class="register__form">
    <a href="">
      <button class="back btn"><i class="fa-solid fa-arrow-left"></i></button>
    </a>
    <form action="register?page=in" method="POST" id="registerForm">
      <h1>SIGN UP</h1>
      <div class="fullname">
        <label for="fullname">Full Name</label>
        <input type="text" name="fullname" placeholder="Enter Full Name" id="fullname"/>
        <p style="color: #ea3024;" id="nameErrorMsg"></p>
      </div>
      <div class="mobile">
        <label for="mobile">Mobile</label>
        <input type="text" name="mobile" placeholder="Enter Mobile" id="mobile"/>
        <p style="color: #ea3024;" id="mobileErrorMsg"></p>
      </div>
      <div class="password">
        <label for="password">Password</label>
        <input type="password" name="password" placeholder="Enter Password" id="password"/>
        <p style="color: #ea3024;" id="passErrorMsg"></p>
      </div>
      <div class="cpassword">
        <label for="cpassword">Confirm Password</label>
        <input type="password" name="cpassword" placeholder="Confirm Password" id="cpassword"/>
        <p style="color: #ea3024;" id="cPassErrorMsg"></p>
      </div>
      <div class="actions">
        <button type="submit" class="btn">SIGN UP</button>
        <p>Already have an account? <a href="register?page=login">LOGIN</a></p>
      </div>

    </form>

  </div>
<%--  <div class="register__img">--%>
<%--    <img src="../images/register.jpeg" alt="register image" />--%>
<%--  </div>--%>
</div>
<div class="modal close-modal">
  <i class="fa-solid fa-xmark close"></i>
  <h1>Error</h1>
  <h4>
    ${registerErrorMobile}. Use another mobile number
    to register.
  </h4>
  <button class="close-button">Try again</button>
</div>
<script
        src="https://kit.fontawesome.com/f8ae938eee.js"
        crossorigin="anonymous"
></script>
<script src="../js/validate.js"></script>

<script>
  const modalBtn = document.querySelector('.modal button');
  const modal = document.querySelector('.modal');
  const valid = ${regValid};

  modalBtn.addEventListener('click', () => {
    modal.classList.add('close-modal');
  });


  if (valid === false) {
    modal.classList.remove('close-modal');
  }


</script>
</body>
</html>
