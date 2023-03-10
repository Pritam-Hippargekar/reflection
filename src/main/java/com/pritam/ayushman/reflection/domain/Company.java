package com.pritam.ayushman.reflection.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "company")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval = true)
    private List<Branch> branches = null;

    public void addBranches(Branch branch){
        if(branch !=null){
            if (branches == null) {
                branches = new ArrayList<>();
            }
            branches.add(branch);
            branch.setCompany(this);
        }
    }

    public void removeBranches(Branch branch){
        if(branch !=null){
            branch.setCompany(null);
        }
        branches.remove(branch);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
