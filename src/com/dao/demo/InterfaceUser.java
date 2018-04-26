package com.dao.demo;

import java.util.List;
import com.entity.demo.UserModel;

public interface InterfaceUser {
	
	public void create(UserModel User);
	public List<UserModel> read();
	public void update();
	public void delete();
}
