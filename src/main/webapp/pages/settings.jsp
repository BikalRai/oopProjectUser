
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="../css/profile.css">
</head>
<body>
  <jsp:include page="../includes/nav.jsp" />
  <div class="body__overlay">
      <%
          if (session.getAttribute("username") != null) {
      %>
      <form action="profile" name="profile__form" class="profile__form" method="POST">
          <h1>Your Profile</h1>
          <div class="form__field">
              <div class="form__field-heading">
                  <label for="fullname">Full Name: </label>
                  <button>Done</button>
              </div>
              <input
                      type="text"
                      name="fullname"
                      id="fullname"
                      value="${loggedInUser.fullName}"
                      readonly
              />
          </div>
          <div class="form__field">
              <div class="form__field-heading">
                  <label for="mobile">Mobile Number: </label>
                  <button>Done</button>
              </div>

              <input
                      type="text"
                      name="mobile"
                      id="mobile"
                      value="${loggedInUser.mobile}"
                      readonly
              />
          </div>
          <div class="form__field">
              <div class="form__field-heading">
                  <label for="bookings">Total Bookings: </label>
              </div>

              <input type="text" name="bookings" id="bookings" value="${loggedInUser.bookings}" readonly />
          </div>
          <div class="form__action">
              <button class="btn-update update">Update</button>
          </div>
          <h3>Note: Click the fields to edit</h3>
          <div class="confirm">
              <h1>Do you confirm these changes?</h1>
              <div class="confirm__actions">
                  <button type="submit" class="btn-update confirm-update">CONFIRM</button>
                  <button class="btn-cancel cancel">CANCEL</button>
              </div>
          </div>
      </form>

      <%
          } else {
      %>
      <h1 class="error-msg">You must be logged in...</h1>
      <%
          }
      %>
  </div>

  <div class="popup">
      <p></p>
  </div>
  <jsp:include page="../includes/footer.jsp" />
<%--  <script src="../js/profile.js"></script>--%>
  <script>
      const profileForm = document.forms['profile__form'];
      const popup = document.querySelector('.popup');
      const popupMsg = popup.querySelector('p');
      const confirmAction = profileForm.querySelector('.confirm');
      const updateBtn = profileForm.querySelector('.update');
      const cancelBtn = profileForm.querySelector('.cancel');
      const confirmBtn = profileForm.querySelector('.confirm-update');
      let fieldDoneBtn;
      let message;

      profileForm.addEventListener('click', function (e) {
          e.preventDefault();
          const fieldEl = e.target;

          if (
              fieldEl.tagName === 'INPUT' &&
              fieldEl.hasAttribute('readonly') &&
              fieldEl.id !== 'bookings'
          ) {
              fieldDoneBtn = fieldEl.parentNode.firstElementChild.lastElementChild;
              enableEditing(fieldEl, fieldDoneBtn);
          }

          if (
              fieldEl.tagName === 'INPUT' &&
              fieldEl.hasAttribute('readonly') &&
              fieldEl.id === 'bookings'
          ) {
              message = 'This field cannot be edited...';
              popupMsg.innerText = message;
              popup.style.display = 'initial';

              setTimeout(() => {
                  popup.style.display = 'none';
              }, 1000);
          }

          if (fieldEl.tagName === 'BUTTON') {
              const inputField = fieldEl.closest('.form__field').querySelector('input');
              disableEditing(inputField);
          }
      });

      const enableEditing = (fieldEl, fieldDoneBtn) => {
          fieldEl.removeAttribute('readonly', 'readonly');
          fieldDoneBtn.style.display = 'initial';
      };

      const disableEditing = (fieldDoneBtnInput) => {
          fieldDoneBtnInput.setAttribute('readonly', 'readonly');
          const fieldDoneBtn =
              fieldDoneBtnInput.parentNode.firstElementChild.lastElementChild;
          fieldDoneBtn.style.display = 'none';
      };

      updateBtn.addEventListener('click', () => {
          confirmAction.style.display = 'initial';
          console.log("logging update")
      });

      cancelBtn.addEventListener('click', () => {
          confirmAction.style.display = 'none';
      });
  </script>
</body>
</html>
