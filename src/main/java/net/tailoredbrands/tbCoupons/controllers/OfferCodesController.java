package net.tailoredbrands.tbCoupons.controllers;

import lombok.AllArgsConstructor;
import net.tailoredbrands.tbCoupons.dto.OfferCodesDTO;
import net.tailoredbrands.tbCoupons.service.OfferCodesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;


@AllArgsConstructor
@RestController
@RequestMapping("/api/offercodes")
public class OfferCodesController {
    private OfferCodesService offerCodeService;

    // Build Add Offer Code REST API
    @PostMapping
    public ResponseEntity<OfferCodesDTO> createOfferCode(@RequestBody OfferCodesDTO offerCodeDTO){
        OfferCodesDTO saveOfferCode = offerCodeService.createOfferCode(offerCodeDTO);
        return new ResponseEntity<>(saveOfferCode, HttpStatus.CREATED);
    }
    // Build Add Offer Code REST API
    @PostMapping("/loadAll/")
    public ResponseEntity<String> createOfferCodes(@RequestBody List<OfferCodesDTO> offerCodeDto){

        String saveOfferCode = offerCodeService.createOfferCodes(offerCodeDto);
        return ResponseEntity.ok("Offer Codes have been added successfully.");
    }
    // Build Add Offer Code REST API
    @GetMapping("/loadAll/")
    public ResponseEntity<List<OfferCodesDTO>> getOfferCodes(){

        List<OfferCodesDTO> offerCodesDTOList = offerCodeService.getOfferCodes();
        return ResponseEntity.ok(offerCodesDTOList);
    }

    @GetMapping("/{offerCode}")
    public ResponseEntity<OfferCodesDTO> getByOfferCodeId(@PathVariable String offerCode){
        OfferCodesDTO saveOfferCode = offerCodeService.getByOfferCodeId(offerCode);
        return ResponseEntity.ok(saveOfferCode);
    }

    // Build code_type update API
    @PutMapping("/{offerCode}")
    public ResponseEntity<OfferCodesDTO> updateOfferCode(@RequestBody @PathVariable String offerCode, OfferCodesDTO offerCodeDTO){
        OfferCodesDTO updatedOfferCode = offerCodeService.updateOfferCode(offerCode, offerCodeDTO);
        return  ResponseEntity.ok(updatedOfferCode);
    }

    // Build code_type delete API
    @DeleteMapping("/{offerCode}")
    public ResponseEntity<String> deleteOfferCode(@RequestBody @PathVariable String offerCode){
        offerCodeService.deleteOfferCode(offerCode);
        return  ResponseEntity.ok("Offer Code Type: " + trim(offerCode) + " deleted successfully.");
    }
}
