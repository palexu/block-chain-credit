package top.palexu.blockchaincredit.report.model;

import java.io.Serializable;
import java.util.Date;

public class FactorTemplateRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor_script_relation.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor_script_relation.script_id
     *
     * @mbg.generated
     */
    private Long templateId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor_script_relation.factor_id
     *
     * @mbg.generated
     */
    private Long factorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor_script_relation.gmt_created
     *
     * @mbg.generated
     */
    private Date gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor_script_relation.gmt_updated
     *
     * @mbg.generated
     */
    private Date gmtUpdated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table factor_script_relation
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor_script_relation.id
     *
     * @return the value of factor_script_relation.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor_script_relation.id
     *
     * @param id the value for factor_script_relation.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor_script_relation.script_id
     *
     * @return the value of factor_script_relation.script_id
     *
     * @mbg.generated
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor_script_relation.script_id
     *
     * @param templateId the value for factor_script_relation.script_id
     *
     * @mbg.generated
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor_script_relation.factor_id
     *
     * @return the value of factor_script_relation.factor_id
     *
     * @mbg.generated
     */
    public Long getFactorId() {
        return factorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor_script_relation.factor_id
     *
     * @param factorId the value for factor_script_relation.factor_id
     *
     * @mbg.generated
     */
    public void setFactorId(Long factorId) {
        this.factorId = factorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor_script_relation.gmt_created
     *
     * @return the value of factor_script_relation.gmt_created
     *
     * @mbg.generated
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor_script_relation.gmt_created
     *
     * @param gmtCreated the value for factor_script_relation.gmt_created
     *
     * @mbg.generated
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor_script_relation.gmt_updated
     *
     * @return the value of factor_script_relation.gmt_updated
     *
     * @mbg.generated
     */
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor_script_relation.gmt_updated
     *
     * @param gmtUpdated the value for factor_script_relation.gmt_updated
     *
     * @mbg.generated
     */
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factor_script_relation
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", templateId=").append(templateId);
        sb.append(", factorId=").append(factorId);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtUpdated=").append(gmtUpdated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}