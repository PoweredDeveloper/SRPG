<?php
  $nick = $_COOKIE['auth'];
  require 'user.php';

  if ($user['userico'] != 'none') {
    $sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
    $sql->query("SET NAMES 'utf8'");

    $sql->query("UPDATE `users` SET `userico` = 'none' WHERE `users`.`nickname` = '$nick';");

    unlink($user['userico']);

    $sql->close();
    header('Location: ../profile.php');
    exit();
  } else {
    header('Location: ../profile.php');
    exit();
  }
?>