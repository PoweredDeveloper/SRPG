<?php
  $delete = $_GET['delete'];
  $lore = $_GET['lore'];
  $nick = $_COOKIE['auth'];

  if (trim($lore) != "") {
    $sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
    $sql->query("SET NAMES 'utf8'");

    $sql->query("UPDATE `users` SET `lore` = '$lore' WHERE `users`.`nickname` = '$nick';");

    $sql->close();
  }

  function Error($error) {
    header("Location: ../profile.php?error=$error");
    exit();
  }

  if(isset($_FILES['userico']) && $_FILES['userico'] !=""){

    $file_extension = strstr($_FILES['userico']['name'], '.');

    $extension_whitelist = ['.png', '.jpeg', '.jpg', '.gif'];

    if (in_array($file_extension, $extension_whitelist)) {
      $sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
      $sql->query("SET NAMES 'utf8'");

      $_FILES['userico']['name'] = $nick.$file_extension;
      move_uploaded_file($_FILES["userico"]["tmp_name"], "../img/usericons/".$_FILES["userico"]["name"]);

      $path_file = "../img/usericons/".$_FILES["userico"]["name"];

      $sql->query("UPDATE `users` SET `userico` = '$path_file' WHERE `users`.`nickname` = '$nick';");

      $sql->close();
      header('Location: ../profile.php');
      exit();
    } else {
      Error("Формат файла должен быть PNG, JPEG, JPG или GIF.");
    }
  } else {
      Error("Вы не выбрали файл.");
  }
?>

