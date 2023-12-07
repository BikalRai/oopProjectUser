<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Training</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/training.css">
</head>
<body>
<jsp:include page="../includes/nav.jsp"/>
    <div class="training__container">
        <%
            if (session.getAttribute("username") != null) {
        %>
            <div class="training__hero">
                <div class="training__hero-overlay">
                    <h1>TRAINING</h1>
                </div>
            </div>
            <div class="training">
                <p>What better way than to have a designated area for training where you can book for training or booking training session with our trainers. We are looking to provide more trainings in the future and welcome yoo to be a member of the growing community.</p>
                <div class="form__container">
                    <h1 class="form__heading">BOOK A TRAINING</h1>
                    <form action="training" method="post" name="training__form">
                        <div class="form__field">
                            <label for="date">Date: </label>
                            <input type="date" name="date" id="date">
                        </div>
                        <div class="form__field">
                            <label for="time">Time: </label>
                            <select name="time" id="time">
                                <c:forEach var="timing" items="${allTiming}">
                                    <option value="${timing.startTime}, ${timing.endTime}, ${timing.timingID}">${timing.startTime} to ${timing.endTime}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form__field">
                            <label for="training-type">Training For: </label>
                            <select name="training-type" id="training-type">
                                <c:forEach var="sport" items="${allSports}">
                                    <option value="${sport.sportName}, ${sport.sportId}">${sport.sportName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form__field">
                            <label for="trainer">Trainer</label>
                            <select name="trainer" id="trainer">
                                <option value="john">John Doe</option>
                                <option value="ngurung">Nirmal Gurung</option>
                                <option value="hkhadka">Hari Khadka</option>
                                <option value="ttaylor">Tiffany Taylor</option>
                            </select>
                        </div>
                        <button>SUBMIT</button>
                    </form>
                </div>

            </div>
       <% } else { %>
        <h1 style="height: 40vh; background-color: #8c7f7f; width: 100%; color: #fff; text-align: center">You Must Be Logged In</h1>
        <% }%>
    </div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
