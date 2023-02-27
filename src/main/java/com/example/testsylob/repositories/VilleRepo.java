package com.example.testsylob.repositories;

import com.example.testsylob.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepo extends JpaRepository<Ville, Integer> {
}
