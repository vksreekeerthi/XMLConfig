package com.hib.demoProj.Entities;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int stockid;
    @Column
    private String stockname;
    @Column
    private int price;

    public Stock() {
    }

    public Stock(String stockname, int price) {

        this.stockname = stockname;
        this.price = price;
    }

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    @ManyToMany(mappedBy = "stocks")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockid=" + stockid +
                ", stockname='" + stockname + '\'' +
                ", price=" + price +

                '}';
    }
}
