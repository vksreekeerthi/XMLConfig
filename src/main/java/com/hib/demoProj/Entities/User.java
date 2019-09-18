
package com.hib.demoProj.Entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    private int userid;
    @Column
    private String username;


    public User(int userid, Set<Stock> stocks) {
        this.userid = userid;
        this.stocks = stocks;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name="user_stock",
            joinColumns=@JoinColumn(name="userid"),
            inverseJoinColumns=@JoinColumn(name="stockid")
    )
    private Set<Stock> stocks=new HashSet<Stock>();
    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}

