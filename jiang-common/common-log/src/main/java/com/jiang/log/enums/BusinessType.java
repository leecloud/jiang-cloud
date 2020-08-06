package com.jiang.log.enums;

/**
 * @ClassName BusinessType
 * @Description: 业务操作类型
 * @Author jiang
 * @Date 2020/8/6 20:58
 **/
public enum BusinessType {
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 清空
     */
    CLEAN,
}
