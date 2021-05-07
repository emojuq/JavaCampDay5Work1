package dataAccess.concretes.InMemory;

import java.util.ArrayList;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	private ArrayList<User> users;
	
	
	public InMemoryUserDao(ArrayList<User> users) {
		
		this.users = users;
	}

	@Override
	public void register(User user) {
		System.out.println("kay�t olundu " + user.getName() + " " + user.getEmail());
		
	}

	@Override
	public void login(User user) {
		System.out.println("giri� yap�ld� " + user.getName() + " " + user.getEmail());
		
	}

	@Override
	public void logout(User user) {
		System.out.println("��k�� yap�ld� " + user.getName() + " " + user.getEmail());
		
	}

	@Override
	public User getByMail(String mail) {
		for(User user:users) {
			if(user.getEmail().equals(mail)) {}
			return user;
		}
		return null;		
	}

}
