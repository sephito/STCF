package com.jeduce.stcf.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DOC_ROLE",uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id","authority"})})
public class Role implements Serializable {

	@Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ROLE")
    @SequenceGenerator(sequenceName = "id_role", initialValue = 1, allocationSize = 1, name = "ID_ROLE")
	private Long id;	

	private String authority;
	
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
