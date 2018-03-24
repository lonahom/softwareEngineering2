<?php
class InsertItems extends Controller{
        function insertItem(){
            
            var_dump($this->model);
            $this->view->render('InsertItem');
            
        }
        function __construct(){
            parent::__construct();
        }
        
       
        
        
    
    }
?>  