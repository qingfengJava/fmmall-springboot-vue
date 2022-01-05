package com.qingfeng.fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 清风学Java
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrdersVO {
    private String orderId;
    private String userId;
    private String untitled;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private BigDecimal totalAmount;
    private Integer actualAmount;
    private Integer payType;
    private String orderRemark;
    private String status;
    private String deliveryType;
    private String deliveryFlowId;
    private BigDecimal orderFreight;
    private Integer deleteStatus;
    private Date createTime;
    private Date updateTime;
    private Date payTime;
    private Date deliveryTime;
    private Date flishTime;
    private Date cancelTime;
    private Integer closeType;

    /**
     * 商品快照
     */
    private List<OrderItem> orderItems;
}