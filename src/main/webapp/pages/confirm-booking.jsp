<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/6/2023
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Booking</title>
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/confirm-booking.css">
</head>
<body>
  <jsp:include page="../includes/nav.jsp"/>
  <div class="confirm__container">
    <h3>${cancel}</h3>
    <p>Booked by: ${confirmBooking.bookedBy}</p>
    <p>Booked for: ${confirmBooking.bookedFor}</p>
    <p>Booked Date: ${confirmBooking.bookingDate}</p>
    <p>Price: rs. ${confirmBooking.price}</p>

    <form action="confirm-booking" method="POST">
      <input type="hidden" name="timingId" value="${timingId}">
      <button type="submit" class="confirm">Confirm Booking</button>
    </form>

    <form action="cancel-booking" method="POST">
      <input type="hidden" name="bookingId" value="${confirmBooking.bookingID}">
      <button class="cancel">Cancel Booking</button>

    </form>
  </div>
  <jsp:include page="../includes/footer.jsp"/>
  <script src="../js/script.js"></script>
</body>
</html>
