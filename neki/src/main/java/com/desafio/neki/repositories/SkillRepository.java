package com.desafio.neki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.neki.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

}
