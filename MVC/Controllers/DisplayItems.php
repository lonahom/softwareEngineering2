<?php
    
    class DisplayItems extends Controller{
        function listItems(){
            
            $this->view->itemList=$this->model->listItems();
            $this->view->render('DisplayItems');
            
        }
        function __construct(){
            parent::__construct();
            
            
        }
        
        
    }