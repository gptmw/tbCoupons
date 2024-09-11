package net.tailoredbrands.tbCoupons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import net.tailoredbrands.tbCoupons.entity.keyids.CouponKeyID;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COUPONS", schema = "couponsdb")
@IdClass(CouponKeyID.class)
public class Coupons implements Serializable {
    @Id
    @Column(name = "OFFER_CODE")
    private String offerCode;

    @Id
    @Column(name = "COUPON_NUMBER")
    private String couponNumber;

    @Column(name = "OFFER_DESCRIPTION")
    private String offerDescription;

    @Column(name = "COUPON_CODE_ENCRYPTION")
    private String couponCodeEncryption;

    @Column(name = "CHANNEL_CODE")
    private String channelCode;

    @Column(name = "BRAND_CODE")
    private String brandCode;

    @Column(name = "CAMPAIGN_CODE")
    private String campaignCode;

    @Column(name = "OFFER_BEGIN_DATE")
    private Date offerBeginDate;

    @Column(name = "OFFER_END_DATE")
    private Date offerEndDate;

    @Column(name = "SEQUENCE_NUMBER_START")
    private Integer sequenceNumberStart;

    @Column(name = "SEQUENCE_NUMBER_END")
    private Integer sequenceNumberEnd;

    @Column(name = "OFFER_AMOUNT")
    private Integer offerAmount;

    @Column(name = "OFFER_PERCENT")
    private Integer offerPercent;

    @Column(name = "OCM_COUPON_TYPE")
    private String ocmCouponType;

    @Column(name = "COUPON_TYPE")
    private String couponType;

    @Column(name = "REDEMPTION_TYPE")
    private String redemptionType;

    @Column(name = "COUPON_COUNT")
    private Long couponCount;

    @Column(name = "ONE_TIME_USE")
    private Boolean oneTimeUse;

    @Column(name = "COMBINE_USE")
    private Boolean combineUse;

    @Column(name = "PARENT_CODE")
    private String parentCode;

    @Column(name = "EXISTING_OFFER")
    private String existingOffer;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "ZIP4")
    private String zip4;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CUSTOMER_ID")
    private String customerID;

    @Column(name = "REWARD_NUMBER")
    private String rewardNumber;

    @Column(name = "REWARD_TYPE")
    private String rewardType;

    @Column(name = "CERTIFICATE_STATUS")
    private String certificateStatus;

    @Column(name = "FRIEND_CERTIFICATE_ID")
    private String friendCertificateID;

    @Column(name = "CREATED_TIMESTAMP")
    private Timestamp createdTimestamp;

}
