package tim.springLearning.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("tim.springLearning.aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
