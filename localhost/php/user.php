<?php
	$nick = $_COOKIE['auth'];

	$sql = new mysqli("localhost", "root", "root", "feudalrpg-db");
	$sql->query("SET NAMES 'utf8'");

	$userch = $sql->query("SELECT * FROM users WHERE nickname='$nick'");
	$row = $userch->fetch_assoc();
	$user = [
		'id' => $row['id'],
		'name' => $row['name'],
		'email' => $row['email'],
		'lvl' => $row['lvl'],
		'money' => $row['money'],
		'nickname' => $row['nickname'],
		'lore' => $row['lore'],
		'userico' => $row['userico'],
		'xp' => $row['xp'],
		'regdate' => $row['regdate']
	];

	$sql->close();