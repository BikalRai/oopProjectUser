<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/1/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Merlion Gymnasium</title>
<%--    <link rel="stylesheet" href="../css/style.css" />--%>
</head>
<body>
<header id="header">
    <jsp:include page="../includes/nav.jsp"/>

    <!-- hero start -->
    <div class="hero">
        <div class="overlay">
            <div class="hero__intro">
                <div class="hero__headings">
                    <h1>GET CLOSER TO</h1>
                    <h1>YOUR GOALS</h1>
                </div>
                <div class="hero__desc">
                    <p>
                        Merlion Gymnasium offers you venue for serveral sports,
                        enjoyment to training.
                    </p>
                    <p>You can get closer to your goals here.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- hero end -->
</header>
<main id="main">
    <!-- feature starts -->
    <div class="services">
        <h1>OUR SERVICES</h1>
        <!-- slider start -->
        <div class="slider">
            <div class="slider__content">
                <img src="../images/futsal.jpg" alt="Pic of futsal ball and goal post"/>
                <button class="btn slider__btn">Futsal</button>
            </div>
            <div class="slider__content">
                <img src="../images/basketball.jpg" alt="Basketball" />
                <button class="btn slider__btn">Basketball</button>
            </div>
            <div class="slider__content">
                <img src="../images/volleyball.jpg" alt="Volleyball" />
                <button class="btn slider__btn">Volleyball</button>
            </div>
            <div class="slider__content">
                <img src="../images/badminton.jpg" alt="Badminton" />
                <button class="btn slider__btn">Badminton</button>
            </div>
            <div class="slider__content">
                <img src="../images/train.jpg" alt="Training in progress" />
                <a href="nav?page=training">
                    <button class="btn slider__btn">Trainings</button>
                </a>
            </div>
        </div>
        <div class="slide__btns">
            <button class="" disabled="disabled">
                <i class="fa-solid fa-arrow-left"></i>
            </button>
            <button class="">
                <i class="fa-solid fa-arrow-right"></i>
            </button>
        </div>
        <!-- slider ends -->
    </div>
    <!-- feature ends -->

    <!-- news & events start -->
    <div class="news">
        <h1>NEWS & EVENTS</h1>
        <div class="news__contents">
            <div class="news__content">
                <div class="news__content-top">
                    <img
                            src="https://images.unsplash.com/photo-1695891957303-b65ece769f11?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80"
                            alt=""
                    />
                </div>
                <div class="news__content-bottom">
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Explicabo repudiandae vitae quisquam minus magnam corrupti sequi
                        quas autem molestiae iste aperiam consequatur consequuntur
                        incidunt placeat, nam quaerat, tempore dolor, adipisci odit!
                        Fuga aperiam quo quod recusandae est labore reprehenderit, animi
                        non ipsam adipisci sed architecto doloribus suscipit corrupti
                        quam nobis fugit et itaque possimus optio illum tenetur alias?
                        Sint officiis at non ratione voluptas quibusdam accusantium
                        laboriosam enim quo ipsa? Dolorum recusandae provident incidunt
                        facilis dolore, voluptatibus veritatis. Fugit quo in rerum nulla
                        deserunt rem inventore vitae accusamus perspiciatis tempore!
                        Repellat voluptatem dolorem saepe, dolorum quae nostrum minima
                        cumque in.
                    </p>
                </div>
                <button class="btn">
                    Read More
                    <span>
                <i class="fa-solid fa-arrow-right-long"></i>
              </span>
                </button>
            </div>
            <div class="news__content">
                <div class="news__content-top">
                    <img
                            src="https://images.unsplash.com/photo-1695891957303-b65ece769f11?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80"
                            alt=""
                    />
                </div>
                <div class="news__content-bottom">
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Explicabo repudiandae vitae quisquam minus magnam corrupti sequi
                        quas autem molestiae iste aperiam consequatur consequuntur
                        incidunt placeat, nam quaerat, tempore dolor, adipisci odit!
                        Fuga aperiam quo quod recusandae est labore reprehenderit, animi
                        non ipsam adipisci sed architecto doloribus suscipit corrupti
                        quam nobis fugit et itaque possimus optio illum tenetur alias?
                        Sint officiis at non ratione voluptas quibusdam accusantium
                        laboriosam enim quo ipsa? Dolorum recusandae provident incidunt
                        facilis dolore, voluptatibus veritatis. Fugit quo in rerum nulla
                        deserunt rem inventore vitae accusamus perspiciatis tempore!
                        Repellat voluptatem dolorem saepe, dolorum quae nostrum minima
                        cumque in.
                    </p>
                </div>
                <button class="btn">
                    Read More
                    <span>
                <i class="fa-solid fa-arrow-right-long"></i>
              </span>
                </button>
            </div>
            <div class="news__content">
                <div class="news__content-top">
                    <img
                            src="https://images.unsplash.com/photo-1695891957303-b65ece769f11?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2071&q=80"
                            alt=""
                    />
                </div>
                <div class="news__content-bottom">
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Explicabo repudiandae vitae quisquam minus magnam corrupti sequi
                        quas autem molestiae iste aperiam consequatur consequuntur
                        incidunt placeat, nam quaerat, tempore dolor, adipisci odit!
                        Fuga aperiam quo quod recusandae est labore reprehenderit, animi
                        non ipsam adipisci sed architecto doloribus suscipit corrupti
                        quam nobis fugit et itaque possimus optio illum tenetur alias?
                        Sint officiis at non ratione voluptas quibusdam accusantium
                        laboriosam enim quo ipsa? Dolorum recusandae provident incidunt
                        facilis dolore, voluptatibus veritatis. Fugit quo in rerum nulla
                        deserunt rem inventore vitae accusamus perspiciatis tempore!
                        Repellat voluptatem dolorem saepe, dolorum quae nostrum minima
                        cumque in.
                    </p>
                </div>
                <button class="btn">
                    Read More
                    <span>
                <i class="fa-solid fa-arrow-right-long"></i>
              </span>
                </button>
            </div>
        </div>
        <div class="more__news">
            <a href="#!" class="btn"
            >SEE MORE NEWS & EVENTS
                <span
                ><i
                        class="fa-solid fa-arrow-right-long"
                        style="color: red"
                ></i></span
                ></a>
        </div>
    </div>
    <!-- news & events end -->

    <!-- book content start -->
    <div class="book__container">
        <div class="book">
            <div class="book__item">
                <div class="book__item-img-futsal">
                </div>
                <div class="book__item-details">
                    <h1>BOOK FUTSAL</h1>
                    <p>
                        Book a futsal court. Rent a continuous hall time for your
                        football team, or an hour for the company kick-off.
                    </p>
                    <a href="nav?page=book">
                        <button class="btn">
                            BOOK NOW
                            <span>
                          <i class="fa-solid fa-arrow-right-long"></i>
                        </span>
                        </button>
                    </a>

                </div>
            </div>
            <div class="book__item">
                <div class="book__item-details">
                    <h1>BOOK BASKETBALL</h1>
                    <p>
                        Book a basketball court. Rent a continuous hall time for your
                        football team, or an hour for the company kick-off, or even for trainings.
                    </p>
                    <a href="nav?page=book">
                        <button class="btn">
                            BOOK NOW
                            <span>
                          <i class="fa-solid fa-arrow-right-long"></i>
                        </span>
                        </button>
                    </a>
                </div>
                <div class="book__item-img-basketball"></div>
            </div>
        </div>
    </div>
    <!-- book content end -->

    <!-- faq start -->
    <div class="faq__container">
        <h1>FAQ</h1>
        <div class="faq" id="faq">
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>How do i book?</h4>
                    <span class="open">
                <i class="fa-solid fa-minus"></i>
              </span>
                </div>
                <div class="faq__item-bottom">
                    <p>
                        You can easily book navigation to the book page, or you can click
                        one of the button links that says book now
                    </p>
                </div>
            </div>
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>How do i cancel my booking?</h4>
                    <span class="open">
                <i class="fa-solid fa-plus"></i>
              </span>
                </div>
                <div class="faq__item-bottom closed">
                    <p>
                        You can easily cancel your booking by going to the bookings page and from there you can cancel the booking that you want to cancel.
                    </p>
                </div>
            </div>
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>What are the minimum charges that are charged for late cancellation?</h4>
                    <span class="open">
                <i class="fa-solid fa-plus"></i>
              </span>
                </div>
                <div class="faq__item-bottom closed">
                    <p>
                        There has to some penalty for late cancellation as it will affect the organisation in the long run, therefore the minimum charge will be that you have to pay 40% of the booking charge.
                    </p>
                </div>
            </div>
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>What are we required to bring?</h4>
                    <span class="open">
                <i class="fa-solid fa-plus"></i>
              </span>
                </div>
                <div class="faq__item-bottom closed">
                    <p>
                        You just have to come with your outfit for playing the sport, all other equipments will be provided by us.
                    </p>
                </div>
            </div>
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>How does the cash payment differ from the online payment?</h4>
                    <span class="open">
                <i class="fa-solid fa-plus"></i>
              </span>
                </div>
                <div class="faq__item-bottom closed">
                    <p>
                        Cash payment will can be done after playing the game, or anytime before starting the game.
                    </p>
                </div>
            </div>
            <div class="faq__item">
                <div class="faq__item-top">
                    <h4>Are the any penalties for cancelling booking at last minute who have decided to use cash as payment?</h4>
                    <span class="open">
                <i class="fa-solid fa-plus"></i>
              </span>
                </div>
                <div class="faq__item-bottom closed">
                    <p>
                        There are no penalties, but then your priority will be lessen and fall down the pecking order against other consumers, where we are striving to provide a fair and appropriate service for all.
                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- faq end -->

    <!-- contact us start -->

    <div class="contact">
        <div class="contact__form">
            <form action="#!" name="contactForm">
                <h2>CONTACT US</h2>
                <input type="text" name="fullname" placeholder="Fullname" />
                <input type="email" name="email" placeholder="Email" />
                <textarea
                        name="contactMsg"
                        id="contactMsg"
                        cols=""
                        rows="8"
                        placeholder="Your Message Here..."
                ></textarea>

                <button class="btn">SEND</button>
            </form>
        </div>
        <div class="contact__map">
            <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14136.959891091006!2d85.304718!3d27.64804625!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb178514f97739%3A0xeb1f6e5c822e62ab!2sBhaisepati%2C%20Karyabinayak!5e0!3m2!1sen!2snp!4v1698652104108!5m2!1sen!2snp"
                    width="100%"
                    height="450"
                    style="border: 0"
                    allowfullscreen=""
                    loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade"
            ></iframe>
        </div>
    </div>

    <!-- contact us end -->
</main>

<jsp:include page="../includes/footer.jsp"/>

<!-- fixed button scroll top -->
<div class="btn__toTop">
    <i class="fa-solid fa-minus"></i>
    <i class="fa-solid fa-arrow-up"></i>
</div>

<script src="../js/script.js"></script>
</body>
</html>
