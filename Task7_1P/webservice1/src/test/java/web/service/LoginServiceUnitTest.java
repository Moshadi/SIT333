package web.service; 
import static org.junit.Assert.assertFalse; 
import static org.junit.Assert.assertTrue; 
import org.junit.Test; 
 
public class LoginServiceUnitTest { 
    @Test     
    public void testValidLogin() {         
    	assertTrue(LoginService.login("moshi", "moshi12", "08/02/2000")); 
    }
   
 
    @Test     
    public void testInvalidUsername() {        
    	assertFalse(LoginService.login("wronguser", "moshi12", "08/02/2000")); 
    }

 
    @Test     
    public void testInvalidPassword() {         
    	assertFalse(LoginService.login("moshi", "wrongpass", "08/02/2000")); 
    }
 
    @Test     
    public void testInvalidDOB() {         
    	assertFalse(LoginService.login("moshi", "moshi12", "01/01/2000")); 
    }
    
    @Test     
    public void testEmptyFields() {         
    	assertFalse(LoginService.login("", "", "")); 
    } 
    
    @Test     
    public void testNullValues() {         
    	assertFalse(LoginService.login(null, null, null)); 
    } 
 
    @Test     
    public void testCaseSensitivity() {         
    	assertFalse(LoginService.login("MOSHI", "Moshi12", "08/02/2000")); 
    } 
 
    @Test     
    public void testInvalidDateFormat() {         
    	assertFalse(LoginService.login("moshi", "moshi12", "08/02/2000")); 
    } 
} 
