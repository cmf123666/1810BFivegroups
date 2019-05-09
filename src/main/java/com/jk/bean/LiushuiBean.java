package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class LiushuiBean implements Serializable {
         private String liushuiId;//
         private String liushuiName;//
         private String liushuilocation;//
         private String liushuiRoom;//
         private String payCount;//
         private String billType;//
         private String payType;//
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
         private Date  payDate;//
         private String status;
         private String num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date  startDate;//选择开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date  endDate;//选择结束时间
}
