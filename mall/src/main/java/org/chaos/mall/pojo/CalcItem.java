package org.chaos.mall.pojo;

import lombok.Data;

/**
 * @ClassName: PromItem
 * @Description: TODO
 * @Author: lijun
 * @Date: 2021-01-20 17:31
 */
@Data
public class CalcItem implements PromItem {

    private Long itemId;

    private Integer itemNum;

    private Integer sellingPrice;

    private Integer discountFee;

    private Integer couponFee;

    private Integer sellingPrice;

    private Promotion promotion;

    @Override
    public int getNum() {
        return itemNum;
    }

    @Override
    public int getTotalAmount() {
        return itemNum * sellingPrice;
    }
}
