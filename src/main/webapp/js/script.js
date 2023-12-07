const navBar = document.getElementById('nav__links');
const allLinks = navBar.querySelectorAll('.nav__link');
const allSlideContent = document.querySelectorAll(".slider__content");
const slideBtns = document.querySelectorAll(".slide__btns button i");
const scrollBtnTop = document.querySelector(".btn__toTop");
// let currentPos = 0;
let clicks = 0;

navBar.addEventListener('click', function (e) {
    if (e.target.textContent !== null) {
        const selectionText = e.target.textContent;

        allLinks.forEach((link) => {
            link.classList.remove('active');
        });

        allLinks.forEach((link) => {
            const linkText = link.firstElementChild.lastElementChild.textContent;
            if (linkText === selectionText) {
                link.classList.add('active');
            }
        });
    }
});

// navlinks change active class
// links.forEach((link) => {
//     let activePage = link.getAttribute("data-page");
//     if (activePage === `<%= request.getAttribute("activePage") %>`) {
//         link.classList.add("active");
//     }
//
//     link.addEventListener("click", function () {
//         //remove the active link first
//         links.forEach((link) => {
//             link.classList.remove("active");
//         });
//
//         //add active class
//         link.classList.add("active");
//     });
// });

// slider
slideBtns.forEach((slideBtn) => {
    if (slideBtn.className === "fa-solid fa-arrow-left") {
        slideBtn.addEventListener("click", () => {
            if (clicks === 0) {
                slideBtn.parentElement.setAttribute("disabled", "disabled");
                return;
            } else {
                clicks -= 1;
                allSlideContent.forEach((content) => {
                    {
                        let currentTransform = getTransformValue(content);
                        let newTransform = currentTransform + 375; // increment
                        content.style.transform = `translateX(${newTransform}px)`;
                        slideBtns[1].parentElement.removeAttribute("disabled");
                    }
                });
            }
        });
    }
    if (slideBtn.className === "fa-solid fa-arrow-right") {
        slideBtn.addEventListener("click", () => {
            if (clicks === allSlideContent.length) {
                slideBtn.parentElement.setAttribute("disabled", "disabled");
                return;
            } else {
                clicks += 1;
                allSlideContent.forEach((content) => {
                    let currentTransform = getTransformValue(content);
                    let newTransform = currentTransform - 375; // decrement
                    content.style.transform = `translateX(${newTransform}px)`;
                    slideBtns[0].parentElement.removeAttribute("disabled");
                });
            }
        });
    }
});

// slider helper function
function getTransformValue(element) {
    const transform = element.style.transform;
    if (transform) {
        const match = transform.match(/translateX\((-?\d+)px\)/);
        if (match && match[1]) {
            return parseInt(match[1], 10);
        }
    }
    return 0;
}

// faq accordion
// const faqContainer = document.querySelector(".faq");
const faqContainer = document.getElementById('faq');

faqContainer.addEventListener("click", function (e) {
    if (e.target.classList.contains("faq__item-top")) {
        const selection = e.target;
        const icon = selection.querySelector("i");
        const ans = selection.nextElementSibling;

        const allFaq = faqContainer.querySelectorAll(".faq__item");

        allFaq.forEach((item) => {
            const i = item.querySelector("i");
            const q = item.querySelector(".faq__item-bottom");

            if (item !== selection) {
                q.classList.add("closed");
                i.classList.remove("fa-minu");
                i.classList.add("fa-plus");
            }
        });

        if (ans.classList.contains("closed")) {
            ans.classList.remove("closed");
            icon.classList.remove("fa-plus");
            icon.classList.add("fa-minus");
        } else {
            ans.classList.add("closed");
            icon.classList.remove("fa-minus");
            icon.classList.add("fa-plus");
        }
    } else {
        return;
    }
});

// scroll to top event
scrollBtnTop.style.display = "none";
window.addEventListener("scroll", function (e) {
    let scrollValue = this.scrollY;

    if (scrollValue <= 250 || scrollValue === 0) {
        scrollBtnTop.style.display = "none";
    } else {
        scrollBtnTop.style.display = "flex";
    }
});

scrollBtnTop.addEventListener("click", function () {
    window.scrollTo(0, 0);
});

// const currentDate = document.querySelector('.current-date');
// const daysTag = document.querySelector('.days');
// const prevNextIcon = document.querySelectorAll('.icons span');

// let date = new Date();
// let currYear = date.getFullYear();
// let currMonth = date.getMonth();

// const months = [
//   'January',
//   'February',
//   'March',
//   'April',
//   'May',
//   'June',
//   'July',
//   'August',
//   'September',
//   'October',
//   'November',
//   'December',
// ];

// const renderCalendar = () => {
//   let firstDayOfMonth = new Date(currYear, currMonth, 1).getDay(); // getting first day of month
//   let lastDateOfMonth = new Date(currYear, currMonth + 1, 0).getDate(); // getting last date of month
//   let lastDayOfMonth = new Date(currYear, currMonth, lastDateOfMonth).getDay(); // getting last day of month
//   let lastDateOfLastMonth = new Date(currYear, currMonth, 0).getDate(); // getting last date of prev month

//   let liTag = '';

//   for (let i = firstDayOfMonth; i > 0; i--) {
//     //creating li of previous month
//     liTag += `<li class='inactive'>${lastDateOfLastMonth - i + 1}</li>`;
//   }

//   for (let i = 1; i <= lastDateOfMonth; i++) {
//     // creating li of all days of the current month

//     let isToday =
//       i === date.getDate() &&
//       currMonth === new Date().getMonth() &&
//       currYear === new Date().getFullYear()
//         ? 'active'
//         : '';
//     liTag += `<li class="${isToday}">${i}</li>`;
//   }

//   for (let i = lastDayOfMonth; i < 6; i++) {
//     // creating li of next month first days
//     liTag += `<li class='inactive'>${i - lastDayOfMonth + 1}</li>`;
//   }

//   currentDate.innerText = `${months[currMonth]} ${currYear}`;
//   daysTag.innerHTML = liTag;
// };

// renderCalendar();

// prevNextIcon.forEach((icon) => {
//   icon.addEventListener('click', () => {
//     currMonth = icon.id === 'prev' ? currMonth - 1 : currMonth + 1;

//     if (currMonth < 0 || currMonth > 11) {
//       date = new Date(currYear, currMonth);
//       currYear = date.getFullYear();
//       currMonth = date.getMonth();
//     } else {
//       date = new Date();
//     }
//     renderCalendar();
//   });
// });

const allTimings = document.querySelectorAll('.timing');
allTimings.forEach((timing) => {
    timing.addEventListener('click', function (e) {
        allTimings.forEach((time) => {
            time.classList.remove('selected');
        });

        timing.classList.add('selected');
    });
});


