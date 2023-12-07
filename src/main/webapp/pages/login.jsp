<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/1/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="../css/modal.css">
    <link rel="stylesheet" href="../css/login.css" />
</head>
<body>
<div class="login">
<%--    <div class="login__img">--%>
<%--        <img src="../images/login.jpeg" alt="login image" />--%>
<%--    </div>--%>

    <div class="login__form">
        <a href="login?page=index" class="back__anchor">
            <button class="back btn"><i class="fa-solid fa-arrow-left"></i></button>
        </a>
        <p>${userError}</p>
        <form action="login?page=home" method="POST">

            <img
                    src="../images/logo.png" alt="logo"
                    class="logo"
            />
            <h1>LOGIN</h1>
            <div class="mobile">
                <label for="mobile">Mobile</label>
                <input
                        type="text"
                        name="mobile"
                        placeholder="Enter Mobile"
                        id="mobile"
                />
            </div>
            <div class="password">
                <label for="password">Password</label>
                <input
                        type="password"
                        name="password"
                        placeholder="Enter Password"
                        id="password"
                />
            </div>
            <div class="actions">
                <a href="#!">Forgot Password?</a>
                <button type="submit" class="btn">LOGIN</button>
                <p>Don't have an account? <a href="login?page=register">SIGN UP</a></p>
            </div>
        </form>
    </div>

</div>
<div class="modal close-modal">
    <i class="fa-solid fa-check success"></i>
    <h1>Success</h1>
    <h4>
        Successfully registered account!!
    </h4>
<%--    <button class="success-button">Confirm</button>--%>
</div>
<script
        src="https://kit.fontawesome.com/f8ae938eee.js"
        crossorigin="anonymous"
></script>

<script>
    const modalBtn = document.querySelector('.modal button');
    const modal = document.querySelector('.modal');
    const valid = ${regValid};

    if (valid) {
        modal.classList.remove('close-modal');

        setTimeout(() => {
            modal.classList.add('close-modal');
        }, 2000);
    }

</script>
</body>
</html>
