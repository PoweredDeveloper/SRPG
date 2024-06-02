<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="../img/logo.png">
    <title><?=$title?> | FeudalRPG</title>
    <link rel="stylesheet" href="../css/main.css">
  </head>
  <header>
    <div>
      <div id="header">
        <a href="index.php"><img src="/img/logo.png"></a>
        <a href="index.php"><span>FeudalRPG</span></a>
      </div>
      <div id="pwin">
        <a href="profile.php" style="padding-top: 10px;">Профиль</a>
        <a href="profile.php#friends">Друзья</a>
        <a href="profile.php#inventory">Инвентарь</a>
        <a href="profile.php#settings">Настройки</a>
        <a href="./php/join_post.php?quit=true" style="padding-bottom: 10px;">Выход</a>
      </div>
      <?php
          if ($_COOKIE['auth'] != "") {
            $style = "";
            $profileimg = '/img/icons/user.png';
            require'./php/user.php';
            if ($user['userico'] != 'none') {
              $profileimg = $user['userico'];
              $style = "id='pbut'";
            }
            echo "<div id='headeractj'>
                    <img src=".$profileimg." onclick='profilewind()' title='Профиль' style='cursor: pointer;'".$style.">
                    <a href='./php/join_post.php?quit=true' title='Выйти из аккаунта'>
                    <img src='/img/icons/exit.png' style='padding-right: 15px;'>
                  </a>
                  </div>";
        } else {
          echo "<div id='headeract'>
                  <a href='register.php'>Регистрация</a>
                  <span> | </span>
                  <a href='join.php'>Вход</a>
                </div>";
        }
      ?>
      <div id="headerm">
        <ul>
          <li><a href="index.php" >Главная</a></li>
          <li><a href="news.php">Новости</a></li>
          <li><a href="shop.php">Магазин</a></li>
          <li><a href="guide.php">Для новичков</a></li>
          <li><a href="">Предметы</a></li>
          <li><a href="">Карта</a></li>
          <li><a href="">Топы</a></li>
        </ul>
      </div>
    </div>
    <!-- <div class="theme"><img src="/img/icons/moon.png" title="Светлая/Темная тема" onclick="toggleTheme()"></div> -->
    <script src="/js/main.js"></script>
  </header>