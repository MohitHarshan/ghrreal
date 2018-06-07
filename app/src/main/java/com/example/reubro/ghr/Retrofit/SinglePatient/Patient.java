
package com.example.reubro.ghr.Retrofit.SinglePatient;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Patient {

    @SerializedName("basic_info")
    @Expose
    private List<BasicInfo> basicInfo = null;
    @SerializedName("followup")
    @Expose
    private List<Followup> followup = null;

    public List<BasicInfo> getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(List<BasicInfo> basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<Followup> getFollowup() {
        return followup;
    }

    public void setFollowup(List<Followup> followup) {
        this.followup = followup;
    }

}
