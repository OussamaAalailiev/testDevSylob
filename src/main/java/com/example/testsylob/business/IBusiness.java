package com.example.testsylob.business;

import com.example.testsylob.models.Fournisseur;
import com.example.testsylob.models.Ville;

import java.util.List;

public interface IBusiness {
    Fournisseur addOneFournisseur(Fournisseur fournisseur);
    String deleteOneFournisseur(Integer id);
    List<Fournisseur> getAllFournisseurs();
    List<Fournisseur> getAllFournisseursByVille(Integer villeId);
    List<Ville> getAllVilles();
}
