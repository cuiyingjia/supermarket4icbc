package service.impl;

import service.PromoteService;

public class PromoteServiceImpl implements PromoteService {


    @Override
    public Double ruleOne(Double preSum) {
        if(preSum > 100 ){
            Double minusBase = Math.floor(preSum/100);
            preSum -= minusBase * 10;
        }
        return preSum;
    }
}
