/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Shop;
import facade.ShopFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author lwang
 */
@Named(value = "shopEntryBean")
@RequestScoped
public class ShopEntryBean {

    private Shop shop;
    private String message;

    @EJB
    private ShopFacade shopFacade;
    @Inject
    private ShopViewBean shopViewBean;

    /**
     * Creates a new instance of ShopEntryBean
     */
    public ShopEntryBean() {
        this.shop = new Shop();
    }

    public String newShop() {
        if (shopFacade.check(shop.getShopName())) {
            shopFacade.create(shop);
            shopViewBean.setShop(shop);
            shopViewBean.setMessage("店舗を新規登録しました");
            return "shopinfo";
        } else {
            this.message = "同じ名前の店舗が存在してます。";
            return "newshop";
        }
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
