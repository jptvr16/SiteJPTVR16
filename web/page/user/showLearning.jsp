<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
    <h2 class="white">Словарь</h2>
    <hr>
    <br>
    
    <div class="row">
        
            <div class="col-md-12  center">


<div class="col-md-12"> 
    
                <label data-toggle="collapse" data-target="#demo${UserWords.word.id}" onclick="" class="white word ">${UserWords.word.translation}</label>
                
                
                
                <a href="hideWord?id=${UserWords.word.id}" data-toggle="modal" data-target="#hide"><i class="far fa-eye white"></i></a>
                <button type="button" class="btn btn-primary"><a class="deleting" href="showLearning">Следующее слово</a></button>
                
                
                <div class="modal fade" id="hide" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Выберите действие</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <label>Добавить слово в выученные?</label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
        <button type="button" class="btn btn-primary"><a class="deleting" href="hideWord?id=${UserWords.word.id}">Добавить</a></button>
      </div>
    </div>
  </div>
</div>
                
                
                
                
                
                
                
                    

                    
                    
                    
                    

                             

                            
                    </div>
                <div id="demo${UserWords.word.id}" class="collapse phrase">
                    <div class="">
                        <p ><h3>Фразы</h3>${UserWords.word.phrase}<br><h3>Перевод</h3>${UserWords.word.word}</p>
                    </div>
</div><br>
                
 
                
                 </div>
        
     
    </div>
       <br> 
    <hr>
</div>


  


            
          
            
            
            
            
            
            
            
            
            
            
            
            
    













