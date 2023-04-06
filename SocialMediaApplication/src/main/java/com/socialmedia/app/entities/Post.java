package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Post {

	@Id
	private Long id;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "post")
	private List<Comment> comments;

	@ManyToMany
	@JoinTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	@ManyToMany(mappedBy = "likedPosts")
	private List<User> likedBy;

}
