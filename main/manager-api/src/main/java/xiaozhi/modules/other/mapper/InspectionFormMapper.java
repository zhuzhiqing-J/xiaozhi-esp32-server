package xiaozhi.modules.other.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import xiaozhi.modules.other.entity.Inspection;
import xiaozhi.modules.other.entity.InspectionForm;

@Mapper
public interface InspectionFormMapper extends BaseMapper<Inspection> {
}