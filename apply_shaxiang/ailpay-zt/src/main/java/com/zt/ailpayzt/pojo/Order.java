package com.zt.ailpayzt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@TableName("order")
public class Order {
    @TableId(value = "ordeid",type = IdType.AUTO)
    private Integer orderId;
    @TableField("ordertiem")
    private String orderTiem;
    @TableField("ordermoney")
    private Float orderMoney;
    @TableField("ordergoodid")
    private String orderGoodId;
    @TableField("ordercreattime")
    private String orderCreatTime;

}
