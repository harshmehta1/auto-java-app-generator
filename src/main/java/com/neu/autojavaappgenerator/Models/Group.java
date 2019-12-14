
package com.neu.autojavaappgenerator.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Group
 * <p>
 * 
 * 
 */
@Entity
@Table
public class Group {

    @Column
    private Object entity;
    @Column
    private String gName;
    @Column
    private Integer gNum;

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public Group withEntity(Object entity) {
        this.entity = entity;
        return this;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Group withgName(String gName) {
        this.gName = gName;
        return this;
    }

    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }

    public Group withgNum(Integer gNum) {
        this.gNum = gNum;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Group.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("entity");
        sb.append('=');
        sb.append(((this.entity == null)?"<null>":this.entity));
        sb.append(',');
        sb.append("gName");
        sb.append('=');
        sb.append(((this.gName == null)?"<null>":this.gName));
        sb.append(',');
        sb.append("gNum");
        sb.append('=');
        sb.append(((this.gNum == null)?"<null>":this.gNum));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.gName == null)? 0 :this.gName.hashCode()));
        result = ((result* 31)+((this.entity == null)? 0 :this.entity.hashCode()));
        result = ((result* 31)+((this.gNum == null)? 0 :this.gNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Group) == false) {
            return false;
        }
        Group rhs = ((Group) other);
        return ((((this.gName == rhs.gName)||((this.gName!= null)&&this.gName.equals(rhs.gName)))&&((this.entity == rhs.entity)||((this.entity!= null)&&this.entity.equals(rhs.entity))))&&((this.gNum == rhs.gNum)||((this.gNum!= null)&&this.gNum.equals(rhs.gNum))));
    }

}
