<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">WORDS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar ml-auto ">
        
        <li class="nav-item ">
           <a class="nav-link active" href="showLogin">Войти</a><br>
        </li>
        <li class="nav-item ">
           <a class="nav-link active" href="showRegistration">Регистрация</a><br>
        </li>
        
      </ul>
    </div>
  </div>
</nav><br><br><br><br>

<header>
    <div class="container">
    <div class="row">
    <c:if test="${info ne null}">
    <div class="alert alert-info alert-dismissible fade show " role="alert">
  ${info}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
    
  </c:if>
   </div>
    </div> 
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      
    <ol class="carousel-indicators">
        
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
      
    <div class="carousel-inner" role="listbox">
      <!-- Slide One - Set the background image for this slide in the line below -->
      <div class="carousel-item active" style="background-image: url('https://source.unsplash.com/LAaSoL0LrYs/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Самоучитель "Words"</h2>
          <p class="lead">Вписывайте слова!</p>
        </div>
      </div>
      <!-- Slide Two - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/bF2vsubyHcQ/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Самоучитель "Words"</h2>
          <p class="lead">Запоминайте слова!</p>
        </div>
      </div>
      <!-- Slide Three - Set the background image for this slide in the line below -->
      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/szFUQoyvrxM/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Самоучитель "Words"</h2>
          <p class="lead">Гордитесь своим результатом! </p>
        </div>
      </div>
    </div>
      
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
  </div>
</header>

<!-- Page Content -->
<section class="py-5">
    
  <div class="container">
      <div class="row">
          <div class="col-md-8">
    <h1 class="display-4 white">Создайте свой собственный словарь!</h1>
    <p class="lead white">Используя наш сайт вы можете хранить свои слова, перевод и используемые фразы к этим словам.</p>
          </div>
    <div class="col-md-4">
    <div class="containers">
  <div class="bookmark"></div>
  <div class="notepad">
    <svg id="smiley" viewBox="0 0 532 372" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
        <g id="Face">
            <ellipse id="eye-left" fill="#000" cx="72.5" cy="68.5" rx="72.5" ry="68.5"></ellipse>
            <ellipse id="eye-right" fill="#000" cx="459.5" cy="68.5" rx="72.5" ry="68.5"></ellipse>
            <path d="M145,236.5 C145,401.46875 386.59375,406.03125 386.59375,233" id="Mouth" stroke="#000" stroke-width="20"></path>
        </g>
    </g>
</svg>
    <div class="ring"></div>
  </div>
</div>
    </div>
    
      </div>
       
           
    
  
       
  </div>
</section>
        
        
        
        ${role}<br><br>
        
        
       
        
       
        
          
        
        
       
        
        
         

        
       