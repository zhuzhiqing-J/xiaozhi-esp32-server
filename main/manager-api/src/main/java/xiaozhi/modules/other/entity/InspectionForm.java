package xiaozhi.modules.other.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data

public class InspectionForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String rid;
    private String formId;
    private String formTitle;
    private String aid;
    private Long eventTs;
    private Long messageTs;
    private String creatorId;
    private String creatorName;
    private String event;
    private Integer version;
    private List<AnswerContent> answerContents;


//
//    @TableField(fill = FieldFill.INSERT)
//    private Date create_time;
//
//    @TableField(fill = FieldFill.UPDATE)
//    private Date update_time;
}