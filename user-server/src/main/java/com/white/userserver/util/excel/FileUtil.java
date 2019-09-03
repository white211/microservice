package com.white.userserver.util.excel;

import java.io.InputStream;

/**
 * @Program: FileUtil
 * @Description:
 * @Author: White
 * @DateTime: 2019-06-27 13:11:52
 **/

public class FileUtil {

    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

}



