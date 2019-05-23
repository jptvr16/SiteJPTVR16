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
    <form action="manageWords" method="POST">
    <button class="btn btn-primary" type="submit" name="deleteWords" > <i class="fas fa-trash-alt white"></i></button>
    <button class="btn btn-primary" type="submit" name="hideWords" > <i class="far fa-eye white"></i></button>
    <div class="modal fade" id="deleteAll" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Выберите действие</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <label>Удалить выбранные слова?</label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
        <button type="submit"  class="btn btn-danger delete deleting">Удалить</button>
      </div>
    </div>
  </div>
</div>
    <hr>
    <br>
    
    <div class="row">
        
        <c:forEach var="userWords" items="${listUserWords}">
            <div class="col-md-12  center">


<div class="col-md-12"> 
                <label data-toggle="collapse" data-target="#demo${userWords.word.id}" onclick="" class="white word ">${userWords.word.word} - ${userWords.word.translation}</label>
                
                
                
                <a href="hideWord?id=${word.id}" data-toggle="modal" data-target="#hide"><i class="far fa-eye white"></i></a>
                
                
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
        <button type="button" class="btn btn-primary"><a class="deleting" href="hideWord?id=${userWords.word.id}">Добавить</a></button>
      </div>
    </div>
  </div>
</div>
                
                
                
                
                
                
                
        <a class="" href="showEditWord?id=${userWords.word.id}"><i class="fas fa-pencil-alt white"></i></a>
                    
                    <!-- Button trigger modal -->



                    <a><i class="far fa-minus-square white" data-toggle="modal" data-target="#exampleModal"></i></a> <input type="checkbox" name="words" value="${userWords.word.id}">  


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Выберите действие</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <label>Удалить выбранное слово?</label>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
        <button type="button" class="btn btn-danger"><a class="delete deleting" href="deleteWord?id=${userWords.word.id}" onclick="">Удалить</a></button>
      </div>
    </div>
  </div>
</div>

                    
                    
                    
                    

                             

                            
                    </div>
                <div id="demo${userWords.word.id}" class="collapse phrase">
                    <div class="">
                    <p >${userWords.word.phrase}</p>
                    </div>
</div><br>
                
 
                
                 </div>
        </c:forEach>
     </form>
    </div>
       <br> 
    <hr>
</div>


  


            
          
            
            
            
            
            
            
            
            
            
            
            
            
    













