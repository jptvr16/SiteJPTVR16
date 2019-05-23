<%@page contentType="text/html" pageEncoding="UTF-8"%>

      <div class="context">
        <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Регистрация</h5>
            <form action="registration" method="POST" class="form-signin">
                 <div class="form-label-group">
                <input type="text" id="" name="name" class="form-control" placeholder="Имя" required autofocus>
                
              </div>
                 <div class="form-label-group">
                <input type="text" id="" name="surname" class="form-control" placeholder="Фамилия" required autofocus>
                </div>
              
                
              <div class="form-label-group">
                <input type="email" id="" name="email" class="form-control" placeholder="E-mail" required autofocus>
                
              </div>
                 <div class="form-label-group">
                <input type="text" id="" name="login" class="form-control" placeholder="Логин" required autofocus>
                
              </div>
               
                 <div class="form-label-group">
                <input type="password" id="" name="password1" class="form-control" placeholder="Пароль" required autofocus>
                
              </div> 
              <div class="form-label-group">
                <input type="password" name="password2" class="form-control" placeholder="Повторите пароль" required>
                
              </div>
                
              <button class="btn btn-lg btn-primary btn-block text-uppercase" name="send" type="submit">Зарегистрироваться</button><br>
              <label>Уже есть аккаунт?</label><br>
                <a class="linkk" href="showLogin">Войти</a>
              ${info}
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