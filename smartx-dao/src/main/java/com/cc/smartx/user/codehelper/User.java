package com.cc.smartx.user.codehelper;

import java.io.Serializable;

public class User implements Serializable {
    /**
	* 主键id
	*/
    private Long id;

    /**
	* 姓名
	*/
    private String name;

    /**
	* 年龄
	*/
    private Integer age;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append("]");
        return sb.toString();
    }
}