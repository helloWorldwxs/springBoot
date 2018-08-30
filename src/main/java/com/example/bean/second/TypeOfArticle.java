package com.example.bean.second;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 16:33
 * 文章类型表
 * @Description:
 */
@Entity
@Table(name = "type_of_article")
public class TypeOfArticle {
    private Integer id;
    private String typeName;
    private Integer typeCount;
    private String createBy;
    private Date createAt;
    private String changeBy;
    private Date changeAt;
    private Boolean availabe;
    private short version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(Integer typeCount) {
        this.typeCount = typeCount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getChangeBy() {
        return changeBy;
    }

    public void setChangeBy(String changeBy) {
        this.changeBy = changeBy;
    }

    public Date getChangeAt() {
        return changeAt;
    }

    public void setChangeAt(Date changeAt) {
        this.changeAt = changeAt;
    }

    public Boolean getAvailabe() {
        return availabe;
    }

    public void setAvailabe(Boolean availabe) {
        this.availabe = availabe;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    public TypeOfArticle(Integer id, String typeName, Integer typeCount, String createBy, Date createAt, String changeBy, Date changeAt, Boolean availabe, short version) {
        this.id = id;
        this.typeName = typeName;
        this.typeCount = typeCount;
        this.createBy = createBy;
        this.createAt = createAt;
        this.changeBy = changeBy;
        this.changeAt = changeAt;
        this.availabe = availabe;
        this.version = version;
    }
    public TypeOfArticle() {}

    @Override
    public String toString() {
        return "TypeOfArticle{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeCount=" + typeCount +
                ", createBy='" + createBy + '\'' +
                ", createAt=" + createAt +
                ", changeBy='" + changeBy + '\'' +
                ", changeAt=" + changeAt +
                ", availabe=" + availabe +
                ", version=" + version +
                '}';
    }
}
