package presentation;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao","metier","config"})
public class Presentation2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();


        // Choix 1 (profils) : décommenter un profil pour tester
        //ctx.getEnvironment().setActiveProfiles("dev");   // -> DaoImpl2 (150) => 300
        // ctx.getEnvironment().setActiveProfiles("prod");  // -> DaoImpl  (100) => 200
        ctx.getEnvironment().setActiveProfiles("file");  // -> DaoFile  (180) => 360
        // ctx.getEnvironment().setActiveProfiles("api");   // -> DaoApi   (220) => 440

        ctx.register(Presentation2.class);
        ctx.refresh();

        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
        ctx.close();
    }
}