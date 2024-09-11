package net.tailoredbrands.tbCoupons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CodeTypesDTO {

    private String codeKey;
    private String codeType;
    private Boolean status;
    private Integer sequence;
    private String codeDescription;
    private Timestamp createdTimestamp;
    private String createdByUser;
    private Timestamp updatedTimestamp;
    private String updatedByUser;
}
