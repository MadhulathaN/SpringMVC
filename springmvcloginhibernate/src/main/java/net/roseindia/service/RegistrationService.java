package net.roseindia.service;
import net.roseindia.form.Registration;
import net.roseindia.model.*;

public interface RegistrationService {
	public boolean checkRegistrtion(String role,String UserName,String Password,String Email);

}
