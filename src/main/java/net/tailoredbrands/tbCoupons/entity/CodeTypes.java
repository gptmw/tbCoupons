package net.tailoredbrands.tbCoupons.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.Timestamp;

import net.tailoredbrands.tbCoupons.entity.keyids.CodeKeyID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CODE_TYPES", schema = "couponsdb")
@Data
@IdClass(CodeKeyID.class)
public class CodeTypes implements Serializable{

    @Id
    @Column(name = "CODE_KEY", nullable=false)
    private String codeKey;

    @Id
    @Column(name = "CODE_TYPE", nullable=false)
    private String codeType;


    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "SEQUENCE")
    private Integer sequence;

    @Column(name = "CODE_DESCRIPTION")
    private String codeDescription;

    @Column(name = "CREATED_TIMESTAMP")
    private Timestamp createdTimestamp;

    @Column(name = "CREATED_BY_USER")
    private String createdByUser;

    @Column(name = "UPDATED_TIMESTAMP")
    private Timestamp updatedTimestamp;

    @Column(name = "UPDATED_BY_USER")
    private String updatedByUser;


}
