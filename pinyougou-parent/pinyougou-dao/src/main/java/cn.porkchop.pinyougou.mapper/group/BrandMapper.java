package cn.porkchop.pinyougou.mapper.group;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Map<String, String>> findAllForSelect2();
}