package com.ltf.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dreamneverdie
 *	格式化json返回数据
 */
@Getter
@Setter
public class JsonData {

    private boolean ret;

    private String msg;

    private Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    /**
     * @param object	设置json数据的data对象
     * @param msg		设置json的标志信息
     * @return			返回封装的json对象
     */
    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    /**
     * @param object 传入json数据的data对象
     * @return 返回封装的json对象
     */
    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    /**
     * @return	返回封装的json对象，只设置了返回成功标志
     */
    public static JsonData success() {
        return new JsonData(true);
    }

    /**
     * @param msg  ajax失败时候返回的字符串信息
     * @return	返回封装的json对象
     */
    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    /**
     * @return	把jsonData对象转成json数据key:value格式
     */
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
