<?php


	include ('Conexion.php');

	
	$usuario=$_REQUEST['usuario'];
	$clave=$_REQUEST['clave'];
	$pregunta=$_REQUEST['pregunta'];
	$tipo=1;
	
	
	$conexion=new Conexion();
	
	$sql="insert into usuarios values (:id,:contra,:recu,:tipo);";
	
	$stmt=$conexion->ExtablecerConexion()->prepare($sql);
	$stmt->bindParam(':id',$usuario);
	$stmt->bindParam(':contra',$clave);
	$stmt->bindParam(':recu',$pregunta);
	$stmt->bindParam(':tipo',$tipo);
	$stmt->execute();
	
	echo json_encode($stmt);
?>