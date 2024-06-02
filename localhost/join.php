<?php
  $title = "Вход";
  include "blocks/menu.php";
?>
  <body class="background">
    <div class="registerm">
      <div class="regformblock">
        <div>Вход</div>
        <div>
          <form action="./php/join_post.php" method="post">
            <input type="text" name="nickname" placeholder=" Ник:" class="inputform" autocomplete="off"><br>
            <input type="email" name="email" placeholder=" E-mail:" class="inputform" autocomplete="off"><br>
            <input type="password" name="pass" placeholder=" Пароль:" class="inputform" autocomplete="off"><br>
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
        <div style="padding: 0;"><span class="isreglog">Забыли пароль? <a href="register.php">Востановить</a></span></div>
        <div style="padding: 0;"><span class="isreglog">Ещё не зарегестрированны? <a href="register.php">Регистрация</a></span></div>
        <p>*После входа вам будет доступен профиль. Вы сможете коментировать и оставлять оценки.</p>
      </div>
    </div>
    
  </body>
<?php
  include "blocks/footer.php";
?>