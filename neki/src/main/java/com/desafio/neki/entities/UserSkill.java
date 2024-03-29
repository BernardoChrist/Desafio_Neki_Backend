package com.desafio.neki.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userskills")
public class UserSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_skill", insertable = false, updatable = false)
	private Integer idUserSkill;

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "idskill", referencedColumnName = "idskill")
	private Skill skill;

	public Integer getId() {
		return idUserSkill;
	}

	public void setId(Integer id) {
		this.idUserSkill = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public UserSkill() {
		super();
	}

	public UserSkill(Integer id, User user, Skill skill) {
		super();
		this.idUserSkill = id;
		this.user = user;
		this.skill = skill;
	}

}
