package com.example.bean.second;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Auther: Administrator
 * @Date: 2018/8/30 16:33
 * 文章类型表
 * @Description:
 */
@Entity
@Table(name = "type_of_article")
public class TypeOfArticle {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "type_name")
    private String typeName;
    @Column(name = "type_count")
    private Integer typeCount;
    @Column(name = "type_alias")
    private String typeAlias;
    @Column(name = "type_desc")
    private String typeDesc;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "change_by")
    private String changeBy;
    @Column(name = "change_at")
    private Date changeAt;
    @Column(name = "availabe")
    private Boolean availabe;
    @Column(name = "version")
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

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
    public String getTypeAlias() {
        return typeAlias;
    }

    public void setTypeAlias(String typeAlias) {
        this.typeAlias = typeAlias;
    }

    @Override
    public String toString() {
        return "TypeOfArticle{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeCount=" + typeCount +
                ", typeAlias=" + typeAlias +
                ", typeDesc='" + typeDesc + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createAt=" + createAt +
                ", changeBy='" + changeBy + '\'' +
                ", changeAt=" + changeAt +
                ", availabe=" + availabe +
                ", version=" + version +
                '}';
    }

    public TypeOfArticle() {}

    public TypeOfArticle(String typeName, Integer typeCount, String typeAlias, String typeDesc, String createBy, Date createAt, String changeBy, Date changeAt, Boolean availabe, short version) {
        this.typeName = typeName;
        this.typeCount = typeCount;
        this.typeAlias = typeAlias;
        this.typeDesc = typeDesc;
        this.createBy = createBy;
        this.createAt = createAt;
        this.changeBy = changeBy;
        this.changeAt = changeAt;
        this.availabe = availabe;
        this.version = version;
    }
}
