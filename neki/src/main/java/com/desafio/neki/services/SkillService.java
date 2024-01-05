package com.desafio.neki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.neki.entities.Skill;
import com.desafio.neki.repositories.SkillRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepo;

	public List<Skill> getSkills() {
		return skillRepo.findAll();
	}

	public Skill getById(Integer skillid) {
		return skillRepo.findById(skillid).orElse(null);
	}

	public Skill postSkill(Skill novaSkill) {
		return skillRepo.save(novaSkill);
	}

	public Skill putSkill(Integer skillId, Skill skillAtualizada) {
		return skillRepo.findById(skillId).map(skillExistente -> {
			skillExistente.setNome(skillAtualizada.getNome());
			skillExistente.setDescricao(skillAtualizada.getDescricao());
			return skillRepo.save(skillExistente);
		}).orElseThrow(() -> new EntityNotFoundException("Skill not found"));
	}

	public void deleteSkill(Integer skillId) {
		Skill skillExistente = skillRepo.findById(skillId)
				.orElseThrow(() -> new EntityNotFoundException("Skill not found"));

		skillRepo.delete(skillExistente);
	}

}
