package com.authenticationServer.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Permission extends BaseIdEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}