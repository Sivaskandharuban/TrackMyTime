/**
 * 
 */
console.log("Hello");
function start() {
	 setInterval(timer, 1000);
	}

var sec = 0;
var min = 0;
var hour = 0;

var secOut = 0;
var minOut = 0;
var hourOut = 0;

function timer() {
	  

var isChecked = document.getElementById("check").checked;

if(isChecked){
	  
	  secOut = checkTime(sec);
	  minOut = checkTime(min);
	  hourOut = checkTime(hour);

	  sec = ++sec;

	  if (sec == 60) {
		  sec = 0;
		  min=++min;
		  sec = sec++;
	  }

	  if (min == 60) {
	    hour = ++hour;
	    min = 0;
	  }

	  var today = new Date();   


	  document.getElementById("timeStarted").innerHTML = (today.getHours()<10 ? "0" +today.getHours() : today.getHours()) + ":" + (today.getMinutes()<10 ? "0" +today.getMinutes() : today.getMinutes()) + ":" + (today.getSeconds()<10 ? "0" +today.getSeconds() : today.getSeconds());
	  document.getElementById("timeEnded").innerHTML = "Ongoing";
	  document.getElementById("totalTime").innerHTML = hourOut + " h " + minOut +" m ";
//	  document.getElementById("logTime").innerHTML = hourOut + ":" + minOut +":" + secOut;
	}


	/* Adds 0 when value is <10 */
else{
	document.getElementById("timeEnded").innerHTML = (today.getHours()<10 ? "0" +today.getHours() : today.getHours()) + ":" + (today.getMinutes()<10 ? "0" +today.getMinutes() : today.getMinutes()) + ":" + (today.getSeconds()<10 ? "0" +today.getSeconds() : today.getSeconds());
	
}

	function checkTime(i) {
	  if (i < 10) {
	    i = "0" + i;
	  }
	  return i;
	}
}


