<?php

      include ('Conexion.php');



	$usuario=$_REQUEST['us'];
	
	$conexion=new Conexion();
	
	$sql="call verificar_usuario(:us)";
	
	$stmt=$conexion->ExtablecerConexion()->prepare($sql);
	$stmt->bindParam(':us',$usuario);
	$stmt->execute();
	
	$stmt=$stmt->fetchAll(PDO::FETCH_ASSOC);
	
	$datos=array();
	
	foreach($stmt as $row)
	{
		$datos[]=$row;
		
	}
	
	echo json_encode($datos);
	


    
    
    
    

?>