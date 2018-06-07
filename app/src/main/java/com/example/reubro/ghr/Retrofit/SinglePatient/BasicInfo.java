
package com.example.reubro.ghr.Retrofit.SinglePatient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicInfo {

    @SerializedName("category1")
    @Expose
    private List<Category1> category1 = null;
    @SerializedName("category2")
    @Expose
    private List<Category2> category2 = null;
    @SerializedName("category3")
    @Expose
    private List<Category3> category3 = null;
    @SerializedName("category4")
    @Expose
    private List<Category4> category4 = null;
    @SerializedName("category5")
    @Expose
    private List<Category5> category5 = null;
    @SerializedName("category6")
    @Expose
    private List<Category6> category6 = null;
    @SerializedName("category7")
    @Expose
    private List<Category7> category7 = null;
    @SerializedName("category8")
    @Expose
    private List<Category8> category8 = null;
    @SerializedName("category9")
    @Expose
    private List<Category9> category9 = null;

    public List<Category1> getCategory1() {
        return category1;
    }

    public void setCategory1(List<Category1> category1) {
        this.category1 = category1;
    }

    public List<Category2> getCategory2() {
        return category2;
    }

    public void setCategory2(List<Category2> category2) {
        this.category2 = category2;
    }

    public List<Category3> getCategory3() {
        return category3;
    }

    public void setCategory3(List<Category3> category3) {
        this.category3 = category3;
    }

    public List<Category4> getCategory4() {
        return category4;
    }

    public void setCategory4(List<Category4> category4) {
        this.category4 = category4;
    }

    public List<Category5> getCategory5() {
        return category5;
    }

    public void setCategory5(List<Category5> category5) {
        this.category5 = category5;
    }

    public List<Category6> getCategory6() {
        return category6;
    }

    public void setCategory6(List<Category6> category6) {
        this.category6 = category6;
    }

    public List<Category7> getCategory7() {
        return category7;
    }

    public void setCategory7(List<Category7> category7) {
        this.category7 = category7;
    }

    public List<Category8> getCategory8() {
        return category8;
    }

    public void setCategory8(List<Category8> category8) {
        this.category8 = category8;
    }

    public List<Category9> getCategory9() {
        return category9;
    }

    public void setCategory9(List<Category9> category9) {
        this.category9 = category9;
    }

}
