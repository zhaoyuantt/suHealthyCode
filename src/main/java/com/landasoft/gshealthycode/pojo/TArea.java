package com.landasoft.gshealthycode.pojo;

import java.util.Date;

public class TArea {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.name
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.code
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.is_parent
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private Boolean isParent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.parent_id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.sort_num
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private Short sortNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.remark
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.created
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_area.updated
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    private Date updated;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.id
     *
     * @return the value of t_area.id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.id
     *
     * @param id the value for t_area.id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.name
     *
     * @return the value of t_area.name
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.name
     *
     * @param name the value for t_area.name
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.code
     *
     * @return the value of t_area.code
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.code
     *
     * @param code the value for t_area.code
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.is_parent
     *
     * @return the value of t_area.is_parent
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.is_parent
     *
     * @param isParent the value for t_area.is_parent
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.parent_id
     *
     * @return the value of t_area.parent_id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.parent_id
     *
     * @param parentId the value for t_area.parent_id
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.sort_num
     *
     * @return the value of t_area.sort_num
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public Short getSortNum() {
        return sortNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.sort_num
     *
     * @param sortNum the value for t_area.sort_num
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setSortNum(Short sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.remark
     *
     * @return the value of t_area.remark
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.remark
     *
     * @param remark the value for t_area.remark
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.created
     *
     * @return the value of t_area.created
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.created
     *
     * @param created the value for t_area.created
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_area.updated
     *
     * @return the value of t_area.updated
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_area.updated
     *
     * @param updated the value for t_area.updated
     *
     * @mbggenerated Wed Apr 29 09:49:06 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}