
package com.example.reubro.ghr.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("Category4")
    @Expose
    private Category4_ category4;
    @SerializedName("Category3")
    @Expose
    private Category3_ category3;
    @SerializedName("Category5")
    @Expose
    private Category5_ category5;
    @SerializedName("Category6")
    @Expose
    private Category6_ category6;
    @SerializedName("Category8")
    @Expose
    private Category8_ category8;
    @SerializedName("Category9")
    @Expose
    private Category9_ category9;
    @SerializedName("Category7")
    @Expose
    private Category7_ category7;

    public Category4_ getCategory4() {
        return category4;
    }

    public void setCategory4(Category4_ category4) {
        this.category4 = category4;
    }

    public Category3_ getCategory3() {
        return category3;
    }

    public void setCategory3(Category3_ category3) {
        this.category3 = category3;
    }

    public Category5_ getCategory5() {
        return category5;
    }

    public void setCategory5(Category5_ category5) {
        this.category5 = category5;
    }

    public Category6_ getCategory6() {
        return category6;
    }

    public void setCategory6(Category6_ category6) {
        this.category6 = category6;
    }

    public Category8_ getCategory8() {
        return category8;
    }

    public void setCategory8(Category8_ category8) {
        this.category8 = category8;
    }

    public Category9_ getCategory9() {
        return category9;
    }

    public void setCategory9(Category9_ category9) {
        this.category9 = category9;
    }

    public Category7_ getCategory7() {
        return category7;
    }

    public void setCategory7(Category7_ category7) {
        this.category7 = category7;
    }

}
