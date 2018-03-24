<?php
class View{
    function __Construct(){
       
    }
    
    public function render($name){
        require('Views/'.$name.'.php');

    }
}