package com.jiyun.bean;

import com.jiyun.util.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 灵风 on 2019/4/23.
 */
@Entity
public class StoriesEntity {
    @Id
    private Long _id;
    @Convert(columnType = String.class,converter = StringConverter.class)
    private List<String> images;
    private String ga_prefix;
    private boolean multipic;
    private int id;
    private String title;
    private int type;

    @Generated(hash = 2110692433)
    public StoriesEntity(Long _id, List<String> images, String ga_prefix,
            boolean multipic, int id, String title, int type) {
        this._id = _id;
        this.images = images;
        this.ga_prefix = ga_prefix;
        this.multipic = multipic;
        this.id = id;
        this.title = title;
        this.type = type;
    }

    @Generated(hash = 214166461)
    public StoriesEntity() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean getMultipic() {
        return this.multipic;
    }
}
