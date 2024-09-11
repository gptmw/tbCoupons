package net.tailoredbrands.tbCoupons.service;

import net.tailoredbrands.tbCoupons.dto.CouponsDTO;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;

import java.util.List;

public interface CouponsService {
    List<CouponsDTO> getCouponsByOfferCode(String offerCode);
    CouponsDTO getByOfferCodeKeyId(String offerCode, String couponNumber);
    String createCoupons(String offerCode);

}
