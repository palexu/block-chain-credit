package top.palexu.blockchaincredit.report.dao;

import top.palexu.blockchaincredit.report.model.ScriptDo;

public interface ScriptDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int insert(ScriptDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int insertSelective(ScriptDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    ScriptDo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ScriptDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(ScriptDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table script
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ScriptDo record);
}