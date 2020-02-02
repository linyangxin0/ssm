package cn.itcast.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String user_name;
    private Integer sex;
    private Integer age;
    private String mobile_phone;
    private String password;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
