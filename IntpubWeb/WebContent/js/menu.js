function MenuList()
{
	this.menuList = new Array();
	this.addMenu = addMenu;
}
function addMenu(parentMenu,menuCode,menuName,level,parentMenuCode)
{
	var menu = new Object();
	menu.menuCode = menuCode;
	menu.menuName = menuName;
	menu.level = level;
	if(null == parentMenuCode)
	{
		if(parentMenu == null)
		{
			menuBar.menuList.push(menu);
		}
		else
		{
			if(parentMenu.menuList == null)
			{
				parentMenu.menuList = new Array();
			}
			parentMenu.menuList.push(menu);
		}
		
	}
	else
	{
		if(parentMenu.menuList == null)
		{
			parentMenu.menuList = new Array();
		}
		parentMenu.menuList[parentMenuCode].push(menu);
	}
	return menu;
}
