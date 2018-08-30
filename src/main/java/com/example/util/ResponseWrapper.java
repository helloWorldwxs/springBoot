package com.example.util;

/**
 * 数据返回的格式
 */
public class ResponseWrapper {
	 /**是否成功*/  
    private boolean success;  
    /**返回码*/  
    private String code;  
    /**返回信息*/  
    private String msg;  
    /**返回数据*/  
    private Object data;
    
    /** 
     * 自定义返回结果 
     * 建议使用统一的返回结果，特殊情况可以使用此方法 
     * @param success 
     * @param code 
     * @param msg 
     * @param data 
     * @return 
     */  
    public static ResponseWrapper markCustom(boolean success,String code,String msg,String data){  
        ResponseWrapper responseWrapper = new ResponseWrapper();  
        responseWrapper.setSuccess(success);  
        responseWrapper.setCode(code);  
        responseWrapper.setMsg(msg);  
        responseWrapper.setData(data);  
        return responseWrapper;  
    }  
  
    /** 
     * 参数为空或者参数格式错误 
     * @return 
     */  
    public static ResponseWrapper markParamError(){  
        ResponseWrapper responseWrapper = new ResponseWrapper();  
        responseWrapper.setSuccess(false);  
        responseWrapper.setCode(ReturnCode.PARAMS_ERROR.getCode());  
        responseWrapper.setMsg(ReturnCode.PARAMS_ERROR.getMsg());  
        return responseWrapper;  
    }  
  
    /** 
     * 查询失败 
     * @return 
     */  
    public static ResponseWrapper markError(){  
        ResponseWrapper responseWrapper = new ResponseWrapper();  
        responseWrapper.setSuccess(false);  
        responseWrapper.setCode(ReturnCode.FEAILED.getCode());  
        responseWrapper.setMsg(ReturnCode.FEAILED.getMsg());  
        responseWrapper.setData(null);  
        return responseWrapper;  
    }  
  
    /** 
     * 查询成功但无数据 
     * @return 
     */  
    public static ResponseWrapper markSuccessButNoData(){  
        ResponseWrapper responseWrapper  = new ResponseWrapper();  
        responseWrapper.setSuccess(true);  
        responseWrapper.setCode(ReturnCode.NODATA.getCode());  
        responseWrapper.setMsg(ReturnCode.NODATA.getMsg());  
        responseWrapper.setData(null);  
        return responseWrapper;  
    }  
  
    /** 
     * 查询成功且有数据 
     * @param data 
     * @return 
     */  
    public static ResponseWrapper markSuccess(Object data){  
        ResponseWrapper responseWrapper = new ResponseWrapper();  
        responseWrapper.setSuccess(true);  
        responseWrapper.setCode(ReturnCode.SUCCESS.getCode());  
        responseWrapper.setMsg(ReturnCode.SUCCESS.getMsg());  
        responseWrapper.setData(data);  
        return  responseWrapper;  
    }

    /**
     * 用户尚未注册
     * @return
     */
    public static ResponseWrapper markUserNameError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.USERNAMEERRO.getCode());
        responseWrapper.setMsg(ReturnCode.USERNAMEERRO.getMsg());
        return responseWrapper;
    }

    /**
     * 密码错误
     * @return
     */
    public static ResponseWrapper markPassWordError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(false);
        responseWrapper.setCode(ReturnCode.PASSWORDERROR.getCode());
        responseWrapper.setMsg(ReturnCode.PASSWORDERROR.getMsg());
        return responseWrapper;
    }
    /**
     * 用户登录成功
     * @return
     */
    public static ResponseWrapper markUserSuccess(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.USERSUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.USERSUCCESS.getMsg());
        return responseWrapper;
    }

    /**
     * 密码修改成功
     * @return
     */
    public static ResponseWrapper markPasswordUpdateSuccess(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.PASSWORDUPDATESUCCESS.getCode());
        responseWrapper.setMsg(ReturnCode.PASSWORDUPDATESUCCESS.getMsg());
        return responseWrapper;
    }

    /**
     * 密码修改失败
     * @return
     */
    public static ResponseWrapper markPasswordUpdateError(){
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setSuccess(true);
        responseWrapper.setCode(ReturnCode.PASSWORDUPDATEERROR.getCode());
        responseWrapper.setMsg(ReturnCode.PASSWORDUPDATEERROR.getMsg());
        return responseWrapper;
    }

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	} 
    
	@Override  
    public String toString() {  
        return "ResponseWrapper{" +  
                "success=" + success +  
                ", code='" + code + '\'' +  
                ", msg='" + msg + '\'' +  
                ", data=" + data +  
                '}';  
    }  
}
