1学生登录判断有空格导致密码不正确
    路径为 login.btn_okActionPerformed. //判断是否是学生用户
	sql="select*from userman where name='"+username+"'AND pass=' "+pass+ "'AND userType='student'";
	sql="select*from userman where name='"+username+"'AND pass='"+pass+ "'AND userType='student'";
2数据库表字段和项目中字段对称 
    userman 中的字段username 修改为name
3 数据库中student表中字段Sdetp（ 学生所在系别）  和项目中字段学生所在系别  Sdept不一致 修改数据字段Sdetp----》Sdept
    	