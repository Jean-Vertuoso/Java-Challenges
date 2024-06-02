package dio.aula;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApp implements CommandLineRunner{

    @Autowired
    private UserRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
       
        List<User> users = repository.findByNameContaining("José");
        
        for (User user : users) {
            System.out.println(user);
        }
        
    }
    
}