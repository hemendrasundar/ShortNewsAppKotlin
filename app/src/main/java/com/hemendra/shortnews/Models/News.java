
package com.hemendra.shortnews.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("items")
    private List<Item> mItems;

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }

}
