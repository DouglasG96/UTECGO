<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        // put your code here
		
		
    include('Conexion.php');

    /*
    $usuario=$_REQUEST['usuario'];
    $pass =$_REQUEST['password'];
    */
    
    //$sql="select count(*) usuarios where usuario=".$usuario;
    
    
   $conexion=new Conexion();
   
   
   $sql="select * from usuarios";
   
   $stmt=$conexion->ExtablecerConexion()->prepare($sql);
   $stmt->execute();
   
   
   
   if($stmt->rowCount())
   {
       
       foreach ($stmt as $row)
       {
           
           echo $row[0]." ".$row[1]." ".$row[2]."<br/>";
           
       }
       
   }
   
    
    
    
		
		
        ?>
    </body>
</html>
