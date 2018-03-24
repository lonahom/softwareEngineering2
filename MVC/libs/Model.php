<?php
class Model{
    function __construct(){
        $this->db=mysqli_connect("localhost","root","","pharmacyItems");
        
    }
}