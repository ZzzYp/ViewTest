package com.mine.test.clazzTest;

import java.util.logging.Logger;

/**
 * ProjectName:ViewTest
 * CREATE BY:yupeng.zhang
 * CREATE DATE:2018/9/11
 * DESCRIBE:
 */

public class ParentsClazz {
    private final String TAG = "ParentsClazz";
    private Logger logger = Logger.getLogger(TAG);

    public ParentsClazz() {
        logger.info("parents  ParentsClazz");
    }

    public void print(){
        logger.info("parents  ParentsClazz  print");
    }

}
