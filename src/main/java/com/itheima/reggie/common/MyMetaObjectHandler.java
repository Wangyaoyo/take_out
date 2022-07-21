package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/** 自定义元数据对象处理器
 * @author wy
 * @version 1.0
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在【insert】操作时自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());

        log.info("获取ThreadLocal中的用户 :{}", BaseContext.getCurrentId());
        Long userId = BaseContext.getCurrentId();
        metaObject.setValue("createUser", userId);
        metaObject.setValue("updateUser", userId);
    }

    /**
     * 在【update】操作时自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());
        metaObject.setValue("updateTime", LocalDateTime.now());

        // 获取ThreadLocal中的用户 id
        log.info("获取ThreadLocal中的用户 :{}", BaseContext.getCurrentId());
        Long userId = BaseContext.getCurrentId();
        metaObject.setValue("updateUser", userId);
    }
}
