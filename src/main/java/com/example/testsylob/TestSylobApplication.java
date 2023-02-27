package com.example.testsylob;

import com.example.testsylob.dataInit.IDataInit;
import com.example.testsylob.models.Fournisseur;
import com.example.testsylob.models.Ville;
import com.example.testsylob.repositories.FournisseurRepo;
import com.example.testsylob.repositories.VilleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class TestSylobApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSylobApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(VilleRepo villeRepo,
                             FournisseurRepo fournisseurRepo,
                             IDataInit iDataInit){
        return args -> {
            iDataInit.initVilles();
            iDataInit.initFournisseurs();

            List<Ville> villeList = villeRepo.findAll();
            //Get Fournisseur By villeID:
            fournisseurRepo.findFournisseursByVilleId(1).forEach(fournisseur -> {
                System.out.println("Fourniseur ID " + fournisseur.getId() + ", : Des: " + fournisseur.getDesignation());
            });
            //Create Fournisseur:
            Fournisseur f = new Fournisseur();
            f.setCode("aze11"); f.setDesignation("Atos"); f.setVille(villeList.get(new Random().nextInt(villeList.size())));
            fournisseurRepo.save(f);

            //Delete Fournisseur:
            fournisseurRepo.delete(f);
        };
    }

}
