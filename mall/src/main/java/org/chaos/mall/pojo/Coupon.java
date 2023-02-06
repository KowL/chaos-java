package org.chaos.mall.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName: Coupon
 * @Description: TODO
 * @Author: lijun
 * @Date: 2021-01-20 17:04
 */
@Data
public class Coupon {

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券标签
     */
    private String label;

    /**
     * 优惠券类型
     */
    private Integer type;

    /**
     * 优惠券开始时间
     */
    private LocalDateTime startTime;

    /**
     * 优惠券结束时间
     */
    private LocalDateTime endTime;

    /**
     *
     */
    private Double couponAmount;

    /**
     *
     */
    private Double thresholdAmount;
}
