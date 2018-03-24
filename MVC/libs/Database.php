<?php
    public class Database{
        function _construct(){
            mysqli_connect("localhost","root","","Items");
            
        }
    }