package galdino.examplelistshotsapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Galdino on 22/12/2017.
 */

public class Shot
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Images getImages() {
        return images;
    }



    public Integer getViewsCount() {
        return viewsCount;
    }


    public String getCreatedAt() {
        return createdAt;
    }
}
