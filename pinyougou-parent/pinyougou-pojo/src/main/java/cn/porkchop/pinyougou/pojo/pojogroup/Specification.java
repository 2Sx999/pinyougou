package cn.porkchop.pinyougou.pojo.pojogroup;

import cn.porkchop.pinyougou.pojo.TbSpecification;
import cn.porkchop.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

public class Specification extends TbSpecification implements Serializable {
    private List<TbSpecificationOption> specificationOptionList;

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
