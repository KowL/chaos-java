package org.chaos.mall.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: FullDiscountPromotion
 * @Description: 满件折促销POJO
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: rick-li@msyc.cc
 * @Date: 2021-01-22 14:49
 */
@Data
public class FullDiscountPromotion extends Promotion {

    /**
     * 折扣力度
     */
    private List<DiscountLevel> levelList;

    @Data
    class DiscountLevel implements PromotionLevel {
        /**
         * 件数
         */
        private Integer threshold;


        /**
         * 折扣，8折 = 80，88折 = 88
         */
        private Integer discount;
    }

    @Override
    public void calcItem() {
        int totalNum = getItemList().stream().mapToInt(a -> a.getNum()).sum();
        DiscountLevel choseLevel = null;
        // 逆向查找
        for (int i = levelList.size() - 1; i >= 0; i--) {
            DiscountLevel level = levelList.get(i);
            if (totalNum >= level.getThreshold()) {
                choseLevel = level;
                break;
            }
        }
        if (choseLevel != null) {
            // 计算促销金额
            for () {
                getItemList().set();
            }
        }
    }
}
