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
});

cancelBtn.addEventListener('click', () => {
    confirmAction.style.display = 'none';
});