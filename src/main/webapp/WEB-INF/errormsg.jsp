<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.alert {
  padding: 20px;
  background-color: #6EFF33;
  color: red;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
</head>
<body>



<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 

 <a href="/tryagain">Try Again</a>

  <strong><h1>${Errormsg} </h1></strong> 
</div>


</body>
</html>
