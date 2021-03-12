package org.chaos.mall.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: Pormotion
 * @Description: TODO
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: rick-li@msyc.cc
 * @Date: 2021-01-20 17:01
 */
@Data
public abstract class Promotion {

    /**
     * 促销ID
     */
    private Long promId;

    /**
     * 促销名称
     */
    private String name;

    /**
     * 促销标签
     */
    private String label;

    /**
     * 促销类型
     */
    private Integer type;

    /**
     * 促销开始时间
     */
    private LocalDateTime startTime;

    /**
     * 促销结束时间
     */
    private LocalDateTime endTime;


    private List<PromItem> itemList;

    public abstract void calcItem();
}
