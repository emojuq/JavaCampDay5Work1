package core;

import entities.concretes.User;
import google.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{

	private final GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter(GoogleAuthManager googleAuthManager) {
		
		this.googleAuthManager = googleAuthManager;
	}

	@Override
	public void register(User user) {
		googleAuthManager.register(user);
		
	}

	@Override
	public void login(User user) {
		googleAuthManager.login(user);
		
	}

}
