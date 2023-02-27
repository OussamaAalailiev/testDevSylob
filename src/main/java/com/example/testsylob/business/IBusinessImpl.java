package com.example.testsylob.business;

import com.example.testsylob.models.Fournisseur;
import com.example.testsylob.models.Ville;
import com.example.testsylob.repositories.FournisseurRepo;
import com.example.testsylob.repositories.VilleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Transactional
@Service
public class IBusinessImpl implements IBusiness{

    private final VilleRepo villeRepo;
    private final FournisseurRepo fournisseurRepo;

    public IBusinessImpl(VilleRepo villeRepo, FournisseurRepo fournisseurRepo){

        this.villeRepo = villeRepo;
        this.fournisseurRepo = fournisseurRepo;
    }

    @Override
    public Fournisseur addOneFournisseur(Fournisseur fournisseur) {
        try {
            if (fournisseur.getCode().isEmpty()){
                //Some data analysis ...
            }
            return fournisseurRepo.save(fournisseur);
        }catch (Exception e){
            e.printStackTrace();
        }
        return fournisseur;
    }

    @Override
    public String deleteOneFournisseur(Integer id) {
        try {
            Fournisseur fournisseur = fournisseurRepo.findById(id)
                    .orElseThrow(
                            () -> {
                                throw new RuntimeException("Fournisseur was not found from DB!");
                            }
                    );
            if (fournisseur.getCode().isEmpty()){
                //Some data analysis ...
            }
            fournisseurRepo.delete(fournisseur);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Success Deletion...";
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try {
            if (fournisseurRepo.findAll().isEmpty()){
                //Do something...
            }
             fournisseurs = fournisseurRepo.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fournisseurs;
    }

    @Override
    public List<Fournisseur> getAllFournisseursByVille(Integer villeId) {
        List<Fournisseur> fournisseursByVille = new ArrayList<>();
        try {
            if (fournisseurRepo.findFournisseursByVilleId(villeId).isEmpty()){
                //Do something...
            }
            fournisseursByVille = fournisseurRepo.findFournisseursByVilleId(villeId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return fournisseursByVille;
    }

    @Override
    public List<Ville> getAllVilles() {
        List<Ville> villes = new ArrayList<>();
        try {
            if (villeRepo.findAll().isEmpty()){
                //Do something...
            }
            villes = villeRepo.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return villes;
    }
}
