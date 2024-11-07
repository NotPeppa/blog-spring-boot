package online.notpeppa.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时的填充策略
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充 createDate 和 updateDate 字段
        this.strictInsertFill(metaObject, "createDate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateDate", LocalDateTime.class, LocalDateTime.now());

        // 自动填充 createBy 和 updateBy 字段
        this.strictInsertFill(metaObject, "createBy", String.class, "admin");
        this.strictInsertFill(metaObject, "updateBy", String.class, "admin");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填充 updateDate 字段
        this.strictUpdateFill(metaObject, "updateDate", LocalDateTime.class, LocalDateTime.now());

        // 自动填充 updateBy 字段
        this.strictInsertFill(metaObject, "updateBy", String.class, "admin");
    }
}
