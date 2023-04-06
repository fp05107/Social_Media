package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Page {

	@Id
	private Long id;

	@ManyToMany
	@JoinTable(name = "page_followers", joinColumns = @JoinColumn(name = "page_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> followers;

}
