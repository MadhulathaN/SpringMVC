package net.roseindia.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.roseindia.model.Registrations;

@Repository("registrationDAO")
@Transactional
public class RegistrationDAOImpl implements RegistrationDAO{
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
    public boolean checkRegistrtion(String role,String UserName,String Password,String Email){
    	Session session = sessionFactory.openSession();
		boolean userFound = false;

		Registrations r=new Registrations();
		r.setUserName(UserName);
		r.setUserPassword(Password);
		r.setEmail(Email);
		r.setRole(role);
		
		//System.out.println("@@@@@@@@@@@@@@@@@@@@"+session.save(r));
		
		session.save(r);
		session.flush();
		session.refresh(r);
		session.close();
		return true;              
   }
    

    

}
