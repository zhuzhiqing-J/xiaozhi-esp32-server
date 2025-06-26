package xiaozhi.modules.other.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("answer_content")
public class AnswerContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String formId;
    private String aid;
    private String qid;
    private String type;
    private String title;



    private String value;


//    @TableField(fill = FieldFill.INSERT)
//    private Date create_time;
//
//    @TableField(fill = FieldFill.UPDATE)
//    private Date update_time;

}