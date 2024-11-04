package online.notpeppa.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private boolean deleted;
    private Date create_date;
    private Date update_date;
    private String create_by;
    private String update_by;
}
