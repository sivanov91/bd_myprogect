package com.myproject.web.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: lnex
 * Date: 21.07.13
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */

/*
CREATE TABLE CATEGORY
(
	CATEGORY_ID  INTEGER NULL,
	NAME  VARCHAR(32) NULL,
	DESCRIPTION  VARCHAR(64) NULL,
	PARENT  INTEGER NULL
)
;
 */


@NamedQueries({
        @NamedQuery(name = "category.getById", query = "from Category where categoryId =:id"),
        @NamedQuery(name = "category.getByIdentifier", query = "from Category where identifier =:identifier")
})

@Entity
@Table(name = "CATEGORY")
public class Category {

    private Long categoryId;
    private String name;
    private String description;
    private String identifier;
    private Long parent;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "CATEGORY_ID")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "IDENTIFIER")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    @Column(name = "PARENT")
    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

}