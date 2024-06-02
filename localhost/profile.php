<?php
  if ($_COOKIE['auth'] == "") {
    header('Location: index.php');
  }

  $title = "Профиль";
  include "blocks/menu.php";
  require 'php/user.php';
?>
  <body class="background">
    <div style="padding-bottom: 150px;"></div>
    <div class="profileff">
      <div class="profileblock">
        <h2 class="p_head">Профиль</h2>
        <img src="<?php $style = "";
                        if ($user['userico'] == 'none') {
                          echo "../img/icons/user.png";
                          $style = "";
                        } else {
                          echo $user['userico'];
                          $style = "style='border-radius: 50%;'";
                        }?>" class="p_img" <?php echo $style; ?>>
        <div class="p_nick"><?php echo $user['nickname']; ?></div>
        <div class="p_name"><?php echo $user['name']; ?></div>
      </div>
      <div class="profileblock">
        <div style="padding: 40px;">
          <div>
            <ul class="p_ul">
              <li><a onclick="profilesel(this);">Главная</a></li>
              <li><a onclick="profilesel(this);">Аккаунт</a></li>
              <li><a onclick="profilesel(this);">Персонаж</a></li>
              <li><a onclick="profilesel(this);">Друзья</a></li>
              <li><a onclick="profilesel(this);">Клан</a></li>
              <div style="text-align: center; padding-bottom: 20px;">
                <div style="display: inline-block;">
                  <li><a onclick="profilesel(this);">Инвентарь</a></li>
                  <li><a onclick="profilesel(this);">Уведомления</a></li>
                  <li><a onclick="profilesel(this);">Настройки</a></li>
                </div>
              </div>
            </ul>
          </div>
          <!-- Главная -->
          <div style="display: block; color: #fff;" id="psmain">
            <div class="p_money">
              <img src="img/icons/monico.png">
              <div><?php echo $user['money']; ?></div>
            </div>
            <div>
              
            </div>
          </div>
          <!-- Аккаунт -->
          <div style="display: none;" id="psacco">
            <div>Установить аватарку:</div>
            <div>
              <img src="<?php echo $user['userico']; ?>" style="width: 100px;">
            </div>
            <form action="/php/user_action.php" method="post" enctype="multipart/form-data">
              <p>
                <input type="file" name="userico">
                <input type="submit" value="Готово" name="icoconf">
              </p>
            </form>
            <button>
              <a href='./php/usericodel.php'>Delete</a>
            </button>
            <div>Установить описание:</div>
            <form action="/php/user_action.php" method="get">
              <input type="text" name="lore">
              <input type="submit" value="Подтвердить">
            </form>
          </div>
          <!-- Персонаж -->
          <div style="display: none;" id="pspers">ПЕРСонАЖ</div>
          <!-- Друзья -->
          <div style="display: none;" id="psfrie">СКОРО</div>
          <!-- Клан -->
          <div style="display: none;" id="psclan">СКОРО</div>
          <!-- Инвентарь -->
          <div style="display: none;" id="psinve">СКОРО</div>
          <!-- Уведомления -->
          <div style="display: none;" id="psnoti">СКОРО</div>
          <!-- Настройки -->
          <div style="display: none;" id="pssett">Настройки</div>
        </div>
      </div>
    </div>
  </body>
<?php
  include "blocks/footer.php";
?>