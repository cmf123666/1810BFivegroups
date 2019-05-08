package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class RenterBean implements Serializable {
       private String rid;//编号
       private String renterNumber;//账单房号
       private String renterName;//付款方
       private String billCount;//账单金额
       private String billType;//与账单类型关联
       @DateTimeFormat(pattern = "yyyy-MM-dd")
       @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
       private Date payDate;//预计付款时间
       private String payType;//付款方式



       //账单地址
       private String renterLocation;

       private String zhiquId;
       @DateTimeFormat(pattern = "yyyy-MM-dd")
       @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
       private Date startDate;//预计付款时间

       @DateTimeFormat(pattern = "yyyy-MM-dd")
       @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
       private Date endData;//预计付款时间

       private  String status;//状态
       private String num;

       private String water;//水表
       private String dian;//电表
       private  String qi;//气表

       //关联id
       private  String renterId;
       private String sphone;//联系方式
       private String sidentity;//身份证号码
       private String surgencyPhone;//紧急联系人
       private  Integer srent;//租金
       private  Integer  syajin;//押金

       private String mayId;
       private String spayName;//房租支付方式

       private  String temp;
}
