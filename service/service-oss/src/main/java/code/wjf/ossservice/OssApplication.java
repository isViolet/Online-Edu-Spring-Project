package code.wjf.ossservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

//oss模块不需要用到数据库，所以去除它的配置，不然启动会默认加载数据库配置而报错
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//跨域
@CrossOrigin
/*
如果类中用了@Controller，@Repository，@Service,@Component四大注解标识之一了，
那么如果不加上@ComponentScan，Spring就不会自动扫描类上的四大注解中的任何一个，
那么四大注解下的类就不会被Spring扫描到，更不会装入Spring容器中，因此你配置的四大注解就失去了作用。
 */
@ComponentScan({"code.wjf"})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }

}
