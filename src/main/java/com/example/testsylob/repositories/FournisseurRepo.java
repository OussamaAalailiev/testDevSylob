package com.example.testsylob.repositories;

import com.example.testsylob.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepo extends JpaRepository<Fournisseur, Integer> {
    List<Fournisseur> findFournisseursByVilleId(Integer villeId);
}
