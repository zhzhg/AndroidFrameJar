package com.frame.json;

/**
 * @Title: zBaseParse.java
 * @Package com.frame.json
 * @Description: 实体Bean实现该接口，进行使用zJsonUtils累进行JSON数据解析
 * @author Kelvin
 * @date: 2014年6月12日 下午2:53:00
 * @version 1.0
 */
public interface zBaseParse<T> {
	public T parseJson(String json);
}
