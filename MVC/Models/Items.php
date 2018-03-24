<?php
    class Items extends Model{
        function __construct(){
            parent::__construct();
        }
        public function listItems(){
            $res=mysqli_query($this->db,"SELECT * FROM  soldItems");
            return $res;
        }
        public function insertItem($name,$qty,$price,$desc){
            $res=mysqli_query($this->db,"INSERT INTO soldItems values (null,'$name','$qty','$price','$desc')");
            
            echo "<script>alert($res)</script>";    
        }
    }