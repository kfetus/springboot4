/**
 * 
 */
function jsonAjaxAsync(url,type,jsonData,callback) {
		$.ajax({
			url: url
			, type: type
			, dataType: "json"
			, async: true
			, contentType: "application/json;charset=UTF-8;"
			, data: jsonData
			, success: function(data){
				console.log(data);
				if(callback != undefined){
					callback(data);
				}
			}, error: function(){
				console.log("error");
				console.log(data);
			}, complete: function(){
				console.log("complete");
			}
		});
}


function jsonAjaxSync(url,type,jsonData,callback) {
	$.ajax({
		url: url
		, type: type
		, dataType: "json"
		, async: false
		, contentType: "application/json;charset=UTF-8;"
		, data: jsonData
		, success: function(data){
			console.log(data);
			if(callback != undefined){
				callback(data);
			}
		}, error: function(){
			console.log("error");
			console.log(data);
		}, complete: function(){
			console.log("complete");
		}
	});
}