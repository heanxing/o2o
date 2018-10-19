package com.o2o.util;

/**
 * Created by heanxing on 2018/10/15.
 */
public class PathUtil {
        /*
        * 根据不同的操作系统，设置储存图片文件不同的根目录
        */
    private static String separator = System.getProperty("file.separator");

    public static String getImageBasePath() {
        String os =System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")) {
            basePath = "/home/o2o/images/";    //根据自己的实际路径进行设置
        }else {
            basePath = "E:/Users/image/";//根据自己的实际路径进行设置
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }


    //根据不同的业务需求返回不同的子路径
    public static String getShopImagePath(long shopId) {
        String imagePath = "upkoad/item/shop/"+ shopId + "/";
        return imagePath.replace("/", separator);
    }


}
