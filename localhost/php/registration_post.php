<?php
	$name = $_POST['name'];
	$pass = $_POST['pass'];
	$repass = $_POST['repass'];
	$nick = $_POST['nickname'];
	$email = $_POST['email'];

	$error = "";

	if (trim($name) == "") {
		$error = "Вы не ввели имя пользователя";
		header("Location: /register.php?error=$error");
		exit();
	} elseif (strlen($name) <= 1 || strlen($name) >= 20) {
		$error = "Введите корректное имя";
		header("Location: /register.php?error=$error");
		exit();
	} elseif (trim($pass) == "" || trim($repass) == "" || trim($nick) == "" || trim($email) == "") {
		$error = "Введите все данные";
		header("Location: /register.php?error=$error");
		exit();
	} elseif ($repass != $pass) {
		$error = "Пароли не совпадают";
		header("Location: /register.php?error=$error");
		exit();
	} elseif (strlen($pass) < 5 || strlen($pass) > 32) {
		$passlen = strlen($pass);
		$error = "Пароль может быть только от 5 до 32 символов. У вас: $passlen символа-ов";
		header("Location: /register.php?error=$error");
		exit();
	} elseif ($nick == $name) {
		$error = "Имя не может быть такое же как и никнейм";
		header("Location: /register.php?error=$error");
		exit();
	} elseif (strlen($nick) < 3 || strlen($nick) > 16) {
		$error = "Ник должен быть от 3 до 16 символов.";
		header("Location: /register.php?error=$error");
		exit();
	} else {
		$sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
		$sql->query("SET NAMES 'utf8'");

		$email_check = $sql->query("SELECT `email`, `nickname` FROM users WHERE email='$email' OR nickname='$nick'");
			while ($row = $email_check->fetch_assoc()) {
				$error = "Такой email или nickname уже существует";
				$sql->close();
				header("Location: /register.php?error=$error");
				exit();
		}

		$mdpass = md5($pass);

		$sql->query("INSERT INTO `users` (`id`, `name`, `pass`, `email`, `lvl`, `money`, `nickname`, `lore`, `userico`, `xp`) VALUES (NULL, '$name', '$mdpass', '$email', '0', '10', '$nick', 'Привет, я играю на этом сервере.', 'none', '0');");
		
		setcookie("auth", $nick, time() + 21600,'/');
		
		$sql->close();
		header('Location: /index.php');
		exit();
	}