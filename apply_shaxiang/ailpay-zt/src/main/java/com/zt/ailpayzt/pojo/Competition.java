package com.zt.ailpayzt.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@TableName("competition")
public class Competition {
    @TableId("goodid")
    private String goodId;
    @TableField("goodmoney")
    private Float goodmoney;
    @TableField("goodname")
    private String goodName;
    @TableField("gooddesc")
    private String goodDesc;



}
