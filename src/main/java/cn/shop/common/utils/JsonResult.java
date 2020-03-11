package cn.shop.common.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult<T> {
	/** 请求成功 */
	public static final int OK = 200;

	/** 创建成功 */
	public static final int CREATED = 201;

	/** 删除成功 */
	public static final int DELETED = 204;

	/** 请求的地址不存在或者包含不支持的参数 */
	public static final int BAD_REQUEST = 400;
	
	/** 未授权 */
	public static final int UNAUTHORIZED = 401;

	/** 被禁止访问 */
	public static final int FORBIDDEN = 403;
	
	/** 请求的资源不存在 */
	public static final int NOT_FOUND = 404;
	
	/** [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误 */
	public static final int Unprocesable_entity = 422;
	
	/** 内部错误 */
	public static final int INTERNAL_SERVER_ERROR = 500;
	
	private T data;
	private Meta meta ;
	
	@Getter
	@Setter
	private static class Meta{
		private int status;
		private String msg;
	}

	private JsonResult() {
		this.meta = new Meta() ;
	}
	
	public static JsonResult build() {
		return new JsonResult();
	}
	public static JsonResult build(int code) {
		return new JsonResult().code(code);
	}
	public static JsonResult build(int code, String msg) {
		return new JsonResult<String>().code(code).msg(msg);
	}
	public static <T> JsonResult<T> build(int code, T data) {
		return new JsonResult<T>().code(code).data(data);
	}
	public static <T> JsonResult<T> build(int code, String msg, T data) {
		return new JsonResult<T>().code(code).msg(msg).data(data);
	}
	
	public JsonResult<T> code(int code) {
		this.meta.setStatus(code);
		return this;
	}
	public JsonResult<T> msg(String msg) {
		this.meta.setMsg(msg); 
		return this;
	}
	public JsonResult<T> data(T data) {
		this.data = data;
		return this;
	}
	
	
	public static JsonResult ok() {
		return build(OK);
	}
	public static JsonResult ok(String msg) {
		return build(OK, msg);
	}
	public static <T> JsonResult<T> ok(T data) {
		return build(OK, data);
	}
	public static JsonResult err() {
		return build(INTERNAL_SERVER_ERROR);
	}
	public static JsonResult err(String msg) {
		return build(INTERNAL_SERVER_ERROR, msg);
	}
	
	@Override
	public String toString() {
		return JsonUtil.to(this);
	}
}
