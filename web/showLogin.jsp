<%@page contentType="text/html" pageEncoding="UTF-8"%>

      <div class="context">
        <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Авторизируйтесь!</h5>
            <c:if test="${info ne null}">
        <div class="alert alert-info alert-dismissible fade show" role="alert">
            ${info} 
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        </c:if>
            <form action="login" method="POST" class="form-signin">
              <div class="form-label-group">
                <input type="text" id="" name="login" class="form-control" placeholder="Логин" required autofocus>
                
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Пароль" required>
                
              </div>
                
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Войти</button><br>
              <label>Еще не зарегистрированы?</label><br>
                <a class="linkk" href="showRegistration">Создать аккаунт</a>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
    </div>


<div class="area" >
            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
    </div >

        
        
        
