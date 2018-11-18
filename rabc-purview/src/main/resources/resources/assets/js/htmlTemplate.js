//准备树形菜单的html结构
function treeHtml(data,treeId){

	var childs = dataControl.getChildById(data,treeId);
	var toggleChild=treeId!=-1?"toggle-child":""
	var html = `<ul class='${toggleChild}'>`;

	childs.forEach(function (item){
		//获取到当前数据的层级 通过id获取
		var level = dataControl.getLevelById(data,item.id);
		/*tree-nav tree-contro*/

		//判断当前这个数据有没有子数据 通过id判断
		var hasChild = dataControl.hasChilds(data,item.id);
		//var classNames = hasChild ? "tree-contro" : "tree-contro-none";
		var icon=item.icon!=""?("<i class='fa "+item.icon+" fa-fw'></i>"):"";
		var triangle="";
		if(hasChild)
		{
			if(item.pid==-1)
			{
				triangle="<div class='triangle triangle-shrink triangle-top'></div>"
			}
			else
			triangle="<div class='triangle triangle-shrink'></div>"
		}
		html += `
            <li>
                <div class="tree-title" data-menu-url="${item.url}" style="padding-left:${level*20}px">
                    <span>
                    	<i class='fa ${item.icon} fa-fw'></i>&nbsp; ${item.title}
						${triangle}
                    </span>
                </div>
                ${treeHtml(data,item.id)}
            </li>
		`	
	})

		
	html += "</ul>";

	return html;
}

//创建文件的时候，创建一个树形菜单的li
function createTreeHtml(options){
	var newLi = document.createElement("li");
	newLi.innerHTML = `
				<div class="tree-title tree-contro-none" data-file-id="${options.id}">
                    <span>
                        <strong class="ellipsis">${options.title}</strong>
                        <i class="ico"></i>
                    </span>
                </div>
                <ul></ul>
	`;

	return 	newLi;
}



//通过id定位到树形菜单，添加calss
function positionTreeById( positionId ){
		
	var ele = document.querySelector(".tree-title[data-file-id='"+positionId+"']");

	tools.addClass(ele,"tree-nav");
}

//通过id得到当前这个id所有的父数据，得到一个结构
function createPathNavHtml(datas,fileId){
	//找到指定id所有的父数据
	var parents = dataControl.getParents(datas,fileId).reverse(); 
	var pathNavHtml = '';
	var len = parents.length;

	parents.forEach(function(item,index){
		if( index === parents.length-1 ) return;
		pathNavHtml += `
				<a href="javascript:;" style="z-index:${len--}" data-file-id="${item.id}">
					${item.title}
				</a>
			`;
	});
	//是当前这个一层的导航内容
	pathNavHtml += `
			<span class="current-path" style="z-index:${len--}">
				${parents[parents.length-1].title}
			</span>
		`;

	return pathNavHtml;
	
}