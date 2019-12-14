
package com.neu.autojavaappgenerator.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * User
 * <p>
 * 
 * 
 */
@Entity
@Table
public class User
    extends Group
{

    @Column
    private Object entity;
    @Column
    private String name;
    @Column
    private Integer num;

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public User withEntity(Object entity) {
        this.entity = entity;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public User withNum(Integer num) {
        this.num = num;
        return this;
    }

    @Override
    public User withgName(String gName) {
        super.withgName(gName);
        return this;
    }

    @Override
    public User withgNum(Integer gNum) {
        super.withgNum(gNum);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        int baseLength = sb.length();
        String superString = super.toString();
        if (superString!= null) {
            int contentStart = superString.indexOf('[');
            int contentEnd = superString.lastIndexOf(']');
            if ((contentStart >= 0)&&(contentEnd >contentStart)) {
                sb.append(superString, (contentStart + 1), contentEnd);
            } else {
                sb.append(superString);
            }
        }
        if (sb.length()>baseLength) {
            sb.append(',');
        }
        sb.append("entity");
        sb.append('=');
        sb.append(((this.entity == null)?"<null>":this.entity));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("num");
        sb.append('=');
        sb.append(((this.num == null)?"<null>":this.num));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.entity == null)? 0 :this.entity.hashCode()));
        result = ((result* 31)+((this.num == null)? 0 :this.num.hashCode()));
        result = ((result* 31)+ super.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return (((super.equals(rhs)&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.entity == rhs.entity)||((this.entity!= null)&&this.entity.equals(rhs.entity))))&&((this.num == rhs.num)||((this.num!= null)&&this.num.equals(rhs.num))));
    }

}
