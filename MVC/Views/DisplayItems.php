<html>
    <head>
        <title>Display Items</title>
        
        <link rel='stylesheet' href='http://localhost/MVC/Views/css/bootstrap.min.css' type='text/css'/>
        <link rel='stylesheet' href='http://localhost/MVC/Views/css/main.css' type='text/css'/>
    </head>
    <body>


<p style='background:purple;padding:0.5%;border-radius:20px;color:white;'>Table of sold items.</p>
<table class='table table-striped'  border='1px solid black'>
    <th>No</th><th>Name</th><th>Qty</th><th>Unit Price</th><th>Description</th>
    <?php 
        while($row=mysqli_fetch_assoc($this->itemList)){
            echo "<tr>";
            echo "<td>".$row['id']."</td>";
            echo "<td>".$row['name']."</td>";
            echo "<td>".$row['qty']."</td>";
            echo "<td>".$row['price']."</td>";
            echo "<td>".$row['desc']."</td>";
            echo "</tr>";
        }
    ?>
    </table>


    <p style='background:purple;padding:0.5%;border-radius:20px;color:white;width:60%;margin-left:20%;'>Add a new Item</p>
<div id='mainPanel' class="container"  >
  
  <div class="">
    
    <div class="panel-body">
  <form action='../../InsertItems/insertItem/Items' method='post'>
    <div class="form-group">
    <br>
        <input type='text' class='form-control' placeholder="Name" name='name'><br>
        <input type='text' class='form-control' placeholder="Qty" name='qty'><br>
        <input type='text' class='form-control' placeholder="Price" name='price'><br>
        <textarea type='text' class='form-control' placeholder="Description" name='desc'></textarea><br>
        <button type='submit' class='btn btn-info' style='float:right;'>Insert</buttton><br>
