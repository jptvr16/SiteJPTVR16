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
         
        <a class="nav-link active" href="showCheckingWords">Проверить Себя</a>
        
        </li>
        <li class="nav-item">
         
        <a class="nav-link active" href="showLearnedWords">Выученные слова</a>
        
        </li>
        <li class="nav-item ">
           <a class="nav-link active" id="logout" href="logout">Выйти</a><br>
        </li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br>
<div class="container">
    <div class="row">
        <c:if test="${info ne null}">
        <div class="alert alert-info alert-dismissible fade show" role="alert">
            ${info}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        </c:if>
            <br><br>
    </div>
    <button class="button type1" > <a class="white " href="showRegistration">Изменить роль пользователю</a></button>
    <button class="button type1" ><a class="white" href="showRegistration">Изменить пароль пользователю</a></button>
</div>

<section class="py-5">
  <div class="container">
    <h1 class="display-4 white">Создайте свой собственный словарь!</h1>
    <p class="lead white">Используя наш сайт вы можете хранить свои слова, перевод и используемые фразы к этим словам.</p>
  </div>
</section>
         
        
       
        
          
        
        
       
        
        
         

        
       