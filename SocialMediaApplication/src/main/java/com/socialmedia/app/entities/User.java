package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
public class User {

	@Id
	private Long id;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	@ManyToMany
	@JoinTable(name = "user_follows", joinColumns = @JoinColumn(name = "follower_id"), inverseJoinColumns = @JoinColumn(name = "followed_id"))
	private List<User> followedUsers;

	@ManyToMany(mappedBy = "followedUsers")
	private List<User> followers;

	@ManyToMany(mappedBy = "likedBy")
	private List<Post> likedPosts;

	@ManyToMany(mappedBy = "likedBy")
	private List<Comment> likedComments;

	@OneToMany(mappedBy = "sender")
	private List<Message> sentMessages;

	@OneToMany(mappedBy = "recipient")
	private List<Message> receivedMessages;

	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;

	@ManyToMany(mappedBy = "participants")
	private List<Chat> chats;

	@ManyToMany(mappedBy = "members")
	private List<Group> groups;

	@ManyToMany(mappedBy = "attendees")
	private List<Event> eventsAttended;

	@ManyToMany(mappedBy = "followers")
	private List<Page> pagesFollowed;

}
