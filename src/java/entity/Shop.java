/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lwang
 */
@Entity
@Table(name = "shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s"),
    @NamedQuery(name = "Shop.findAllOrderByFav", query = "SELECT s FROM Shop s ORDER BY s.shopFavorite DESC"),
    @NamedQuery(name = "Shop.findById", query = "SELECT s FROM Shop s WHERE s.id = :id"),
    @NamedQuery(name = "Shop.findByShopName", query = "SELECT s FROM Shop s WHERE s.shopName = :shopName"),
    @NamedQuery(name = "Shop.findByShopAddress1", query = "SELECT s FROM Shop s WHERE s.shopAddress1 = :shopAddress1"),
    @NamedQuery(name = "Shop.findByShopAddress2", query = "SELECT s FROM Shop s WHERE s.shopAddress2 = :shopAddress2"),
    @NamedQuery(name = "Shop.findByShopFavorite", query = "SELECT s FROM Shop s WHERE s.shopFavorite = :shopFavorite"),
    @NamedQuery(name = "Shop.findByShopUrl", query = "SELECT s FROM Shop s WHERE s.shopUrl = :shopUrl")})
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "shop_name")
    private String shopName;
    @Size(max = 50)
    @Column(name = "shop_address1")
    private String shopAddress1;
    @Size(max = 50)
    @Column(name = "shop_address2")
    private String shopAddress2;
    @Column(name = "shop_favorite")
    private Integer shopFavorite;
    @Size(max = 100)
    @Column(name = "shop_url")
    private String shopUrl;

    public Shop() {
    }

    public Shop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress1() {
        return shopAddress1;
    }

    public void setShopAddress1(String shopAddress1) {
        this.shopAddress1 = shopAddress1;
    }

    public String getShopAddress2() {
        return shopAddress2;
    }

    public void setShopAddress2(String shopAddress2) {
        this.shopAddress2 = shopAddress2;
    }

    public Integer getShopFavorite() {
        return shopFavorite;
    }

    public void setShopFavorite(Integer shopFavorite) {
        this.shopFavorite = shopFavorite;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shop[ id=" + id + " ]";
    }
    
}
