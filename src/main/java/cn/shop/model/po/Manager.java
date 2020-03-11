package cn.shop.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@TableName("sp_manager")
public class Manager {

	/** 主键 id */
	@TableId(type = IdType.AUTO, value = "mg_id")
	private Integer id;
	/** 名称 */
	@TableField(value = "mg_name")
	private String name;
	/** 密码 */
	@TableField(value = "mg_pwd")
	private String password;
	/** 注册时间 */
	@TableField(value = "mg_time")
	private Long createTime;
	/** 角色 id */
	@TableField(value = "role_id")
	private Integer roleId;
	@TableField(value = "mg_mobile")
	private String mobile;
	@TableField(value = "mg_email")
	private String email;
	/** 1:启用 0:禁用 */
	@TableField("mg_state")
	private Integer state;
}
