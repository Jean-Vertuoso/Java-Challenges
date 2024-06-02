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
        
        User jean = new User();
        User bruna = new User();
        
        jean.setName("Jean");
        jean.setUsername("jvertuos");
        jean.setPassword("123");
        
        bruna.setName("Bruna");
        bruna.setUsername("brnfp");
        bruna.setPassword("456");
        
        repository.save(jean);
        repository.save(bruna);
        
        for (User u : repository.findAll()) {
            System.out.println(u);
        }
        
    }
    
}