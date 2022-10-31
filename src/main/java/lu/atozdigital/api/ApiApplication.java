package lu.atozdigital.api;

import lu.atozdigital.api.Entities.Article;
import lu.atozdigital.api.Entities.Ordr;
import lu.atozdigital.api.Entities.User;
import lu.atozdigital.api.Repositories.ArticleRepo;
import lu.atozdigital.api.Repositories.OrderRepo;
import lu.atozdigital.api.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	@Autowired
	private ArticleRepo articleRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private OrderRepo orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User usr1 = new User("Hassani", "passwordd123");
		userRepo.save(usr1);
		User usr2 = new User("Abderrahman", "passwordd123");
		userRepo.save(usr2);

//		Article art1 =  new Article("sberdilaJumia", 200, "hassani.png");
//		Article art2 =  new Article("sberdilaJumia", 200, "hassani.png");
//		Article art3 =  new Article("sberdilaJumia", 200, "hassani.png");
//
//		ArrayList<Article> list = new ArrayList<>();
//
//		list.add(art1);
//		list.add(art2);
//		list.add(art3);
//
//		articleRepo.save(art1);
//		articleRepo.save(art2);
//		articleRepo.save(art3);


		//orderRepo.save(new Ordr("refreenceees_1", new Date(12/22/2003) ,art1));
	}
}
