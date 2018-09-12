package com.mine.test.clazzTest;

import java.util.logging.Logger;

/**
 * ProjectName:ViewTest
 * CREATE BY:yupeng.zhang
 * CREATE DATE:2018/9/11
 * DESCRIBE:
 */

public class ChildClazz extends ParentsClazz {
    private final String TAG = "ChildClazz";
    private Logger logger = Logger.getLogger(TAG);

    public ChildClazz() {
        super();
        logger.info("parents  ChildClazz");
    }


    public void print(){
        logger.info("parents  ChildClazz  print  1111");
        super.print();
        logger.info("parents  ChildClazz  print  2222");

    }

}
