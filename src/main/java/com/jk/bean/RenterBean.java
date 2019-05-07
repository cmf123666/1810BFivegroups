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
       private String zhiquId;//这个是与用户付费关联id

}
