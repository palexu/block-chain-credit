package top.palexu.blockchaincredit.report.dao;

import top.palexu.blockchaincredit.report.model.TemplateDo;

public interface TemplateDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    int insert(TemplateDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    int insertSelective(TemplateDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    TemplateDo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TemplateDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table template
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TemplateDo record);
}