package net.roseindia.service;

import java.util.List;

/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import net.roseindia.model.*;

public interface LoginService {
	public boolean checkLogin(String userName, String userPassword);

	public List<Registrations> isAdmin(String userName);
}