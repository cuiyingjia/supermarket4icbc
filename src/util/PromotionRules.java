package util;

import service.PromoteService;
import service.impl.PromoteServiceImpl;

public final class PromotionRules {

    private static final PromoteService promoteService = new PromoteServiceImpl();

    public static final String RULE_001 = "001";

    /**
     * 使用特定优惠方式
     * @param preSum
     * @param rule
     * @return
     */
    public static Double getSumFromRule(Double preSum, String rule){
        switch (rule){
            case (RULE_001):
                return promoteService.ruleOne(preSum);
            default: return preSum;
        }
    }
}
