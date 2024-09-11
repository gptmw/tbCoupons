package net.tailoredbrands.tbCoupons.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OfferCodesDTO {
    private String offerCode;
    private String offerDescription;
    private String offerStatus;
    private Timestamp effectiveStartDate;
    private Timestamp effectiveEndDate;
    private String channelCode;
    private String brandCode;
    private Boolean multipleBrands;
    private String couponOptions;
    private Boolean oneTimeUse;
    private Integer offerAmount;
    private Integer offerPercent;
    private Timestamp ocmStartDate;
    private Timestamp ocmEndDate;
    private Integer ocmSequenceNumberStart;
    private Integer ocmSequenceNumberEnd;
    private Integer couponCount;
    private String couponToCheetah;
    private String couponBatch;
    private String couponPreload;
    private String redemptionType;
    private String couponType;
    private Boolean includeEncryption;
    private Timestamp createdTimestamp;
    private String createdByUser;
    private Timestamp updatedTimestamp;
    private String updatedByUser;
}
