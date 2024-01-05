package com.desafio.neki.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.neki.entities.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {

	List<UserSkill> findByUserId(Integer userId);

}
