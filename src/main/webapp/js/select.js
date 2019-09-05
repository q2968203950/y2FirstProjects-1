layui.define(["jquery","form"],function(exports){
	var $ = layui.jquery;
	var form = layui.form;
	var select = {
			initSelect:function(options){
				var elem = options.elem;
				var url = options.url;
				var value = options.value;
				var text = options.text;
				var selected = options.selected;
				$.get(url,function(data){
					elem.empty();
					for(var i in data){
						var row = data[i];
						var v = row[value];
						var t = row[text];
						if(v == selected){
							elem.append('<option value="'+v+'" selected>'+t+'</option>');
						}else{
							elem.append('<option value="'+v+'">'+t+'</option>');
						}
					}
					setTimeout(function(){
						form.render();
					},100);
				},"json");
			}
	}
	exports("select",select);
});