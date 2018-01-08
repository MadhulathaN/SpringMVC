package net.roseindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.roseindia.dao.RegistrationDAO;
import net.roseindia.model.Registrations;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	 private RegistrationDAO registrationDAO;

	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}
	
	public boolean checkRegistrtion(String role,String UserName,String Password,String Email){
        System.out.println("In Service class...Check Login");
        return registrationDAO.checkRegistrtion(role,UserName,Password,Email);
 }
	
}