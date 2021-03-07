<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}



button:hover {
  opacity: 0.8;
}






.container {
  padding: 16px;
}




/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  /*margin: 5% auto 15% auto;  5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 50%; /* Could be more or less, depending on screen size */
}





/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
 /* CSS comes here */
    #video {
        border: 1px solid black;
        width: 320px;
        height: 240px;
    }

    #photo {
        border: 1px solid black;
        width: 320px;
        height: 240px;
    }

    #canvas {
        display: none;
    }

    .camera {
        width: 340px;
        display: inline-block;
    }

    .output {
        width: 340px;
        display: inline-block;
    }

    #startbutton {
        display: block;
        position: relative;
        margin-left: auto;
        margin-right: auto;
        bottom: 36px;
        padding: 5px;
        background-color: #6a67ce;
        border: 1px solid rgba(255, 255, 255, 0.7);
        font-size: 14px;
        color: rgba(255, 255, 255, 1.0);
        cursor: pointer;
    }

    .contentarea {
        font-size: 16px;
        font-family: Arial;
        text-align: center;
    }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>

<body>
	<h3 style="color: red;">Registration Page</h3>

	<div id="register">
		<form:form class="modal-content animate" action="/addUser" method="post"
			modelAttribute="user">
			<div class="container">
			<p>
				<label>Enter Name</label>
				<form:input path="userName" autofocus="autofocus" required="true" />
				
			</p>
			<p>
				<label>Enter First Password</label>
				<form:password pattern="[0-9]{5}[A-Z]{3}" path="fpass" required="true" />
				<span style="color:Tomato;"> Minimun required - 5 numbers is a digit followed by 3 uppercase letters.</span>
			</p>
			
			<p>
				<label>Enter Second Password</label>
				<form:input type="color" path="spass" required="true"/>
				<span style="color:Tomato;">Required - Select color with RGB Style.</span>
			</p>
			<p>
				<label>Enter Third Password</label>
				<span style="color:Tomato;">
           Required - Take Picture for Third Password.
                  </span>
				<div class="contentarea">
        <div class="camera">
            <video id="video">Video stream not available.</video>
        </div>
    </div>
				 <div>				 
				 <input type="BUTTON" id="startbutton" value="Take photo" />
				 <canvas id="canvas"></canvas>
				 </div>				 	
				
				<div class="output">
				<form:input type="image" value="myimage.png" id="photo" alt="The screen capture will appear in this box." path="tpass" required="true" />
			     </div>
			</p>
			

    
			<input type="SUBMIT" value="Submit" />
			</div>
		</form:form>
	</div>
	<script>
    /* JS comes here */
    (function() {

        var width = 320; // We will scale the photo width to this
        var height = 0; // This will be computed based on the input stream

        var streaming = false;

        var video = null;
        var canvas = null;
        var photo = null;
        var startbutton = null;

        function startup() {
            video = document.getElementById('video');
            canvas = document.getElementById('canvas');
            photo = document.getElementById('photo');
            startbutton = document.getElementById('startbutton');

            navigator.mediaDevices.getUserMedia({
                    video: true,
                    audio: false
                })
                .then(function(stream) {
                    video.srcObject = stream;
                    video.play();
                })
                .catch(function(err) {
                    console.log("An error occurred: " + err);
                });

            video.addEventListener('canplay', function(ev) {
                if (!streaming) {
                    height = video.videoHeight / (video.videoWidth / width);

                    if (isNaN(height)) {
                        height = width / (4 / 3);
                    }

                    video.setAttribute('width', width);
                    video.setAttribute('height', height);
                    canvas.setAttribute('width', width);
                    canvas.setAttribute('height', height);
                    streaming = true;
                }
            }, false);

            startbutton.addEventListener('click', function(ev) {
                takepicture();
                ev.preventDefault();
            }, false);

            clearphoto();
        }


        function clearphoto() {
            var context = canvas.getContext('2d');
            context.fillStyle = "#AAA";
            context.fillRect(0, 0, canvas.width, canvas.height);

            var data = canvas.toDataURL('image/png');
            photo.setAttribute('src', data);
        }

        function takepicture() {
            var context = canvas.getContext('2d');
            if (width && height) {
                canvas.width = width;
                canvas.height = height;
                context.drawImage(video, 0, 0, width, height);

                var data = canvas.toDataURL('image/png');
                photo.setAttribute('src', data);
            } else {
                clearphoto();
            }
        }

        window.addEventListener('load', startup, false);
    })();
    </script>
</body>
</html>
