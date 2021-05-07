package google;

import entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user) {
		System.out.println("Kullanýcý Google ile kayýt oldu : " + user.getName() + " " + user.getEmail() );
	}
	
	public void login(User user) {
		System.out.println("Kullanýcý Google ile giriþ yaptý : " + user.getName() + " " + user.getEmail() );
	}
}
