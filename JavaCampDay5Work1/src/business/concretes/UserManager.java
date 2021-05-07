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
            System.out.println("l�tfen �ifrenizi en az 6 karakter uzunlu�unda giriniz.");
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
	            System.out.println("l�tfen sistemde kay�tl� olmayan bir e-posta ile giri� yap�n�z");
	            return;
	            
	        }
	        
	        if (user.getName().length() < 2 || user.getLastName().length() < 2){
	            System.out.println(""
	            		+ "l�tfen a�a��daki kurallara uyarak kay�t olunuz"
	            		+ "1- �sminiz en az 2 karakter olmal�." );
	            return;
	        }
	        
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("G�nderilen e postay� do�rulamak i�in 1'e ve ard�ndan Enter'a bas�n : ");
	        int  selecetion = scanner.nextInt();
	        if (selecetion != 1){
	            System.out.println("Hata :  do�rulama ba�ar�s�z");
	            return;
	        }
	        userDao.register(user);
		
	}

	@Override
	public void login(User user) {
		 if (user.getEmail() == null || user.getPassword() == null){
	            System.out.println("Sisteme giri� yapman�z i�in e-posta adresinizi ve �ifrenizi girmeniz gerek.!");
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
		System.out.println("Hesab�n�zdan ��k�� yap�l�yor........ " + user.getName() + " " + user.getEmail());
		
	}

	@Override
	public User getByMail(String mail) {
		 return userDao.getByMail(mail);
	}

}
