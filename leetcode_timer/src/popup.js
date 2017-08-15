(function(){

	// load default value
	chrome.runtime.sendMessage({
		action: 'get',
		data: [
			{
				name: 'easy'
			},
			{
				name: 'medium'
			},
			{
				name: 'hard'
			},
			{
				name: 'warn'
			}
		]
	}, function(response){
		if (response.data.length > 0) {
			for (var i=0; i<response.data.length; ++i){
				var o = response.data[i];
				var $_input = $("#" + o.name);
				if ($_input.attr("type") == "text")
					$_input.val(o.value);
				else if ($_input.attr("type") == "checkbox")
					$_input.attr("checked", o.value);
			}
		}
	});
	
	// bind
	$("#OK").on('click', function(){
		var rlist = [];
		$("input").each(function() {
			var type = $(this).attr("type");
			switch (type) {
				case 'text': {
					var name = $(this).attr("id");
					var value = $(this).val().trim();
					if (value && value != "") {
						rlist.push({
							name: name,
							value: parseInt(value)
						});
					}
				}
					break;
				case 'checkbox': {
					var name = $(this).attr("id");
					rlist.push({
						name: name,
						value: $(this).attr("checked")
					});
				}
					break;
				default: {}
			}
		});
		// send request
		chrome.runtime.sendMessage(
			{
				action: 'set',
				data: rlist
			}, function(response) {
				console.log("Success");
			}
		);
		// close popup
		window.close();
	});

	// bind reset
	$("#Reset").on('click', function(){
		$("input").val('');
	});
})();
