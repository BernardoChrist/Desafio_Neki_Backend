package com.desafio.neki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.neki.entities.Skill;
import com.desafio.neki.entities.UserSkill;
import com.desafio.neki.services.UserSkillService;

@RestController
@RequestMapping("/userskills")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserSkill>> getSkillsByUserId(@PathVariable Integer userId) {
        List<UserSkill> userSkills = userSkillService.getSkillsByUserId(userId);
        return ResponseEntity.ok(userSkills);
    }

    @PostMapping("/associate")
    public ResponseEntity<UserSkill> associateSkill(@RequestParam Integer userId, @RequestBody Skill skill, @RequestParam String level) {
        UserSkill userSkill = userSkillService.associateSkill(userId, skill, level);
        return ResponseEntity.ok(userSkill);
    }

    @PutMapping("/update/{userSkillId}")
    public ResponseEntity<UserSkill> updateSkillAssociation(@PathVariable Integer userSkillId, @RequestParam String newLevel) {
        UserSkill updatedUserSkill = userSkillService.updateSkillAssociation(userSkillId, newLevel);
        return ResponseEntity.ok(updatedUserSkill);
    }

    @DeleteMapping("/delete/{userSkillId}")
    public ResponseEntity<Void> deleteSkillAssociation(@PathVariable Integer userSkillId) {
        userSkillService.deleteSkillAssociation(userSkillId);
        return ResponseEntity.noContent().build();
    }
}

