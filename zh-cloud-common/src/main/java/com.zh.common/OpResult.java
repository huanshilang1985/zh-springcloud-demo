
package com.zh.common;


import java.io.Serializable;

/**
 * 通用返回对象
 *
 * @author he.zhang
 * @date 2020/3/14 22:49
 */
public class OpResult<T> implements Serializable {

    private static final long serialVersionUID = -5217263946675824590L;

    /**
     * 成功
     */
    public static final int OP_SUCCESS = 1;

    /**
     * 失败
     */
    public static final int OP_FAILED = 0;

    /**
     * 返回状态
     */
    private int status;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据数量
     */
    private int dataCount;

    /**
     * 数据值
     */
    private T dataValue;

    public OpResult() {
    }

    public OpResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDataValue() {
        return dataValue;
    }

    public void setDataValue(T dataValue) {
        this.dataValue = dataValue;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public static final class OpMsg {
        public static final String SAVE_SUCCESS = "保存成功";
        public static final String SAVE_FAIL = "保存失败";
        public static final String MODIFY_SUCCESS = "修改成功";
        public static final String MODIFY_FAIL = "修改失败";
        public static final String DELETE_SUCCESS = "删除成功";
        public static final String DELETE_FAIL = "删除失败";
        public static final String OP_SUCCESS = "操作成功";
        public static final String OP_FAIL = "操作失败";
        public static final String VALIDATION_SUCCESS = "验证成功";
        public static final String VALIDATION_FALL = "验证失败";
        public static final String OP_LOGIN_FAIL = "未登录";
        public static final String OP_LOGIN_SUCCESS = "登录成功";
        public static final String OP_SMS_FAIL = "发送失败";
        public static final String OP_ACCOUNT_LOCK = "账号冻结";

    }

    /**
     * 失败返回信息
     *
     * @param message 失败提示信息
     * @return
     */
    public static OpResult getErrorResult(String message) {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_FAILED);
        opResult.setMessage(message);
        return opResult;
    }

    /**
     * 默认成功返回信息
     *
     * @return
     */
    public static OpResult getSuccResult() {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_SUCCESS);
        opResult.setMessage(OpMsg.OP_SUCCESS);
        return opResult;
    }

    /**
     * 成功返回信息
     *
     * @param message 成功提示信息
     * @return
     */
    public static OpResult getSuccResult(String message) {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_SUCCESS);
        opResult.setMessage(message);
        return opResult;
    }

    /**
     * 成功返回信息
     *
     * @param dataValue 成功后返回数据
     * @return
     */
    public static OpResult getSuccResultData(Object dataValue) {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_SUCCESS);
        opResult.setMessage(OpMsg.OP_SUCCESS);
        opResult.setDataValue(dataValue);
        return opResult;
    }

    /**
     * 成功返回分页信息
     *
     * @param dataValue 成功后返回数据
     * @return
     */
    public static OpResult getSuccResultData(int dataCount, Object dataValue) {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_SUCCESS);
        opResult.setMessage(OpMsg.OP_SUCCESS);
        opResult.setDataCount(dataCount);
        opResult.setDataValue(dataValue);
        return opResult;
    }

    /**
     * 成功返回提示信息和数据
     *
     * @param dataValue 成功后返回数据
     * @return
     */
    public static OpResult getSuccResultData(String message, Object dataValue) {
        OpResult opResult = new OpResult();
        opResult.setStatus(OP_SUCCESS);
        opResult.setMessage(message);
        opResult.setDataValue(dataValue);
        return opResult;
    }
}
