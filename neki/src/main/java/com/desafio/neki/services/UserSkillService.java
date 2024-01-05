package com.desafio.neki.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.neki.entities.Skill;
import com.desafio.neki.entities.User;
import com.desafio.neki.entities.UserSkill;
import com.desafio.neki.repositories.UserRepository;
import com.desafio.neki.repositories.UserSkillRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserSkillService {

    @Autowired
    private UserSkillRepository userSkillRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<UserSkill> getSkillsByUserId(Integer userId) {
        return userSkillRepository.findByUserId(userId);
    }
    
    public UserSkill associateSkill(Integer userId, Skill skill, String level) {
        UserSkill userSkill = new UserSkill();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        userSkill.setUser(user);
        userSkill.setSkill(skill);
        skill.setLevel(level);

        return userSkillRepository.save(userSkill);
    }
    
    public UserSkill updateSkillAssociation(Integer userSkillId, String newLevel) {
        UserSkill userSkill = userSkillRepository.findById(userSkillId)
                .orElseThrow(() -> new EntityNotFoundException("UserSkill not found with id: " + userSkillId));

        Skill skill = userSkill.getSkill();
        skill.setLevel(newLevel);

        return userSkillRepository.save(userSkill);
    }
    
    public void deleteSkillAssociation(Integer userSkillId) {
        userSkillRepository.deleteById(userSkillId);
    }

}
