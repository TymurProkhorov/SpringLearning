package tim.springLearning.springCore.javaCodeConfig.option1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("tim.springLearning.springCore.javaCodeConfig.option1")
public class MyConfig { // DI здесь происходит автоматически с помощью конструктора Person3 (если ему конечно добавить пар-ы)
}
