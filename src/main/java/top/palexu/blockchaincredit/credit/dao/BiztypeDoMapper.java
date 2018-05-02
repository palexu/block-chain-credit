package top.palexu.blockchaincredit.credit.dao;

import top.palexu.blockchaincredit.credit.model.BiztypeDo;

public interface BiztypeDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BiztypeDo record);

    int insertSelective(BiztypeDo record);

    BiztypeDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BiztypeDo record);

    int updateByPrimaryKey(BiztypeDo record);
}