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
public class CouponsDTO {
    private String offerCode;
    private String couponNumber;
    private String offerDescription;
    private String couponCodeEncryption;
    private String channelCode;
    private String brandCode;
    private String campaignCode;
    private Date offerBeginDate;
    private Date offerEndDate;
    private Integer sequenceNumberStart;
    private Integer sequenceNumberEnd;
    private Integer offerAmount;
    private Integer offerPercent;
    private String ocmCouponType;
    private String couponType;
    private String redemptionType;
    private Long couponCount;
    private Boolean oneTimeUse;
    private Boolean combineUse;
    private String parentCode;
    private String existingOffer;
    private String lastName;
    private String firstName;
    private String address2;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String zip4;
    private String phone;
    private String customerID;
    private String rewardNumber;
    private String rewardType;
    private String certificateStatus;
    private String friendCertificateID;
    private Timestamp createdTimestamp;
}
