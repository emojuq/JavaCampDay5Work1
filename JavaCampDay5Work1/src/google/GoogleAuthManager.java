package google;

import entities.concretes.User;

public class GoogleAuthManager {
	public void register(User user) {
		System.out.println("Kullan�c� Google ile kay�t oldu : " + user.getName() + " " + user.getEmail() );
	}
	
	public void login(User user) {
		System.out.println("Kullan�c� Google ile giri� yapt� : " + user.getName() + " " + user.getEmail() );
	}
}
