package Yotoqxona;

import Yotoqxona.entity.Role;
import Yotoqxona.entity.User;
import Yotoqxona.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = new User();
		user.setName("Uchqun");
		user.setSurname("Shonazarov");
		user.setAktiv(true);
		user.setLogin("admin");
		user.setPassword(passwordEncoder.encode("admin"));
		user.setRoles(Set.of(Role.ADMIN,Role.MANAGER));
		userRepository.save(user);
	}
}
