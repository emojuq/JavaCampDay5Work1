package business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import core.AuthService;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.InMemory.InMemoryUserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private AuthService authService;
	


	public UserManager(UserDao userDao, AuthService authService) {
		
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() < 6) {
            System.out.println("lütfen þifrenizi en az 6 karakter uzunluðunda giriniz.");
            return;
        }
		
		 String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(user.getEmail());
	        if (!matcher.matches()) {
	            System.out.println("Mail adresinin sonu '@gmail.com' ile bitmesi gerekir");
	            return;
	        }
	        
	        
	        if (userDao.getByMail(user.getEmail()) != null){
	            System.out.println("lütfen sistemde kayýtlý olmayan bir e-posta ile giriþ yapýnýz");
	            return;
	            
	        }
	        
	        if (user.getName().length() < 2 || user.getLastName().length() < 2){
	            System.out.println(""
	            		+ "lütfen aþaðýdaki kurallara uyarak kayýt olunuz"
	            		+ "1- Ýsminiz en az 2 karakter olmalý." );
	            return;
	        }
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Gönderilen e postayý doðrulamak için 1'e ve ardýndan Enter'a basýn : ");
	        int  selecetion = scanner.nextInt();
	        if (selecetion != 1){
	            System.out.println("Hata :  doðrulama baþarýsýz");
	            return;
	        }
	        userDao.register(user);
		
	}

	@Override
	public void login(User user) {
		 if (user.getEmail() == null || user.getPassword() == null){
	            System.out.println("Sisteme giriþ yapmanýz için e-posta adresinizi ve þifrenizi girmeniz gerek.!");
	            return;
	        }
		 
		  if (userDao != null){
	            userDao.login(user);
	        }
	        if (authService != null){
	            authService.login(user);
	        }
		
	}

	@Override
	public void logout(User user) {
		System.out.println("Hesabýnýzdan çýkýþ yapýlýyor........ " + user.getName() + " " + user.getEmail());
		
	}

	@Override
	public User getByMail(String mail) {
		 return userDao.getByMail(mail);
	}

}
