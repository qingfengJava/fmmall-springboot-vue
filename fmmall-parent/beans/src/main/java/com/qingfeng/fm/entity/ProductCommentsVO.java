package com.qingfeng.fm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 清风学Java
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product_comments")
public class ProductCommentsVO {
    /**
     * ID
     */
    @Id
    @Column(name = "comm_id")
    private String commId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 订单项(商品快照)ID 可为空
     */
    @Column(name = "order_item_id")
    private String orderItemId;

    /**
     * 是否匿名（1:是，0:否）
     */
    @Column(name = "is_anonymous")
    private Integer isAnonymous;

    /**
     * 评价类型（1好评，0中评，-1差评）
     */
    @Column(name = "comm_type")
    private Integer commType;

    /**
     * 评价等级 1：好评 2：中评 3：差评
     */
    @Column(name = "comm_level")
    private Integer commLevel;

    /**
     * 评价内容
     */
    @Column(name = "comm_content")
    private String commContent;

    /**
     * 评价晒图(JSON {img1:url1,img2:url2}  )
     */
    @Column(name = "comm_imgs")
    private String commImgs;

    /**
     * 评价时间 可为空
     */
    @Column(name = "sepc_name")
    private Date sepcName;

    /**
     * 是否回复（0:未回复，1:已回复）
     */
    @Column(name = "reply_status")
    private Integer replyStatus;

    /**
     * 回复内容
     */
    @Column(name = "reply_content")
    private String replyContent;

    /**
     * 回复时间
     */
    @Column(name = "reply_time")
    private Date replyTime;

    /**
     * 是否显示（1:是，0:否）
     */
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * 封装评论对应的用户数据
     */
    private String userId;
    private String username;
    private String nickname;
    private String userImg;
}