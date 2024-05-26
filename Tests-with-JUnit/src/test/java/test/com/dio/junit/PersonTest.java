package test.com.dio.junit;

import com.dio.junit.model.Person;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {
        
    @Test
    public void validateAgeCalc(){
    //esse teste irá passar pois indica que uma pessoa nascida na data informada+
    //+possui 26 anos.
        Person jean = new Person("Jean", LocalDateTime.of(1997, 12, 26, 15, 0, 0));
        Assertions.assertEquals(26, jean.getAge());
    }
    
    @Test
    //neste caso irá falhar o teste, pois indica que uma pessoa nascida em 2015+
    //+não é maior de idade.
    public void validateIsOfLegalAge(){
        Person jean = new Person("Jean", LocalDateTime.of(2015, 12, 26, 15, 0, 0));
        Assertions.assertTrue(jean.isOfLegalAge());
    }
        
}
