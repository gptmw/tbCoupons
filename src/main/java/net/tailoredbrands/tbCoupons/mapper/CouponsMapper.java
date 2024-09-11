package net.tailoredbrands.tbCoupons.mapper;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.dto.CouponsDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.Coupons;

import java.util.List;
import java.util.stream.Collectors;

public class CouponsMapper {

    public static CouponsDTO mapToCouponDTO(Coupons coupon){
        return new CouponsDTO(
                coupon.getOfferCode(),
                coupon.getCouponNumber(),
                coupon.getOfferDescription(),
                coupon.getCouponCodeEncryption(),
                coupon.getChannelCode(),
                coupon.getBrandCode(),
                coupon.getCampaignCode(),
                coupon.getOfferBeginDate(),
                coupon.getOfferEndDate(),
                coupon.getSequenceNumberStart(),
                coupon.getSequenceNumberEnd(),
                coupon.getOfferAmount(),
                coupon.getOfferPercent(),
                coupon.getOcmCouponType(),
                coupon.getCouponType(),
                coupon.getRedemptionType(),
                coupon.getCouponCount(),
                coupon.getOneTimeUse(),
                coupon.getCombineUse(),
                coupon.getParentCode(),
                coupon.getExistingOffer(),
                coupon.getLastName(),
                coupon.getFirstName(),
                coupon.getAddress2(),
                coupon.getStreet(),
                coupon.getCity(),
                coupon.getState(),
                coupon.getPostalCode(),
                coupon.getZip4(),
                coupon.getPhone(),
                coupon.getCustomerID(),
                coupon.getRewardNumber(),
                coupon.getRewardType(),
                coupon.getCertificateStatus(),
                coupon.getFriendCertificateID(),
                coupon.getCreatedTimestamp()
        );
    }

    public static Coupons mapToCoupon(CouponsDTO couponDTO){
        return new Coupons(
                couponDTO.getOfferCode(),
                couponDTO.getCouponNumber(),
                couponDTO.getOfferDescription(),
                couponDTO.getCouponCodeEncryption(),
                couponDTO.getChannelCode(),
                couponDTO.getBrandCode(),
                couponDTO.getCampaignCode(),
                couponDTO.getOfferBeginDate(),
                couponDTO.getOfferEndDate(),
                couponDTO.getSequenceNumberStart(),
                couponDTO.getSequenceNumberEnd(),
                couponDTO.getOfferAmount(),
                couponDTO.getOfferPercent(),
                couponDTO.getOcmCouponType(),
                couponDTO.getCouponType(),
                couponDTO.getRedemptionType(),
                couponDTO.getCouponCount(),
                couponDTO.getOneTimeUse(),
                couponDTO.getCombineUse(),
                couponDTO.getParentCode(),
                couponDTO.getExistingOffer(),
                couponDTO.getLastName(),
                couponDTO.getFirstName(),
                couponDTO.getAddress2(),
                couponDTO.getStreet(),
                couponDTO.getCity(),
                couponDTO.getState(),
                couponDTO.getPostalCode(),
                couponDTO.getZip4(),
                couponDTO.getPhone(),
                couponDTO.getCustomerID(),
                couponDTO.getRewardNumber(),
                couponDTO.getRewardType(),
                couponDTO.getCertificateStatus(),
                couponDTO.getFriendCertificateID(),
                couponDTO.getCreatedTimestamp()
        );

    }

    public static List<CouponsDTO> toCouponsDtos(List<Coupons> coupons) {
        List<CouponsDTO> couponsDtos = null;
        if (coupons != null) {
            couponsDtos = coupons.stream()
                    .map(CodeTypes -> mapToCouponDTO(CodeTypes))
                    .collect(Collectors.toList());

        }
        return couponsDtos;
    }
}
