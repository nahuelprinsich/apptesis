package com.tesis.bo.impl;

import com.tesis.bo.GenericBO;
import com.tesis.bo.ItemBO;
import com.tesis.dao.ItemDAO;
import com.tesis.models.Item;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ItemBOImpl extends GenericBOImpl<Item> implements ItemBO {

    private ItemDAO itemDAO;

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
}
