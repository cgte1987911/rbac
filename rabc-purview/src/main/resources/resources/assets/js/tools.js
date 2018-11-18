var tools = (function(){
	var toolsObj = {
		$:function(selector,context){
			/*

			 * #id
			 * .class
			 * 标签
			 * "#id li"
			 * ".class a"
			 * */
			 if(context){
			 	var temp=context;
			 	var context=selector;
			 	var selector=temp;
			 }
			context = context || document;
			if(selector.indexOf(" ") !== -1){
				return context.querySelectorAll(selector);
			}else if( selector.charAt(0) === "#" ){
				return document.getElementById(selector.slice(1))
			}else if( selector.charAt(0) === "." ){
				return context.getElementsByClassName(selector.slice(1));
			}else{
				return context.getElementsByTagName(selector);
			}
		},
		addEvent:function(ele,eventName,eventFn){
			ele.addEventListener(eventName,eventFn,false);
		},
		removeEvent:function(ele,eventName,eventFn){
			ele.removeEventListener(eventName,eventFn,false);
		},
		addClass:function (element,clsNames){
			if( typeof clsNames === "string" ){
				if(!tools.hasClass(element,clsNames)){
					element.className += " "+clsNames;
				}
			}
		},
		removeClass:function (element,clsNames){
			var classNameArr = element.className.split(" ");
			for( var i = 0; i < classNameArr.length; i++ ){
				if( classNameArr[i] === clsNames ){
					classNameArr.splice(i,1);
					i--;
				}
			}
			element.className = classNameArr.join(" ");
		},
		hasClass:function(ele,classNames){
			var re = new RegExp('\\b'+classNames+'\\b');
			if(re.test(ele.className))
				return true
			return false
		},
		toggleClass:function (ele,classNames){
			if( tools.hasClass(ele,classNames) ){
				tools.removeClass(ele,classNames);
				return false;
			}else{
				tools.addClass(ele,classNames);
				return true;
			}
		},
		sibling:function (elem){
			 var a = [];
			 var b = elem.parentNode.children;
			 for (var i = 0 ; i < b.length ; i++){
			  if(b[i] !== elem) a.push(b[i]);
			 }
			 return a;
			},
		sonChilds:function(obj,selector){
			var arr=[];
			var childs=obj.children;
			if(selector=="*")
				return childs;
			for(var i=0;i<childs.length;i++){
				if(childs[i].nodeName.toLowerCase()=="ul"){
					arr.push(childs[i])
				}
			}
			return arr;
		},
		parentsChain:function(obj,untilEle,selector){
			var arr=[]
			if( untilEle.charAt(0) === "#" ){
				while(obj.id !== untilEle.slice(1)){
					pushParent();
				}
			}else if( untilEle.charAt(0) === "." ){
				while((obj && obj.nodeType !== 9) && !tools.hasClass(obj,untilEle.slice(1))){
					pushParent();
				}
			}else{
				while(obj && obj.nodeType !== 9 && obj.nodeName.toLowerCase() !== untilEle){
					pushParent();
				}
			} 
			return arr;
			function pushParent(){
				obj = obj.parentNode;
					if(selector){
						switch(selector.charAt(0)){
							case ".":
								if(tools.hasClass(obj,selector.slice(1)))
									arr.push(obj);
							break;
							default:
								if(obj.nodeName.toLowerCase()==selector)
									arr.push(obj);
							}
					}
					else{
						arr.push(obj);
					}
			}     
		},
		parent:function(obj,selector){
			/*

			 * selector
			 * id
			 * class
			 * 标签
			 * */

			if( selector.charAt(0) === "#" ){
				while(obj.id !== selector.slice(1)){
					obj = obj.parentNode;
				}
			}else if( selector.charAt(0) === "." ){
				while((obj && obj.nodeType !== 9) && !tools.hasClass(obj,selector.slice(1))){
					obj = obj.parentNode;
				}
			}else{
				while(obj && obj.nodeType !== 9 && obj.nodeName.toLowerCase() !== selector){
					obj = obj.parentNode;
				}
			}

			return obj && obj.nodeType === 9  ? null : obj;
		},
		each:function(obj,callBack){
			for( var i = 0; i < obj.length; i++ ){
				callBack(obj[i],i);
			}
		},
		getEleRect:function(obj){
			return obj.getBoundingClientRect();
		},
		collisionRect:function(obj1,obj2){
			var obj1Rect = tools.getEleRect(obj1);
			var obj2Rect = tools.getEleRect(obj2);

			var obj1W = obj1Rect.width;
			var obj1H = obj1Rect.height;
			var obj1L = obj1Rect.left;
			var obj1T = obj1Rect.top;

			var obj2W = obj2Rect.width;
			var obj2H = obj2Rect.height;
			var obj2L = obj2Rect.left;
			var obj2T = obj2Rect.top;
			//碰上返回true 否则返回false
			if( obj1W+obj1L>obj2L && obj1T+obj1H > obj2T && obj1L < obj2L+obj2W && obj1T<obj2T+obj2H ){
				return true
			}else{
				false;
			}
		},
		store:function (namespace, data)  {
			if (data) {
				return localStorage.setItem(namespace, JSON.stringify(data));
			}

			var store = localStorage.getItem(namespace);
			return (store && JSON.parse(store)) || [];
		},
		extend:function (obj){
			var newArr = obj.constructor === Array ? [] : {};
			for( var attr in obj ){
				if( typeof obj[attr] === "object"){
					newArr[attr] = tools.extend(obj[attr]);
				}else{
					newArr[attr] = obj[attr];
				}
			}
			return newArr;
		},
		hide:function (element){
			return element.style.display = "none";
		},
		show:function (element){
			return element.style.display = "block";
		},
		getOffset:function (obj){
			return {
				width:obj.offsetWidth,
				height:obj.offsetHeight
			}
		}
	}

	return toolsObj;

}())
