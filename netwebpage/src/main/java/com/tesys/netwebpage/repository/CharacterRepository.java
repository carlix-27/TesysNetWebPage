package com.tesys.netwebpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tesys.netwebpage.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{
  
} 