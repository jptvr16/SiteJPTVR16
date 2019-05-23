<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">WORDS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        
        
        
        <li class="nav-item">
          <a class="nav-link active" href="showNewWord">Добавить слово</a>
        
        </li>
        <li class="nav-item">
         
        <a class="nav-link active" href="showListWords">Словарь</a>
        </li>
        <li class="nav-item">
         
        <a class="nav-link active" href="showLearning">Обучение</a>
        
        </li>
         <li class="nav-item">
         
        <a class="nav-link active" href="showLearnedWords">Выученные слова</a>
        
        </li>
         <li class="nav-item">
         
        <a class="nav-link active" href="showCheckingWords">Проверить Себя</a>
        
        </li>
        <li class="nav-item ">
           <a class="nav-link active" id="logout" href="logout">Выйти</a><br>
        </li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br>

<!--<header>
  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
       Slide One - Set the background image for this slide in the line below 
      <div class="carousel-item active" style="background-image: url('https://source.unsplash.com/LAaSoL0LrYs/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Самоучитель "Words"</h2>
          <p class="lead">Вписывайте слова!</p>
        </div>
      </div>
       Slide Two - Set the background image for this slide in the line below 
      <div class="carousel-item" style="background-image: url('https://source.unsplash.com/bF2vsubyHcQ/1920x1080')">
        <div class="carousel-caption d-none d-md-block">
          <h2 class="display-4">Самоучитель "Words"</h2>
          <p class="lead">Запоминайте слова!</p>
        </div>
      </div>
       Slide Three - Set the background image for this slide in the line below 
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
</header>-->

<!-- Page Content --><br>
<section class="py-5">
  <div class="container">
    <!-- MultiStep Form -->
<div class="row">
    <c:if test="${info ne null}">
    <div class="alert alert-info alert-dismissible fade show " role="alert">
  ${info}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
    
  </c:if>
    <div class="col-md-12">
        <form method="POST" action="addNewWord" id="msform">
            <!-- progressbar -->
            
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Добавить слово</h2>
                <h3 class="fs-subtitle">Заполните поля чтобы внести в словарь</h3>
                <input maxlength="25" type="text" name="word" placeholder="Слово" required/>
                <input maxlength="100" type="text" name="translation" placeholder="Перевод" required/>
                <hr>
                <h3>Фразы</h3>
                <textarea maxlength="1024" name="phrase"  required>  </textarea>
                <input type="submit" name="next" class="next action-button btn btn-lg btn-primary text-uppercase" value="Добавить"/>
            </fieldset>
          
        </form>
        <!-- link to designify.me code snippets -->
        
        <!-- /.link to designify.me code snippets -->
    </div>
</div>
  </div>
</section>
         
        ${role}<br><br>
        
        
        <br>
       
        
          
        
        
       
        
        
         

        
       