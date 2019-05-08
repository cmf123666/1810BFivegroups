package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserBean implements Serializable {
        private String uid;//id
        private String userId;//用户账号
        private String userPassword;//用户密码
        private String postId;//角色关联
        private String postName;//角色name
        private String mail;//邮箱
        private String phoneNumber;//手机号码
        private String shouId;//关联的收取钱的id；对应租客表
        private String zhiId;//关联的是支付房东的id，对应房东表
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
        private Date endTime;
        private String userName;//使用人
}
