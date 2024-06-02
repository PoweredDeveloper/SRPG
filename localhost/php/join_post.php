<?php
	$nick = $_POST['nickname'];
	$email = $_POST['email'];
	$pass = $_POST['pass'];
	$quit = $_GET['quit'];

	$error = "";

	if ($quit == true) {
		setcookie("auth", $nick, time() - 21600,'/');
	}
	
	$sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
	$sql->query("SET NAMES 'utf8'");

	$mdpass = md5($pass);
	
	$join = $sql->query("SELECT `nickname`, `email`, `pass` FROM users WHERE email='$email' AND nickname='$nick'");
	while ($row = $join->fetch_assoc()) {
		$passbd = $row['pass'];
		if ($mdpass == $passbd) {
			setcookie("auth", $nick, time() + 21600,'/');
			$sql->close();
			header('Location: /index.php');
			exit();
		} else {
			$error = "Вы ввели не правильный пароль или никнейм";
			$sql->close();
			header("Location: /join.php?error=$error");
			exit();
		}
	}

	$sql->close();
	header('Location: /index.php');
	exit();