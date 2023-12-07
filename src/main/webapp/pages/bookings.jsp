<%@ page import="java.util.List" %>
<%@ page import="model.UserBookingsModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="query.UserBookingsQuery" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookings</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/bookings.css">
</head>
<body>
<%--<%--%>
<%--    HttpSession sessionCheck = request.getSession(false);--%>
<%--    if (sessionCheck != null) {--%>

<%--    }--%>
<%--RequestDispatcher requestDispatcher=request.getRequestDispatcher("");--%>
<%--requestDispatcher.forward(request,response);--%>
<%--%>--%>
<jsp:include page="../includes/nav.jsp"/>
<div class="allbookings">
    <h1>YOUR BOOKINGS</h1>
    <h3>Total Bookings: ${userTotalBookings}</h3>
        <h3>${paymentMsg}</h3>

    <%
        if (session.getAttribute("username") != null) {

    %>

<%--    <c:forEach var="booking" items="${allBookings}">--%>

    <c:forEach var="booking" items="${userBookings}">
    <div class="allbookings__booking">
        <h3>Booking</h3>
        <div class="allboookings_booking-content">
            <div class="allbookings__booking-left">
                <p class="booked__sport">
                    <span>Booked For: </span>
                    ${booking.bookedFor}
                </p>
                <p class="booked__date">
                    <span>Booked Date: </span>
                        ${booking.bookingDate}
                </p>
                <p class="booked__time">
                    <span>Time: </span>
                        ${booking.bookStartTime}
                </p>

            </div>
            <div class="allbookings__booking-right">

                <form action="booking-actions" method="POST">
                    <c:if test="${booking.payment eq 'pending'}">
                        <button class="bookings-btn pay-esewa" value="esewa, ${booking.bookingID}, ${booking.bookedById}" name="payment-method">eSewa</button>
                        <button class="bookings-btn pay-cash" value="cash, ${booking.bookingID}, ${booking.bookedById}" name="payment-method">CASH</button>
                    </c:if>
                    <button class="bookings-btn delete-btn" value="delete, ${booking.bookingID}, ${booking.bookedById}" name="payment-method">CANCEL</button>
                </form>
            </div>
        </div>
    </div>
    </c:forEach>
<%--    </c:forEach>--%>
   <%
        } else {
   %>
        <h1>You have to be logged in to view this page</h1>
    <%
        }
    %>

</div>

<jsp:include page="../includes/footer.jsp"/>
<script src="../js/script.js"></script>
<%--<script src="../js/bookings.js"></script>--%>
</body>
</html>


