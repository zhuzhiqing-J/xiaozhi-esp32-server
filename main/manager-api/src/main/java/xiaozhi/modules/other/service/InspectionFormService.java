package xiaozhi.modules.other.service;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiaozhi.common.utils.Result;
import xiaozhi.modules.model.entity.ModelProviderEntity;
import xiaozhi.modules.other.entity.AnswerContent;
import xiaozhi.modules.other.entity.Inspection;
import xiaozhi.modules.other.entity.InspectionForm;
import xiaozhi.modules.other.mapper.AnswerContentMapper;
import xiaozhi.modules.other.mapper.InspectionFormMapper;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class InspectionFormService extends ServiceImpl<InspectionFormMapper, Inspection> implements IService<Inspection> {

    @Autowired
    private AnswerContentMapper answerContentMapper;

    @Transactional
    public Result saveForm(InspectionForm form) {

        form.setId(new Random().nextLong());
        Inspection an_dto;
        an_dto = JSONUtil.toBean(JSONUtil.toJsonStr(form), Inspection.class);


        // 保存主表数据
        baseMapper.insert(an_dto);

        // 保存答案内容
        List<AnswerContent> contents = form.getAnswerContents();
        if (contents != null && !contents.isEmpty()) {
            for (AnswerContent content : contents) {
                content.setFormId(an_dto.getFormId());
                content.setId(UUID.randomUUID().toString());
                content.setAid(an_dto.getAid());
                answerContentMapper.insert(content);
            }
        }
        return new Result<>().ok(an_dto.getRid() + "已经处理");


    }

    @Transactional
    public Result deleteForm(InspectionForm form) {

        form.setId(new Random().nextLong());
        Inspection an_dto;
        an_dto = JSONUtil.toBean(JSONUtil.toJsonStr(form), Inspection.class);
        QueryWrapper<Inspection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aid", an_dto.getAid());
        baseMapper.delete(queryWrapper);

        QueryWrapper<AnswerContent> answerWrapper = new QueryWrapper<>();
        answerWrapper.eq("aid", an_dto.getAid());

        answerContentMapper.delete(answerWrapper);

        return new Result<>().ok(an_dto.getRid() + "已经处理");

    }


    @Transactional
    public Result updateForm(InspectionForm form) {

        deleteForm(form);
        saveForm(form);

        return new Result<>().ok(form.getRid() + "已经处理");

    }
}