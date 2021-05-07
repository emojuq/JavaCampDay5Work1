import java.util.ArrayList;
import java.util.Scanner;


import business.concretes.UserManager;
import core.GoogleAuthManagerAdapter;
import dataAccess.concretes.InMemory.InMemoryUserDao;
import entities.concretes.User;
import google.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("1 - Giri� Yap \n2 - Kay�t Ol");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yapmak istedi�iniz i�lemi se�iniz");
        int selection = scanner.nextInt();
        if(selection == 1){

            System.out.println("1 - Google \n2 - Mail & Password");
            Scanner sc = new Scanner(System.in);
            System.out.println("Giri� Y�ntemi Se�iniz : ");
            int selection2 = sc.nextInt();
            if (selection2 == 1){
                User user = new User();
                user.setEmail("emreaydin@gmail.com");
                User user2 = new User();
                user2.setEmail("yunuskeles@gmail.com");
                user2.setPassword("123456");

                UserManager userManager = new UserManager(null,new GoogleAuthManagerAdapter(new GoogleAuthManager()));
                userManager.login(user);
                userManager.login(user2);
            }else if (selection2 == 2){
                User user = new User();
                user.setEmail("emreaydin@gmail.com");
                User user2 = new User();
                user2.setEmail("yunuskeles@gmail.com");
                user2.setPassword("123456");

                ArrayList<User> users = new ArrayList<>();
                UserManager userManager = new UserManager(new InMemoryUserDao(users), null);
                userManager.login(user);
                userManager.login(user2);
            }
        }
        else if (selection == 2) {

            ArrayList<User> users = new ArrayList<>();
            UserManager userManager = new UserManager(new InMemoryUserDao(users), null);
            User user = new User(1, "Emre", "Ayd�n", "emreaydin@gmail.com", "123456");
            User user2 = new User(2, "Yunus", "Kele�", "yunuskeles@gmail.com", "654321");
            userManager.register(user);
            userManager.register(user2);
        }
		
	}

}
