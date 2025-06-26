package xiaozhi.modules.other.controller;

import cn.hutool.json.JSONUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiaozhi.common.utils.Result;
import xiaozhi.modules.other.entity.AnswerContent;
import xiaozhi.modules.other.entity.Inspection;
import xiaozhi.modules.other.entity.InspectionForm;
import xiaozhi.modules.other.service.InspectionFormService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 登录控制层
 */
@AllArgsConstructor
@RestController
@RequestMapping("/notify")
@Tag(name = "获取通知")
public class OtherController {


    @Autowired
    private InspectionFormService formService;

    @PostMapping("/getNotify")
    @Operation(summary = "接受通知")
    public Result getNotify(@RequestBody String obj) {
        InspectionForm item;
        try {
            item = JSONUtil.toBean(obj, InspectionForm.class);
        } catch (Exception e) {
            return new Result().error("接口参数有误");
        }

        if (item.getEvent().equalsIgnoreCase("create_answer")) {
            return formService.saveForm(item);
        } else if (item.getEvent().equalsIgnoreCase("delete_answer")) {
            return formService.deleteForm(item);
        } else if (item.getEvent().equalsIgnoreCase("update_answer")) {
            return  formService.updateForm(item);
        }


        return new Result<>().error(item.getRid() + "不支持的类型，当前仅支持[create_answer,delete_answer,update_answer]");


    }


}