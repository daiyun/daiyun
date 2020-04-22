package daiyu.user.vo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Embeddable
public class PartitionPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date createTime;

    public PartitionPK() {
    }

    public PartitionPK(Long id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartitionPK that = (PartitionPK) o;
        return id.equals(that.id) &&
                createTime.equals(that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime);
    }
}