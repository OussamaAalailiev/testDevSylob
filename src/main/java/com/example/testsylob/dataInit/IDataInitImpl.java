package com.example.testsylob.dataInit;

import com.example.testsylob.models.Fournisseur;
import com.example.testsylob.models.Ville;
import com.example.testsylob.repositories.FournisseurRepo;
import com.example.testsylob.repositories.VilleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Transactional
@Service
public class IDataInitImpl implements IDataInit {
    private final VilleRepo villeRepo;
    private final FournisseurRepo fournisseurRepo;

    public IDataInitImpl(VilleRepo villeRepo, FournisseurRepo fournisseurRepo){

        this.villeRepo = villeRepo;
        this.fournisseurRepo = fournisseurRepo;
    }

    @Override
    public void initVilles() {
        Stream.of("Casablanca", "Tanger", "Agadir")
                .forEach(villeName -> {
                    Ville ville = new Ville();
                    ville.setName(villeName);
                    villeRepo.save(ville);
                });
    }

    @Override
    public void initFournisseurs() {
        List<Ville> villes = villeRepo.findAll();
        String [] codeToGenerateFrom = {"azerqsdfwxcv", "qssdshd", "qsfgqsf", "ypuoyghlgk"};
        Stream.of("Sylob", "Campony2", "Campony3", "Campony4")
                .forEach(des -> {
                    Fournisseur fournisseur = new Fournisseur();
//                        int randomCode = new Random().nextInt(codeToGenerateFrom.length());
                    fournisseur.setCode(codeToGenerateFrom[new Random().nextInt(codeToGenerateFrom.length)]);
                    fournisseur.setDesignation(des);
                    fournisseur.setVille(villes.get(new Random().nextInt(villes.size())));
                    fournisseurRepo.save(fournisseur);
                });
    }
}
