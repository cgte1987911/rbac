		(function(){
		//树形菜单高度自适应
		var header=tools.$('#header');
		var menuTreeWrap=tools.$('.tree-menu-wrap')[0];
		var menuTree=tools.$('.tree-menu')[0];

		var headerH=header.offsetHeight;
		
		changeMenuTreeWrapHeight();

		function changeMenuTreeWrapHeight(){
			var viewHeight=document.documentElement.clientHeight;
			menuTreeWrap.style.height=viewHeight-headerH+'px';
		}

		window.onresize=changeMenuTreeWrapHeight;
		menuTree.innerHTML+=treeHtml(data.menutree,-1);

		var preChainLi=null
		tools.each(tools.$(".tree-title"),function(item){
			var triangle=tools.$(item,'.triangle')[0];
			var treeTitle=tools.$(item,'.tree-title')[0];
			var parentLi=tools.parent(item,"li")
			var childUls=tools.$(parentLi,"ul")
			var childSonUls=tools.sonChilds(parentLi,"ul");
			item.addEventListener("click",function(){
				var _this=this;
				if(tools.$(item,'.triangle').length==0){					
					onlyChainColor();
					console.log(item.dataset.menuUrl)
					
				}
				else{
					tools.toggleClass(triangle,"triangle-expand");
					if(tools.hasClass(triangle,"triangle-expand")){
						onlyChainColor();
						var defaultSel=true;
						
							var items=tools.$(parentLi,".tree-title");
							tools.each(items,function(item){
							if(_this!=item&&tools.hasClass(item,"active")){
								defaultSel=false;
								
							}


						})
						if(defaultSel){
							console.log(tools.$(parentLi,".tree-title")[1].dataset.menuUrl)
							tools.addClass(tools.$(parentLi,".tree-title")[1],"active");
						}

							tools.each(childSonUls,function(item){
								tools.removeClass(item,"toggle-child");
							
						})
								
					}
								
						
					else{
						tools.each(childUls,function(item){
							tools.each(tools.$(item,".triangle"),function(triangle){									
								tools.removeClass(triangle,"triangle-expand")
								tools.addClass(triangle,"triangle-shrink")
							})
							
							tools.addClass(item,"toggle-child");
						})
					}
				}

				function onlyChainColor(){
					var sameChain=false;
					tools.each(tools.$('.tree-title'),function(item){
						tools.removeClass(item,'active');
					})
					if(preChainLi){
					tools.each(preChainLi,function(li){
						if(tools.$(li,".tree-title")[0]==item){

							sameChain=true
							}
						})
					}

					if(!sameChain){
					 preChainLi=tools.parentsChain(item,"tree-menu","li");

					}
					tools.each(preChainLi,function(li){
						tools.addClass(tools.$(li,".tree-title")[0],'active');
					})
				}

			})
		})


			
			
	}())