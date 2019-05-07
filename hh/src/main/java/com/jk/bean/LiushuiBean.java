package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LiushuiBean implements Serializable {
         private String LiushuiId;//
         private String LiushuiName;//
         private String LiushuiRoom;//
         private String payCount;//
         private String billType;//
         private String payType;//
         private Date  payDate;//
}
