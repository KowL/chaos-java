package org.chaos.mall.pojo;

import lombok.Data;

/**
 * @ClassName: FullReducePromotion
 * @Description: 满减促销POJO
 * @Author: lijun
 * @Date: 2021-01-22 14:48
 */
@Data
public class FullReducePromotion extends Promotion {

    /**
     * 件数
     */
    private Integer threshold;


    /**
     * 金额，单位元，80。 8.8
     */
    private Double reduceAmount;

    @Override
    public void calcItem() {

    }
}
