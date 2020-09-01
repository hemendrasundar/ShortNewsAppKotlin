
package com.hemendra.shortnews.Models;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Item {

    @SerializedName("Category")
    private String mCategory;
    @SerializedName("ImageUrl")
    private String mImageUrl;
    @SerializedName("NewsUrl")
    private String mNewsUrl;
    @SerializedName("Title")
    private String mTitle;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getNewsUrl() {
        return mNewsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        mNewsUrl = newsUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
