package net.tailoredbrands.tbCoupons.controllers;

import lombok.AllArgsConstructor;
import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.dto.CouponsDTO;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;

import net.tailoredbrands.tbCoupons.entity.OfferCodes;
import net.tailoredbrands.tbCoupons.service.CouponsService;
import net.tailoredbrands.tbCoupons.service.OfferCodesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

@AllArgsConstructor
@RestController
@RequestMapping("/api/coupons")
public class CouponsController {
    private CouponsService couponsService;

    @PostMapping("/offercode/{offerCode}")
    public ResponseEntity<String> createCoupons(@PathVariable  String offerCode){

        String savedCoupons = couponsService.createCoupons(offerCode);
        //return new ResponseEntity<>(saveCodeType, HttpStatus.CREATED);
        return ResponseEntity.ok("Coupons have been added successfully.");
    }
    @GetMapping("/offercode/{offerCode}")
    public ResponseEntity<List<CouponsDTO>> getCouponsByOfferCode(@PathVariable String offerCode){
        //codeKeyID codeKeyID = new codeKeyID(codeType);
        List<CouponsDTO> couponsDtos = couponsService.getCouponsByOfferCode(offerCode);

        return ResponseEntity.ok(couponsDtos);
    }
}
