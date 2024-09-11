package net.tailoredbrands.tbCoupons.service.impl;

import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.dto.CouponsDTO;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;
import net.tailoredbrands.tbCoupons.entity.CodeTypes;
import net.tailoredbrands.tbCoupons.entity.Coupons;
import net.tailoredbrands.tbCoupons.entity.OfferCodes;
import net.tailoredbrands.tbCoupons.entity.keyids.CodeKeyID;
import net.tailoredbrands.tbCoupons.entity.keyids.CouponKeyID;
import net.tailoredbrands.tbCoupons.entity.keyids.OfferCodeKeyID;
import net.tailoredbrands.tbCoupons.exception.ResourceNotFoundException;
import net.tailoredbrands.tbCoupons.mapper.CouponsMapper;
import net.tailoredbrands.tbCoupons.repository.CouponsRepository;
import net.tailoredbrands.tbCoupons.repository.OfferCodesRepository;
import net.tailoredbrands.tbCoupons.service.CouponsService;
import net.tailoredbrands.tbCoupons.service.OfferCodesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.trim;


@Service
@AllArgsConstructor
public class CouponsServiceImpl implements CouponsService {
    @Autowired
    private CouponsRepository couponsRepository;

    @Autowired
    private OfferCodesRepository offerCodeRepository;

    @Override
    public List<CouponsDTO> getCouponsByOfferCode(String offerCode) {
        List<Coupons> retrievedCoupons = couponsRepository.findByOfferCode(offerCode);

        List<CouponsDTO> couponsDTOList = CouponsMapper.toCouponsDtos(retrievedCoupons);
        return couponsDTOList;

    }

    @Override
    public CouponsDTO getByOfferCodeKeyId(String offerCode, String couponNumber) {
        return null;
    }

    @Override
    public String createCoupons(String offerCode) {
        CouponsDTO couponsDto = null;

        OfferCodeKeyID offerCodeKeyID = new OfferCodeKeyID(offerCode);
        OfferCodes offerCodeData = offerCodeRepository.findById(offerCodeKeyID)
                .orElseThrow(() -> new ResourceNotFoundException("Offer Code: " + trim(offerCode) +  " does not exist."));


        List<Coupons> couponsList = new ArrayList<>();
        for (long i = offerCodeData.getOcmSequenceNumberStart();
                        i <= offerCodeData.getOcmSequenceNumberEnd(); i++) {
            Coupons coupon = new Coupons();
            coupon.setCouponNumber(String.format("%016d", (ThreadLocalRandom.current().nextInt(offerCodeData.getOcmSequenceNumberStart(),
                    offerCodeData.getOcmSequenceNumberEnd() + 1))));
            coupon.setOfferCode(offerCodeData.getOfferCode());
            coupon.setOfferDescription(offerCodeData.getOfferDescription());
            coupon.setChannelCode(offerCodeData.getChannelCode());
            coupon.setBrandCode(offerCodeData.getBrandCode());
            coupon.setCampaignCode(offerCodeData.getOfferCode());
            coupon.setOfferBeginDate(offerCodeData.getEffectiveStartDate());
            coupon.setOfferEndDate(offerCodeData.getEffectiveEndDate());
            coupon.setSequenceNumberStart(offerCodeData.getOcmSequenceNumberStart());
            coupon.setSequenceNumberEnd(offerCodeData.getOcmSequenceNumberEnd());
            coupon.setOfferAmount(offerCodeData.getOfferAmount());
            coupon.setOfferPercent(offerCodeData.getOfferPercent());
            coupon.setOcmCouponType("COUPON");
            //coupon.getCouponType(),
            coupon.setRedemptionType(offerCodeData.getRedemptionType());
            coupon.setCouponCount(Long.valueOf(offerCodeData.getCouponCount()));
            coupon.setOneTimeUse(offerCodeData.getOneTimeUse());
            coupon.setCombineUse(false);
            coupon.setParentCode(offerCodeData.getOfferCode());
            coupon.setExistingOffer(null);
            coupon.setLastName(null);
            coupon.setFirstName(null);
            coupon.setAddress2(null);
            coupon.setStreet(null);
            coupon.setCity(null);
            coupon.setState(null);
            coupon.setPostalCode(null);
            coupon.setZip4(null);
            coupon.setPhone(null);
            coupon.setCustomerID(null);
            coupon.setRewardNumber(null);
            coupon.setRewardType(null);
            coupon.setCertificateStatus(null);
            coupon.setFriendCertificateID(null);
            coupon.setCreatedTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            couponsList.add(coupon);
        }
        couponsRepository.saveAll(couponsList);

        //return couponsList.stream().map(this::couponsDto).collect(Collectors.toList());
        return "Coupons generated!";
    }
}
