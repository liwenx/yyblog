package com.yy.blog.domain.user;

import java.io.Serializable;

/**
 * @author liwenxing
 * @date 2018/1/9 21:22
 */
public class User  implements Serializable{
    private static final long serialVersionUID = 1L;
    //主键
    private String id;
    //姓名
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
