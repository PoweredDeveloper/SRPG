<?php
  $title = "Регистрация";
  include "blocks/menu.php";
?>
  <body class="background">
    <div class="registerm">
      <div class="regformblock">
        <div>Регистрация</div>
        <div>
          <form action="./php/registration_post.php" method="post">
            <input type="text" name="nickname" placeholder=" Ник:" class="inputform" autocomplete="off"><br>
            <input type="text" name="name" placeholder=" Имя:" class="inputform" autocomplete="off"><br>
            <input type="password" name="pass" placeholder=" Пароль:" class="inputform" autocomplete="off"><br>
            <input type="password" name="repass" placeholder=" Повторите пароль:" class="inputform" autocomplete="off"><br>
            <input type="email" name="email" placeholder=" E-mail:" class="inputform" autocomplete="off"><br>
            <?php
                $error = $_GET['error'];
                if ($error != "") {
                  echo "<div style='padding: 10px 15%;'><div class='error'>
                          $error
                        </div></div>";
                }
            ?>
            <input type="submit" value="Готово" class="submitform">
          </form>
        </div>
        <div style="padding: 0;"><span class="isreglog">Уже зарегестрированны? <a href="join.php">Войти</a></span></div>
        <p>*После регистрации вам будет доступен профиль. Вы сможете коментировать и оставлять оценки.</p>
      </div>
    </div>
  </body>
<?php
  include "blocks/footer.php";
?>