<?php
require 'libs/View.php';
require 'libs/Controller.php';
require 'libs/Model.php';
$url= $_GET['url'];
$explodedUrl=explode("/", $url);

require ('Controllers/'. $explodedUrl[0] . ".php");
$controller=new $explodedUrl[0];

if(isset($explodedUrl[2])){
    $controller->loadModel($explodedUrl[2]);

}
if(isset($explodedUrl[1])){
    $controller->{$explodedUrl[1]}();
    

}


?>