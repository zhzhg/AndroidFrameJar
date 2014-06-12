package com.frame.json;

/**
 * @Title: BaseParse.java
 * @Package com.cary.parse
 * @Description: 实体Bean实现该接口，进行使用zJsonUtils累进行JSON数据解析
 * @author zhzhg
 * @date 2014年2月22日 下午8:16:13
 * @version V1.0
 */

public interface zBaseParse<T> {
	public T parseJson(String json);
}
