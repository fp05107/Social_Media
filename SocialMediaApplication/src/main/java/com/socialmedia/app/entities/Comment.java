package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity 
public class Comment {

	@Id
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Post post;
    
    @OneToMany(mappedBy = "comment")
    private List<Like> likes;
    
    @ManyToMany(mappedBy = "likedComments")
    private List<User> likedBy;
	
}
