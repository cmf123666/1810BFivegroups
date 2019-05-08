package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class LiushuiBean implements Serializable {
         private String LiushuiId;//
         private String LiushuiName;//
         private String LiushuiRoom;//
         private double payCount;//
         private String billType;//
         private String payType;//
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
         private Date  payDate;//
         private String status;
         private String num;
}
