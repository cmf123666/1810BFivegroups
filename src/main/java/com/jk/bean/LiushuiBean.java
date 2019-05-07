package com.jk.bean;

import lombok.Data;

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
         private Date  payDate;//
}
