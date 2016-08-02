/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Shop;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lwang
 */
@Stateless
public class ShopFacade extends AbstractFacade<Shop> {

    @PersistenceContext(unitName = "BacchusPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShopFacade() {
        super(Shop.class);
    }

    public void thumbUp(Shop shop) {
        Integer currentFav = shop.getShopFavorite();
        if (currentFav == null) {
            currentFav = 0;
        }
        shop.setShopFavorite(++currentFav);
        em.merge(shop);
    }

    public List<Shop> sort() {
        return em.createNamedQuery("Shop.findAllOrderByFav").getResultList();

    }

    public boolean check(String shopName) {
        Shop shop = em.createNamedQuery("Shop.findByShopName", Shop.class)
                .setParameter("shopName", shopName)
                .getResultList().get(0);
        if (shop != null) {
            return false;
        }
        return true;
    }

}
