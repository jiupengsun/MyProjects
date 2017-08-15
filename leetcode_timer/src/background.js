var domain = "leetcode";
// default value
localStorage[domain + "_easy"] = 20;
localStorage[domain + "_medium"] = 40;
localStorage[domain + "_hard"] = 60;
localStorage[domain + "_warn"] = false;

// listen
/*
 *
 * request:
 * {
 *	action: '',
 *	data: [
 *		{
 *			name: '',
 *			value: ''
 *		}
 *	]
 * }
 *
 * response:
 * {
 *	data: [
 *		{
 *			name: '',
 *			value: ''
 *		}
 *	]
 * }
 */
chrome.runtime.onMessage.addListener(function(request, sender, sendResponse){
	console.log(sender.tab ? "from a content script:" + sender.tab.url : 
		"from the extension");
	switch (request.action) {
		case 'get': {
			var rlist = [];
			for (var i=0; i<request.data.length; ++i) {
				var o = request.data[i];
				var value = localStorage[domain + "_" + o.name];
				if (value)
					rlist.push({
						name: o.name,
						value: value
					});
			}
			// send back
			sendResponse({
				data: rlist	
			});
		}
			break;
		case 'set': {
			for (var i=0; i<request.data.length; ++i) {
				var o = request.data[i];
				localStorage[domain + "_" + o.name] = o.value;
			}
			// no need to send anything
			sendResponse({
				data: []	
			});
		}
			break;
		default: {
				
		}
	}
	
});
