<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>	    
    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Scrolling Nav - Start Bootstrap Template</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/resources/css/styles.css" rel="stylesheet" />
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css">
    </head>
<body id="page-top">
<div class="wrapper">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container px-4">
                <a class="navbar-brand" href="#page-top" id="kwk-tit">김원경 무용단</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#portfolio">Portfolio</a></li>
                        <li class="nav-item"><a class="nav-link" href="#lesson">Lesson</a></li>
                        <li class="nav-item"><a class="nav-link" href="#community">Community</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-2" id="main-img-side-div">
              <div id="main-img-side"></div>
          </div>
		  <div class="col-sm-8" id="main-img-div">
              <div id="main-img">
                <img id="main2_jpg" src="<%=request.getContextPath() %>/resources/images/main0.jpg">
              </div>
          </div>
          <div class="col-sm-2" id="main-img-side-div">
              <div id="main-img-side"></div>
          </div>
        </div> <!-- /.row -->

        
    
      </div><!-- /.container-fluid -->
    </div>      
        
        <!-- Header-->
        <header class="bg-primary bg-gradient text-white">
            <div class="container px-4 text-center" id="header-tit">
                <h1 class="fw-bolder">김원경무용단 대전문화예술교육원</h1>
                <p class="lead" id="header-tit-2">한국무용의 중심으로 도약과 생동감 넘치는 김원경무용단!</p>
<!--                 <a class="btn btn-lg btn-light" href="#about">Start scrolling!</a> -->
            </div>
        </header>
        <!-- About section-->
        <section id="about">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>About this page</h2>
                        <p class="lead">This is a great place to talk about your webpage. This template is purposefully unstyled so you can use it as a boilerplate or starting point for you own landing page designs! This template features:</p>
                        <ul>
                            <li>Clickable nav links that smooth scroll to page sections</li>
                            <li>Responsive behavior when clicking nav links perfect for a one page website</li>
                            <li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the navbar</li>
                            <li>Minimal custom CSS so you are free to explore your own unique design options</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section-->
        <section class="bg-light" id="portfolio">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Portfolio</h2>
                        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut optio velit inventore, expedita quo laboriosam possimus ea consequatur vitae, doloribus consequuntur ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Contact section-->
        <section id="lesson">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Lesson</h2>
                        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero odio fugiat voluptatem dolor, provident officiis, id iusto! Obcaecati incidunt, qui nihil beatae magnam et repudiandae ipsa exercitationem, in, quo totam.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section-->
        <section class="bg-light" id="community">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Community</h2>
                        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut optio velit inventore, expedita quo laboriosam possimus ea consequatur vitae, doloribus consequuntur ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
</div>
<!-- ./wrapper -->
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
    </body>
</html>
