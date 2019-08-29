<?php
	
	
	include ('Conexion.php');
	
	
	$conexion=new Conexion();
	
	
	$tipo=$_REQUEST['tipo'];
	
	$sql="call listar_lugares(:tipo);";	
	$consulta=$conexion->ExtablecerConexion()->prepare($sql);
	$consulta->bindParam(":tipo",$tipo);
	$consulta->execute();
	$consulta=$consulta->fetchAll(PDO::FETCH_ASSOC);
	
	$datos=array();
	
	
	
	foreach($consulta as $fila)
	{
		
		$datos[]=$fila;
		
	}
	
	echo json_encode($datos);
	
	
			
?>