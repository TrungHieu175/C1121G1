<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/21/2022
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Furahahahahah</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"
          type="text/css"/>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="http://localhost:8080/customers">
            <img src="image/693912.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Furamahahaha
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/customers?action=create">Create Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers?action=customer">Delete Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customers?action=customer">Update Customer</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- Masthead-->
    <div class="container position-relative" style="z-index : 1000 ;top:500px">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <div class="text-center text-white">
                    <!-- Page heading-->
                    <h1 class="mb-5">Search Customer</h1>
                    <form action="/customers?action=searchByName" method="get" class="form-subscribe" id="contactForm" data-sb-form-api-token="API_TOKEN">
                        <!-- Email address input-->
                        <div class="row">
                            <div class="col">
                                <input class="form-control form-control-lg" id="searchName" name="searchValue" type="text"
                                       placeholder="Search by Name"/>
                            </div>
                            <div class="col-auto">
                                <input type="text" value="searchId" name="action" hidden>
                                <button class="btn btn-primary btn-lg" id="submitButton"
                                        type="submit">
                                    Search
                                </button>
                            </div>
                        </div>
                        <div class="d-none" id="submitSuccessMessage1">
                            <div class="text-center mb-3">
                                <div class="fw-bolder">Form submission successful!</div>
                                <p>To activate this form, sign up at</p>
                                <a class="text-white"
                                   href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                            </div>
                        </div>
                        <div class="d-none" id="submitErrorMessage2">
                            <div class="text-center text-danger mb-3">Error sending message!</div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active" >
                <img src="image/967115.jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/954509.jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/940164.jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (2).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (5).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (6).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (9).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (11).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (12).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (17).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (32).jpg" class="d-block w-100 h-50" alt="...">
            </div>
            <div class="carousel-item">
                <img src="image/Gearvn_Kimetsu no Yaiba_ (33).jpg" class="d-block w-100 h-50" alt="...">
            </div>

        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
<!-- Icons Grid-->
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="bi bi-person-plus m-auto text-primary"></i></div>
                    <h3><a href="/customers?action=create">Create Customer</a></h3>
                    <p class="lead mb-0">Tạo mới khách hàng ở đây!</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="bi bi-person-lines-fill m-auto text-primary"></i></div>
                    <h3><a href="/customers">List Customer</a></h3>
                    <p class="lead mb-0">Xem danh sách khách hàng ở đây!</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="bi bi-trash m-auto text-primary"></i></div>
                    <h3><a href="/customers?action=delete">Delete Customer</a></h3>
                    <p class="lead mb-0">Xóa khách hàng ở đây!</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Image Showcases-->
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row g-0">
            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('image/693912.png')"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Fully Responsive Design</h2>
                <p class="lead mb-0">When you use a theme created by Start Bootstrap, you know that the theme will look
                    great on any device, whether it's a phone, tablet, or desktop the page will behave responsively!</p>
            </div>
        </div>
        <div class="row g-0">
            <div class="col-lg-6 text-white showcase-img"
                 style="background-image: url('image/710996.jpg')"></div>
            <div class="col-lg-6 my-auto showcase-text">
                <h2>Updated For Bootstrap 5</h2>
                <p class="lead mb-0">Newly improved, and full of great utility classes, Bootstrap 5 is leading the way
                    in mobile responsive web development! All of the themes on Start Bootstrap are now using Bootstrap
                    5!</p>
            </div>
        </div>
        <div class="row g-0">
            <div class="col-lg-6 order-lg-2 text-white showcase-img"
                 style="background-image: url('image/738019.jpg')"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Easy to Use & Customize</h2>
                <p class="lead mb-0">Landing Page is just HTML and CSS with a splash of SCSS for users who demand some
                    deeper customization options. Out of the box, just add your content and images, and your new landing
                    page will be ready to go!</p>
            </div>
        </div>
    </div>
</section>
<!-- Testimonials-->
<section class="testimonials text-center bg-light">
    <div class="container">
        <h2 class="mb-5">What people are saying...</h2>
        <div class="row">
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="image/887461.png" alt="..."/>
                    <h5>Margaret E.</h5>
                    <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="image/872893.jpg" alt="..."/>
                    <h5>Fred S.</h5>
                    <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super
                        nice landing pages."</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="image/940164.jpg" alt="..."/>
                    <h5>Sarah W.</h5>
                    <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to
                        us!"</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Call to Action-->
<section class="call-to-action text-white text-center" id="signup">
    <div class="container position-relative">
        <div class="row justify-content-center">
            <div class="col-xl-6">
                <h2 class="mb-4">Search By ID</h2>
                <!-- Signup form-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form action="/customers?action=searchById" method="get" class="form-subscribe" id="contactFormFooter" data-sb-form-api-token="API_TOKEN">
                    <!-- Email address input-->
                    <div class="row">
                        <div class="col">
                            <input class="form-control form-control-lg" id="searchById" name="searchValue" type="text"
                                   placeholder="Search by ID" data-sb-validations="required,email"/>
                            <div class="invalid-feedback text-white" data-sb-feedback="emailAddressBelow:required">Email
                                Address is required.
                            </div>
                            <div class="invalid-feedback text-white" data-sb-feedback="emailAddressBelow:email">Email
                                Address Email is not valid.
                            </div>
                        </div>
                        <div class="col-auto">
                            <input type="text" id="action" name="action" value="searchById" hidden>
                            <button class="btn btn-primary btn-lg" id="submitButton2" type="submit">Search
                            </button>
                        </div>
                    </div>
                    <!-- Submit success message-->
                    <!---->
                    <!-- This is what your users will see when the form-->
                    <!-- has successfully submitted-->
                    <div class="d-none" id="submitSuccessMessage">
                        <div class="text-center mb-3">
                            <div class="fw-bolder">Form submission successful!</div>
                            <p>To activate this form, sign up at</p>
                            <a class="text-white" href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                        </div>
                    </div>
                    <!-- Submit error message-->
                    <!---->
                    <!-- This is what your users will see when there is-->
                    <!-- an error submitting the form-->
                    <div class="d-none" id="submitErrorMessage">
                        <div class="text-center text-danger mb-3">Error sending message!</div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item"><a href="#!">About</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="#!">Contact</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2021. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item me-4">
                        <a href="#!"><i class="bi-facebook fs-3"></i></a>
                    </li>
                    <li class="list-inline-item me-4">
                        <a href="#!"><i class="bi-twitter fs-3"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#!"><i class="bi-instagram fs-3"></i></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>

</body>
</html>
