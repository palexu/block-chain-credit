package top.palexu.blockchaincredit.report.model;

import java.io.Serializable;
import java.util.Date;

public class FactorDo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.desc
     *
     * @mbg.generated
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.script_id
     *
     * @mbg.generated
     */
    private Long scriptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.gmt_created
     *
     * @mbg.generated
     */
    private Date gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.gmt_updated
     *
     * @mbg.generated
     */
    private Date gmtUpdated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column factor.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table factor
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.id
     *
     * @return the value of factor.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.id
     *
     * @param id the value for factor.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.name
     *
     * @return the value of factor.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.name
     *
     * @param name the value for factor.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.desc
     *
     * @return the value of factor.desc
     *
     * @mbg.generated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.desc
     *
     * @param desc the value for factor.desc
     *
     * @mbg.generated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.script_id
     *
     * @return the value of factor.script_id
     *
     * @mbg.generated
     */
    public Long getScriptId() {
        return scriptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.script_id
     *
     * @param scriptId the value for factor.script_id
     *
     * @mbg.generated
     */
    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.gmt_created
     *
     * @return the value of factor.gmt_created
     *
     * @mbg.generated
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.gmt_created
     *
     * @param gmtCreated the value for factor.gmt_created
     *
     * @mbg.generated
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.gmt_updated
     *
     * @return the value of factor.gmt_updated
     *
     * @mbg.generated
     */
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.gmt_updated
     *
     * @param gmtUpdated the value for factor.gmt_updated
     *
     * @mbg.generated
     */
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column factor.content
     *
     * @return the value of factor.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column factor.content
     *
     * @param content the value for factor.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table factor
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
        sb.append(", name=").append(name);
        sb.append(", desc=").append(desc);
        sb.append(", scriptId=").append(scriptId);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtUpdated=").append(gmtUpdated);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}