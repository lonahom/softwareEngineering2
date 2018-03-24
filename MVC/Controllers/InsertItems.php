<?php
class InsertItems extends Controller{
        function insertItem(){
            $name=$_POST['name'];
            $qty=$_POST['qty'];
            $price=$_POST['price'];
            $desc=$_POST['desc'];
            $this->model->insertItem($name,$qty,$price,$desc);
            
           header("Location: ../../displayItems/listItems/Items");
            
        }
        function __construct(){
            parent::__construct();
        }
        
       
        
        
    
    }
?>  