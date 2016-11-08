package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@Import(value=DataConfig.class)
@ComponentScan(basePackages={"spittr"},	excludeFilters=@Filter(value=Controller.class))
public class RootConfig {

}
