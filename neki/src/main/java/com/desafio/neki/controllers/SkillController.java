package com.desafio.neki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.neki.entities.Skill;
import com.desafio.neki.services.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

	 @Autowired
	    private SkillService skillService;

	    @GetMapping
	    public List<Skill> getSkills() {
	        return skillService.getSkills();
	    }

	    @GetMapping("/{skillId}")
	    public Skill getSkillById(@PathVariable Integer skillId) {
	        return skillService.getById(skillId);
	    }

	    @PostMapping
	    public Skill postSkill(@RequestBody Skill novaSkill) {
	        return skillService.postSkill(novaSkill);
	    }

	    @PutMapping("/{skillId}")
	    public Skill putSkill(@PathVariable Integer skillId, @RequestBody Skill skillAtualizada) {
	        return skillService.putSkill(skillId, skillAtualizada);
	    }

	    @DeleteMapping("/{skillId}")
	    public void deleteSkill(@PathVariable Integer skillId) {
	        skillService.deleteSkill(skillId);
	    }
}
