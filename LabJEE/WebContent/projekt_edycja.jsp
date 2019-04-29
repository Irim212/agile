<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projekt</title>
</head>
<body>

	<form action="ProjektEdycja" method="POST">
		<input name="btn_zapisz" value="Zapisz" type="submit">
	</form>

	ID zapisanego projektu: ${projekt.projektId}
	<br/>
	<br/>

	<form action="ProjektEdycja" method="POST">
		<input name="txt_usun" type="number">
		<input name="btn_usun" value="usun" type="submit">
	</form>

</body>
</html>