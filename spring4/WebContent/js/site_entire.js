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

/*** 브라우저 Storage 관련 */
function gfn_setStorage(type,key,value){
	var storage; 
	storage = window[type];
	storage.setItem(key,value);
}

function gfn_getStorage(type,key){
	var storage; 
	storage = window[type];
	return storage.getItem(key);
}

function gfn_RemoveStorage(type,key){
	var storage; 
	storage = window[type];
	storage.removeItem(key);
}

function gfn_ClearStorage(type){
	var storage; 
	storage = window[type];
	storage.clear();
}



