package net.tailoredbrands.tbCoupons.mapper;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.OfferCodes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OfferCodesMapper {

    @Autowired
    public static OfferCodesDTO mapToOfferCodeDTO(OfferCodes offerCode){
        return new OfferCodesDTO(
                offerCode.getOfferCode(),
                offerCode.getOfferDescription(),
                offerCode.getOfferStatus(),
                offerCode.getEffectiveStartDate(),
                offerCode.getEffectiveEndDate(),
                offerCode.getChannelCode(),
                offerCode.getBrandCode(),
                offerCode.getMultipleBrands(),
                offerCode.getCouponOptions(),
                offerCode.getOneTimeUse(),
                offerCode.getOfferAmount(),
                offerCode.getOfferPercent(),
                offerCode.getOcmStartDate(),
                offerCode.getOcmEndDate(),
                offerCode.getOcmSequenceNumberStart(),
                offerCode.getOcmSequenceNumberEnd(),
                offerCode.getCouponCount(),
                offerCode.getCouponToCheetah(),
                offerCode.getCouponPreload(),
                offerCode.getCouponBatch(),
                offerCode.getRedemptionType(),
                offerCode.getCouponType(),
                offerCode.getIncludeEncryption(),
                offerCode.getCreatedTimestamp(),
                offerCode.getCreatedByUser(),
                offerCode.getUpdatedTimestamp(),
                offerCode.getUpdatedByUser()
        );

    }

    public static OfferCodes mapToOfferCode(OfferCodesDTO offerCodeDTO){
        return new OfferCodes(
                offerCodeDTO.getOfferCode(),
                offerCodeDTO.getOfferDescription(),
                offerCodeDTO.getOfferStatus(),
                offerCodeDTO.getEffectiveStartDate(),
                offerCodeDTO.getEffectiveEndDate(),
                offerCodeDTO.getChannelCode(),
                offerCodeDTO.getBrandCode(),
                offerCodeDTO.getMultipleBrands(),
                offerCodeDTO.getCouponOptions(),
                offerCodeDTO.getCouponType(),
                offerCodeDTO.getCouponToCheetah(),
                offerCodeDTO.getCouponPreload(),
                offerCodeDTO.getCouponBatch(),
                offerCodeDTO.getRedemptionType(),
                offerCodeDTO.getOneTimeUse(),
                offerCodeDTO.getOfferAmount(),
                offerCodeDTO.getOfferPercent(),
                offerCodeDTO.getOcmStartDate(),
                offerCodeDTO.getOcmEndDate(),
                offerCodeDTO.getOcmSequenceNumberStart(),
                offerCodeDTO.getOcmSequenceNumberEnd(),
                offerCodeDTO.getCouponCount(),
                offerCodeDTO.getIncludeEncryption(),
                offerCodeDTO.getCreatedTimestamp(),
                offerCodeDTO.getCreatedByUser(),
                offerCodeDTO.getUpdatedTimestamp(),
                offerCodeDTO.getUpdatedByUser()

        );
    }
    public static List<OfferCodesDTO> toOfferCodeDtos(List<OfferCodes> offerCodesList) {
        List<OfferCodesDTO> offerCodesDTOList= null;
        if (offerCodesList != null) {
            offerCodesDTOList = offerCodesList.stream()
                    .map(OfferCodes -> mapToOfferCodeDTO(OfferCodes))
                    .collect(Collectors.toList());

        }
        return offerCodesDTOList;
    }
}
