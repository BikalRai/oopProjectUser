<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Now</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/modal.css">
    <link rel="stylesheet" href="../css/book.css">
</head>
<body>
<jsp:include page="../includes/nav.jsp" />
<div class="main__container">
    <div class="book-now">
        <div class="book-now-container">
            <div class="book-header">
                <a href="">
                    <button class="back btn">
                        <i class="fa-solid fa-arrow-left"></i>
                    </button>
                </a>

                <h1>Book Now</h1>
            </div>

            <form action="booking?page=createBooking" method="POST">
                <div class="date">
                    <label for="date">Pick Date and time: </label>
                    <input type="date" id="date" name="date" />
                </div>
                <div class="sport">
                    <label for="sport">Choose sport: </label>
                    <select name="sport" id="sport">
                        <c:forEach var="sport" items="${allSports}">
                        <option value="${sport.sportName}, ${sport.sportId}">${sport.sportName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <h3>Available Timings:</h3>
                    <div class="available__timings">
                        <select name="timings" id="timings">
                            <c:forEach var="timing" items="${allTimings}">

                                <c:if test="${timing.isBooked == 0}">
                                    <option value="${timing.startTime}, ${timing.endTime}, ${timing.timingID}">${timing.startTime} to ${timing.endTime}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn">Submit</button>
            </form>


        </div>
    </div>
</div>
<div class="modal close-modal">
    <i class="fa-solid fa-xmark close"></i>
    <h1>Error</h1>
    <h4>
        ${alreadyBooked}
    </h4>
    <button class="close-button">Try again</button>
</div>

<jsp:include page="../includes/footer.jsp"/>

<script
        src="https://kit.fontawesome.com/f8ae938eee.js"
        crossorigin="anonymous"
></script>

<script>
    const modalBtn = document.querySelector('.modal button');
    const modal = document.querySelector('.modal');
    const valid = ${bookValid};

    modalBtn.addEventListener('click', () => {
        modal.classList.add('close-modal');
    });


    if (valid === false) {
        modal.classList.remove('close-modal');
    }
</script>

<script src="../js/script.js"></script>
</body>
</html>
