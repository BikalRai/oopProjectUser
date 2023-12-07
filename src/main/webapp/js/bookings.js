const bookingBtns = document.querySelectorAll('.allbookings__booking-right form button');

bookingBtns.forEach(btn => {
    if (btn.hasAttribute('disabled') && btn.classList.contains('btn-pay')) {
        btn.classList.remove('btn');
        btn.classList.remove('btn-pay');
        btn.classList.add('disabled');
    } else {
        btn.classList.add('btn');
        btn.classList.add('btn-pay');
        btn.classList.remove('disabled');
    }

    if (btn.hasAttribute('disabled') && btn.classList.contains('btn-cash')) {
        btn.classList.remove('btn');
        btn.classList.remove('btn-cash');
        btn.classList.add('disabled');
    } else {
        btn.classList.add('btn');
        btn.classList.add('btn-cash');
        btn.classList.remove('disabled');
    }
})