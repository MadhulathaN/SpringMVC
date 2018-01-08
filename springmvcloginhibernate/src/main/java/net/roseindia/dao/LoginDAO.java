package net.roseindia.dao;
import java.util.List;
import net.roseindia.model.*;

public interface LoginDAO{    
       public boolean checkLogin(String userName, String userPassword);
       public List<Registrations> isAdmin(String userName);
       
}