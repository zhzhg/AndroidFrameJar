   Android开发中经常使用的工具类
   com.frame.utils：
   1、zAppUtils.java 应用程序的工具类，安装APP，静默安装APP，正常安装APP，静默卸载APP，判断当前应用是否为系统应用。
   2、zAssetsResourceUtils.java assets工具类，获取assets文件夹下相应文件。
   3、zFileUtils.java 文件工具类。
   4、zHomeWatcher.java Home键监听封装。
   5、zIOUitls.java 文件读写工具类 getEmptyString方法调用防止NUll指针异常。
   6、zLog.java 日志打印类，在程序入口Application中设置日志打印的开关。
   7、zNetUtils.java 网络工具类，主要对当前设备的网络状态和类型进行判断。
   8、zPhonePhotoUtils.java 获取手机相册路径，4.4之后相册路径发生变化，调用此类根据系统版本返回相应路径。
   9、zShareFileUtils.java SharedPreferences工具类，在BaseActiviy里初始化initSharePre。
   10、zShellUtils.java linux命令行工具类
   11、zStringUtils.java 字符串工具类
   12、zSysInfoUtils.java 获取手机系统、SIM卡等相关信息工具类
   13、zTimeUtils.java 时间工具类
   14、zToast.java Toast统一管理类
   15、zStrToMd5Utils.java 字符串Md5加密工具类
   16、zViewBox.java findViewById工具类，使用方式：定义内部类PageViewList，pageViewaList = new PageViewList();zViewBox.viewBox(this, pageViewaList);要求：声明对象与ID名相同。
   17、zPhoneNumberUtils.java 手机号判断工具类，可以修改相应的正则表达式，完成对手机号的匹配。
   18、zEmailUtils 判断邮箱格式是否正确
   
   com.frame.json：
   1、zBaseParse.java 实体Bean实现该接口，进行使用zJsonUtils累进行JSON数据解析
   2、zJsonUtils.java json解析工具类
   
   com.frame.image：
   1、zCompressImage.java 图片压缩类
   2、zImageUtils.java 图片转换类
   


