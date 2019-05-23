<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">WORDS - Админ-панель</a>
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
        
    </div>
    
    <hr>
    <h2 class="white text-center">Действия</h2>
    <div class="row">
            <div class="col-md-4 ">
                <a class="white " href="showRegistration"><button onclick="showRegistration" class="button type1" >Изменить роль пользователю </button></a><br>
                 </div>
               
               
     
    
        </div>
    <hr>
</div>



            
          
            
            
            
            
            
            
            
            
            
            
            
            
    













