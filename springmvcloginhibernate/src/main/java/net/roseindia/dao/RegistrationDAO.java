package net.roseindia.dao;
import net.roseindia.model.*;

public interface RegistrationDAO {
	public boolean checkRegistrtion(String role,String UserName,String Password,String Email);

}
