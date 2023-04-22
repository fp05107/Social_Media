package com.socialmedia.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    // Other post properties
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;
    
    /**
     * 
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Media> media;
    
    /**
     * 
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Tag> tags;
    
    // Getters and setters
}
