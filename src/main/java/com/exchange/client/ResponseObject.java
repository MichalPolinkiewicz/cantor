package com.exchange.client;

import java.util.List;

/**
 * Created by Lenovo on 01.02.2018.
 */
public class ResponseObject {

    private String publicationDate;
    private List<Item> items;

    public String getPublicationDate() {
        return publicationDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
