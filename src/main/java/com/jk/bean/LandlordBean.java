package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
//房东表w
public class LandlordBean implements Serializable {
       private String lid;//房东号
       private String roomId;//房间编号
       private String payee;//收款方
       private String billCount;//账单金额
       private String billType;//账单类型 与账单类型表关联
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  payDate;//预计到款时间
        private String payType;//付款方式
        private String shouquId; //与用户表支付的id关联；
        private String status;//状态
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  endData;
}
