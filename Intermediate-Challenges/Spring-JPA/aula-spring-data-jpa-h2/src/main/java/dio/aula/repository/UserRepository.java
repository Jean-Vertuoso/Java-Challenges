package dio.aula.repository;

import dio.aula.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{

    //Query Method
    List<User> findByNameContaining(String name);
    
    //Query Method
    User findByUsername(String username);
    
    //Query Override
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> findByName(@Param("name") String name);
    
}
