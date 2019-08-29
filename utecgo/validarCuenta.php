<?php


	
	include ('Conexion.php');



	$usuario=$_REQUEST['us'];
	$cn=$_REQUEST['contra'];
	
	
	$conexion=new Conexion();
	
	$sql="call logeo(:us,:cn)";
	
	$stmt=$conexion->ExtablecerConexion()->prepare($sql);
	$stmt->bindParam(':us',$usuario);
	$stmt->bindParam(':cn',$cn);
	$stmt->execute();
	
	$stmt=$stmt->fetchAll(PDO::FETCH_ASSOC);
	
	
	$datos=array();
	
	foreach($stmt as $row)
	{
		$datos[]=$row;
		
	}
	
	echo json_encode($datos);
	
	
	
	






?>