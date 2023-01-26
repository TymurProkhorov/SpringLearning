package tim.springLearning.springCore.javaCodeConfig.option2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("") здесь сканирования не будет, поэтому ни ComponentScan, ни Component-ов здесь не будет.
public class MyConfig {
    @Bean
    @Scope("singleton")
    public Cat catBean() {
        return new Cat();
    }

    // теперь внедрим зависимость кошки от пёрсон (в конструкторе пёрсона указывается эта зависимость)
    //Но сначала надо создать и бин пёрсона:
    @Bean
    public Person4 person4Bean() {
        return new Person4(catBean()); // вот здесь внедряется зависимость.
    }



}
