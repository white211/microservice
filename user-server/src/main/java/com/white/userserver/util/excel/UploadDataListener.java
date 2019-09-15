package com.white.userserver.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.white.userserver.pojo.entity.TbUser;
import com.white.userserver.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: UploadDataListener
 * @Description:
 * @Author: White
 * @DateTime: 2019-09-09 17:47:50
 **/

public class UploadDataListener extends AnalysisEventListener<TbUser> {

    private static final Logger logger = LoggerFactory.getLogger(UploadDataListener.class);

    @Autowired
    private TbUserService tbUserService;

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<TbUser> list = new ArrayList<TbUser>();

    @Override
    public void invoke(TbUser tbUser, AnalysisContext analysisContext) {
        logger.info("解析到一条数据:{}", tbUser);
        list.add(tbUser);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        saveData();
        logger.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        logger.info("{}条数据，开始存储数据库！", list.size());
//        tbUserService.saveBatch(list);
        logger.info("存储数据库成功！");
    }

}
