package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Like {

	@Id
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Post post;
    
    @ManyToOne
    private Comment comment;
	
}
