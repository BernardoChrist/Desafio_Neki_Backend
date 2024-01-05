package com.desafio.neki.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idskill")
	private Integer idskill;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "imagem")
	private String imagem;

	@Column(name = "level")
	private String level;

	@OneToMany(mappedBy = "skill")
	private List<UserSkill> userSkills;

	public Integer getIdskill() {
		return idskill;
	}

	public void setIdskill(Integer idskill) {
		this.idskill = idskill;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<UserSkill> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkill> userSkills) {
		this.userSkills = userSkills;
	}

	public Skill() {
		super();
	}

	public Skill(Integer idskill, String nome, String descricao, String imagem, String level,
			List<UserSkill> userSkills) {
		super();
		this.idskill = idskill;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.level = level;
		this.userSkills = userSkills;
	}

}
