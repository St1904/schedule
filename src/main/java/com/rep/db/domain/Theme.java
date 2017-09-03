package com.rep.db.domain;

import javax.persistence.*;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "theme")
public class Theme extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_subject", foreignKey = @ForeignKey(name = "fk_theme_subject"))
    private Subject subject;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "id_parent_theme")
    private Long idParentTheme;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getIdParentTheme() {
        return idParentTheme;
    }

    public void setIdParentTheme(Long idParentTheme) {
        this.idParentTheme = idParentTheme;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "subject=" + subject +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", idParentTheme=" + idParentTheme +
                '}';
    }

   /* //TODO delete this!
    @OneToMany(mappedBy = "theme")
    private Set<Journal> journal = new HashSet<>();

    public Set<Journal> getJournal() {
        return journal;
    }

    public void setJournal(Set<Journal> journal) {
        this.journal = journal;
    }*/

    public Theme() {
    }
}
