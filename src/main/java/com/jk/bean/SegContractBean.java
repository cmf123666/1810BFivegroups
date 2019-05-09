package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SegContractBean {
    private Integer segConId;//
    private Integer paymentWay;//支付方式
    private Integer houseDeposit;//房屋押金
    private Integer firstHouseRental;//第一阶段房屋租金
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date firstStartDate;//第一阶段开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date firstEndDate;//第一阶段结束时间
    private Integer secondHouseRental;//第二阶段房屋租金
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date secondStartDate;//第二阶段开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date secondEndDate;//第二阶段结束世间
}
