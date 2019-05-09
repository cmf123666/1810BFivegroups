package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
//房东表w
public class LandlordBean implements Serializable {
    private Integer lid;//房东号
    private String landlordnName;//房东姓名
    private String listingAddress;//房源地址
    private String floorage;//建筑面积
    private String housingType;//房源户型
    private String housingSituation; //房源状况
    private String status;//状态
    private Integer contractMethod;//合同方式id
    private String paymentWay;//支付方式
    private Integer houseDeposit;//房屋押金
    private Integer houseRental;//房屋租金

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date  endDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date  conStartDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date  conEndDate;
    private Integer firstHouseRental;//第一阶段房屋租金
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date firstStartDate;//第一阶段开始时间
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date firstEndDate;//第一阶段结束时间
    private Integer secondHouseRental;//第二阶段房屋租金
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date secondStartDate;//第二阶段开始时间
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy",timezone = "GMT+8")
    private Date secondEndDate;//第二阶段结束世间
    private Integer lanId;

    private String contactMethod;//联系方式
    private String numberCardID;//身份证号码
    private String emergencyContact;//紧急联系人
    private String contactInformation;//紧急联系人联系方式



    private Integer temp;//临时字段
       private String roomId;//房间编号
       private String payee;//收款方
       private String billCount;//账单金额
       private String billType;//账单类型 与账单类型表关联
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  payDate;//预计到款时间
        private String payType;//付款方式
        private String shouquId; //与用户表支付的id关联；
        private String num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
        private Date  endData;
}
