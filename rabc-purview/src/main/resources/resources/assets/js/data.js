var data = {
	menutree:[
		{
			id:0,
			pid:-1,
			title:"系统管理",
			type:"menu-dir",
			url:"",
			icon:"fa-cog"
		},

		{
			id:1,
			pid:-1,
			title:"博客管理",
			type:"menu-dir",
			url:"",
			icon:"fa-book"
		}
		,
		{
			id:3,
			pid:0,
			title:"用户管理",
			type:"menu",
			url:"/sys/users",
			icon:""
		},

		{
			id:4,
			pid:0,
			title:"角色管理",
			type:"menu",
			url:"/sys/roles",
			icon:""
		},

		{
			id:5,
			pid:0,
			title:"权限管理",
			type:"menu",
			url:"/sys/purviews",
			icon:""
		},

		{
			id:6,
			pid:1,
			title:"博客用户管理",
			type:"menu",
			url:"/blog/users",
			icon:""
		},
		{
			id:7,
			pid:1,
			title:"文章管理",
			type:"menu-dir",
			url:"",
			icon:""
		},
		{
			id:8,
			pid:7,
			title:"文章编辑",
			type:"menu-dir",
			url:"",
			icon:""
		},
		{
			id:10,
			pid:8,
			title:"文章删除",
			type:"menu",
			url:"/blog/edit/delete",
			icon:""
		},
		{
			id:9,
			pid:7,
			title:"文章发布",
			type:"menu",
			url:"/blog/publish",
			icon:""
		}

	]
}