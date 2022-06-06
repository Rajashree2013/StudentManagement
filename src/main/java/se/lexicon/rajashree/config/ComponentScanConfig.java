package se.lexicon.rajashree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.lexicon.rajashree")
public class ComponentScanConfig {

    @Bean({"scanner"})
    public Scanner getscanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
