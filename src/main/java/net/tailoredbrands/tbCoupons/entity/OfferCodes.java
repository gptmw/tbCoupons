package net.tailoredbrands.tbCoupons.entity;

import jakarta.persistence.*;
import lombok.*;
import net.tailoredbrands.tbCoupons.entity.keyids.OfferCodeKeyID;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OFFER_CODES", schema = "couponsdb")
@Data
@IdClass(OfferCodeKeyID.class)
public class OfferCodes {

    @Id
    @Column(name = "OFFER_CODE", nullable=false)
    private String offerCode;

    @Column(name = "OFFER_DESCRIPTION")
    private String offerDescription;

    @Column(name = "OFFER_STATUS")
    private String offerStatus;

    @Column(name = "EFFECTIVE_START_DATE")
    private Timestamp effectiveStartDate;

    @Column(name = "EFFECTIVE_END_DATE")
    private Timestamp effectiveEndDate;

    @Column(name = "CHANNEL_CODE")
    private String channelCode;

    @Column(name = "BRAND_CODE")
    private String brandCode;

    @Column(name = "MULTIPLE_BRANDS")
    private Boolean multipleBrands;

    @Column(name = "COUPON_OPTIONS")
    private String couponOptions;

    @Column(name = "COUPON_TYPE")
    private String couponType;

    @Column(name = "COUPON_TO_CHEETAH")
    private String couponToCheetah;

    @Column(name = "COUPON_PRELOAD")
    private String couponPreload;

    @Column(name = "COUPON_BATCH")
    private String couponBatch;

    @Column(name = "REDEMPTION_TYPE")
    private String redemptionType;

    @Column(name = "ONE_TIME_USE")
    private Boolean oneTimeUse;

    @Column(name = "OFFER_AMOUNT")
    private Integer offerAmount;

    @Column(name = "OFFER_PERCENT")
    private Integer offerPercent;

    @Column(name = "OCM_START_DATE")
    private Timestamp ocmStartDate;

    @Column(name = "OCM_END_DATE")
    private Timestamp ocmEndDate;

    @Column(name = "OCM_SEQUENCE_NUMBER_START")
    private Integer ocmSequenceNumberStart;

    @Column(name = "OCM_SEQUENCE_NUMBER_END")
    private Integer ocmSequenceNumberEnd;

    @Column(name = "COUPON_COUNT")
    private Integer couponCount;

    @Column(name = "INCLUDE_ENCRYPTION")
    private Boolean includeEncryption;

    @Column(name = "CREATED_TIMESTAMP")
    private Timestamp createdTimestamp;

    @Column(name = "CREATED_BY_USER")
    private String createdByUser;

    @Column(name = "UPDATED_TIMESTAMP")
    private Timestamp updatedTimestamp;

    @Column(name = "UPDATED_BY_USER")
    private String updatedByUser;
}

