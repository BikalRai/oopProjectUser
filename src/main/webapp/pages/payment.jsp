<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/7/2023
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eSewa Payment</title>
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/payment.css">
</head>
<body>
<jsp:include page="../includes/nav.jsp"/>
<h3></h3>

<div class="payment__container">
  <div class="payment__details">
    <p><span>Booking ID:</span> ${bookingDetails.bookingID}</p>
    <p><span>Date:</span> ${bookingDetails.bookingDate}</p>
    <p><span>Booked By:</span> ${bookingDetails.bookedBy}</p>
    <p><span>Sport:</span> ${bookingDetails.bookedFor}</p>
    <p><span>Start Time:</span> ${bookingDetails.bookingStart}</p>
    <p><span>End Time:</span> ${bookingDetails.bookingEnd}</p>
    <p><span>Price:</span> ${bookingDetails.price}</p>
  </div>
  <form action="online-payment" method="POST">
    <div class="id">
      <label for="esewaid">eSewa Id:</label>
      <input type="text" name="esewaid" id="esewaid" />
    </div>
    <div class="password">
      <label for="password">Password: </label>
      <input type="password" name="password" id="password" />
    </div>
    <div class="actions">
      <button class="btn login">LOGIN</button>
      <button class="btn cancel">CANCEL</button>
    </div>
  </form>
</div>

<jsp:include page="../includes/footer.jsp"/>
<script src="../js/script.js"></script>
</body>
</html>
