package com.nahuelcuello.portfolio.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Long id;

    @Column(name = "name_project", nullable = false, length = 100)
    private String nameProject;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @ElementCollection
    @CollectionTable(
        name = "project_languages",
        joinColumns = @JoinColumn(name = "project_id")
    )
    @Column(name = "language", nullable = false, length = 50)
    private List<String> languages;

    @Column(name = "url_demo")
    private String urlDemo;

    @Column(name = "url_git_front")
    private String urlGitFront;

    @Column(name = "url_git_back")
    private String urlGitBack;

    @Column(name = "url_public_front")
    private String urlPublicFront;

    @Column(name = "url_public_back")
    private String urlPublicBack;

    //  Relación con User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;
}
