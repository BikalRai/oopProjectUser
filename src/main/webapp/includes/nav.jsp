
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<% request.setAttribute("activePage", "home"); %>
<!-- navbar start -->
<nav>
  <a href="#!">
    <img src="../images/logo.png" alt="" class="logo" alt="logo" />
  </a>
  <div class="nav__right">
    <ul class="nav__links" id="nav__links">
      <li class="nav__link active" data-page="home">
        <a href="nav?page=home">
          <i class="fa-solid fa-house"></i>
          <p>HOME</p>
        </a>
      </li>
      <li class="nav__link" data-page="about">
        <a href="nav?page=about">
          <i class="fa-solid fa-info"></i>
          <p>ABOUT</p>
        </a>
      </li>
      <li class="nav__link" data-page="book">
        <a href="nav?page=book">
          <i class="fa-solid fa-bookmark"></i>
          <p>BOOK NOW</p>
        </a>
      </li>
      <li class="nav__link" data-page="bookings">
        <a href="nav?page=bookings">
          <i class="fa-solid fa-book-open-reader"></i>
          <p>BOOKINGS</p>
        </a>
      </li>
      <li class="nav__link" data-page="setting">
        <a href="nav?page=settings">
          <i class="fa-solid fa-gear"></i>
          <p>PROFILE</p>
        </a>
      </li>
    </ul>
    <div class="details">
      <%
          if (session.getAttribute("username") != null) {

      %>
      <h3 style="min-width: fit-content">Hello, <%= session.getAttribute("username") %></h3>
        <a href="LogoutServlet">
          <button class="btn">LOGOUT</button>
        </a>
      <%
        } else {
      %>
        <a href="login?page=login">
          <button class="btn details__login">LOGIN</button>
        </a>

      <a href="register?page=reg">
        <button class="btn details__signup">SIGN UP</button>
      </a>
      <%
      }
        %>

      <!-- <p>Welcome, John</p>
      <button class="btn btn__logout">Logout</button>
    </div> -->
<%--      <a href="login?page=login">--%>
<%--        <button class="btn details__login">LOGIN</button>--%>
<%--      </a>--%>

<%--      <button class="btn details__signup">SIGN UP</button>--%>
    </div>
  </div>
</nav>

<!-- navbar end -->

<script src="https://kit.fontawesome.com/f8ae938eee.js"
        crossorigin="anonymous"
></script>

</body>
</html>
