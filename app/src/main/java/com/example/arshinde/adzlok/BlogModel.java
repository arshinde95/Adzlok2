package com.example.arshinde.adzlok;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by arshinde on 22-02-2019.
 */

public class BlogModel implements Serializable{
    private static final long serialVersionUID=1234567890;
    private String name;
    private Vector image;
    private String desc;
    private String title;
    private String location;
    public BlogModel(Vector image,String name,String title, String desc,String location)
    {
      //  this.image=image;
        this.name=name;
        this.title=title;
        this.desc=desc;
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getImage() {
        return image;
    }

//    public void setImage(String image) {
  //      this.image = image;
   // }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle()
    {
        return title;
    }

    public String getLocation()
    {
        return location;
    }
}
