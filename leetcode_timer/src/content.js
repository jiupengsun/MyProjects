(function(){

	// insert countdown timer DOM object
	var $_timer = $($.parseHTML('&nbsp;&nbsp;<label><a class="replay" href="#"><i class="fa fa-undo"></i></a>&nbsp;&nbsp;<a class="play" href="#"><i class="fa fa-play"></i></a></label>&nbsp;&nbsp;<span style="color:green" id="countdown-timer"></span>'));
	$(".custom-textcase").append($_timer);

	var difficulty_label = $(".difficulty-label").text(); 
	var difficulty = 'easy';
	if (difficulty_label.indexOf("Medium") >= 0)
		difficulty = 'medium';
	else if (difficulty_label.indexOf("Hard") >= 0)
		difficulty = 'hard';

	var default_minutes = 20;
	var global_warn = false;

	// load configuration variables
	chrome.runtime.sendMessage(
		{
			action: "get",
			data: [
				{
					name: difficulty
				},	
				{
					name: 'warn'
				}
			]
		}, function(response){
			console.log(response.data);
			for (var i=0; i<response.data.length; ++i) {
				var r = response.data[i];
				if (r.name == difficulty)
					default_minutes = r.value;
				else if (r.name == 'warn') {
					global_warn = r.value;
				}
			}

			var minutes = default_minutes;
			var seconds = 0;
			var warn = global_warn;
			$("#countdown-timer").text(minutes + ':' + seconds);
			// bind event
			$("a.play").on('click', function(event){
				event.preventDefault();
				if (window.timer)
					return;
				window.timer = setInterval(function() {
					if (minutes == 0 && seconds == 0) {
						clearInterval(window.timer);
						if (global_warn) {
							confirm("Time's up!");
						}
						return;
					}
					if (seconds == 0)	{
						seconds = 59;
						minutes -= 1;
					} else
						seconds -= 1;
					// change style
					if (minutes < 5) {
						$("#countdown-timer").css("color", "red");
						if (warn) {
							confirm("Only 5 minutes left!");
							warn = false;
						}
					}
					// display
					var m = minutes + '';
					if (minutes < 10)
						m = '0' + m;
					var s = seconds + '';
					if (seconds < 10)
						s = '0' + seconds;
					$("#countdown-timer").text(m + ':' + s);
				}, 1000);
			});

			$("a.replay").on('click', function(event) {
				event.preventDefault();
				warn = global_warn;
				clearInterval(window.timer);
				delete window.timer;
				minutes = default_minutes;
				seconds = 0;
				$("#countdown-timer").css("color", "green");
				$("#countdown-timer").text(minutes + ':' + seconds);
			});
		});

})()



