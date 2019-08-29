<?php



$carnet=$_REQUEST['carnet'];
$codigo=$_REQUEST['codigo'];



$mail_para = $carnet."@mail.utec.edu.sv";
$subject   = "Codigo de verificacion UTEC GO";
$remite    = "UTEC Go";

$header ="MIME-Version: 1.0\n"; 
$header .= "Content-type: text/html; charset=iso-8859-1\n"; 
$header .="From: utec_go@mail.com.sv\n";
$header .="Return-path: ". $remite."\n";
$header .="X-Mailer: PHP/". phpversion()."\n";

$message = '<html><body>';
$message .= '<h3>Verificacion de registro UTEC GO</h3>';
$message.="<br/><br/>Codigo de verificacion <b> ".$codigo."</b>";
$message.="<br/><br/>Vuelve a la aplicacion y ingresa el codigo de autentificacion";
$message .= '</body></html>';

$mail = mail($mail_para, $subject, $message, $header);

$arreglo=array();


if ($mail) {
 
	$arreglo=array("ingresado"=>"1");
 
 
} else {
 
}

	echo json_decode($arreglo);


?>