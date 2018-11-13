package com.ltf.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author dreamneverdie
 *
 */
public class User {

    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "生日不能为空")
    @Past(message = "生日必须是在此之前的时间")
    private Date birthday;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



}
