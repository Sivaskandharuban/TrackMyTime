
var x;

function login()
{
var xhr = new XMLHttpRequest();

var name = document.getElementById("mailId").value;
var pass =	document.getElementById("Password").value;
//var params = "name="+name+"'&amp;pass="+pass;

var data = "name=" + encodeURIComponent(name)+ "&pass="+ encodeURIComponent(pass);

console.log(data);

xhr.open('POST','http://localhost:8080/Login', true);
xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
xhr.send(data);


xhr.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 400){
		document.getElementById("result").innerHTML = this.responseText;
	}
	
    if (this.readyState == 4 && this.status == 200) {
    	window.location.href = "TMT.html"; 
    	}
    
  };
}

function signUp()
{
var xhr = new XMLHttpRequest();

var name = document.getElementById("userName").value;
var mail = document.getElementById("mailId").value;
var pass =	document.getElementById("password").value;

var data = "name=" + encodeURIComponent(name)+ "&mail="+ encodeURIComponent(mail) + "&pass="+ encodeURIComponent(pass);

xhr.open('POST','http://localhost:8080/SignUp', true);
xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
xhr.send(data);

xhr.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 400){
		document.getElementById("result").innerHTML = this.responseText;
	}
	
    if (this.readyState == 4 && this.status == 200) {
    	window.location.href = "TMT.html";
    	document.getElementById("message").innerHTML = this.responseText; 
    	}
    
  };
}


function start()
{
	console.log("function call start");
	x = setInterval(timer, 1000);
	
	function timer(){
		var sec= 0;
		console.log(sec);
		var min = 0;
		console.log(min);
		var hour = 0;
		console.log(hour);
		
		var secOut = check(sec);
		var minOut = check(min);
		var hourOut = check(hour);
		
		sec = sec++;
		
		function check(i){
			if(i<10){
				return "0" + i;
			}
			
			if(sec==60){
				min = ++min;
				sec = 0;
			}
			
			if(min==60){
				hour = ++hour;
				min = 0;
			}
			
			document.getElementsByClassName("totalTime").innerHTML = hourOut + ":" + minOut + ":" + secOut;
			
			}
		}
	}
	

