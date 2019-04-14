package com.steins.util;

/**
 * Created by Administrator on 2019/1/24.
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
        public static String getImgBasePath(){
            String os=System.getProperty("os.name");
            String basePath="";
            if (os.toLowerCase().startsWith("win")) {
                basePath = "C:/projectdev/image";
            } else {
                basePath = "/Users/baidu/work/image";
            }
            basePath = basePath.replace("/", seperator);
            return basePath;
        }

    public static String getUserImagePath(long stuId) {
        String imagePath = "/imgupload/images/item/user/" + stuId + "/";
        return imagePath.replace("/", seperator);
    }


}
