<?php


    include("Parametros_Db.php");


    class Conexion{
        
                     

                public function ExtablecerConexion()
                {
                     
                      $dsn = "mysql:dbname=".DB_NAME.";host=".DB_HOST;
                      $usuario = DB_USER;
                      $contraseña = DB_PASS;

                     

                    
                    
                               try {
                                     $conexion = new PDO($dsn, $usuario, $contraseña);
                                     
                                     return $conexion;
                                     
                                     
                                     
                                }
                                catch (PDOException $e) {

                                        echo 'Falló la conexión: ' . $e->getMessage();

                            }


                }   

        
    }




?>
