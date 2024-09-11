package net.tailoredbrands.tbCoupons.controllers;

import lombok.AllArgsConstructor;
import net.tailoredbrands.tbCoupons.dto.CodeTypesDTO;
import net.tailoredbrands.tbCoupons.service.CodeTypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.trim;

@AllArgsConstructor
@RestController
@RequestMapping("/api/codetypes")
public class CodeTypesController {

    private CodeTypesService codeTypeService;

    // Build Add Code Type REST API

    @PostMapping
    public ResponseEntity<String> createCodeType(@RequestBody List<CodeTypesDTO> codeTypeDTO){
        String saveCodeType = codeTypeService.createCodeType(codeTypeDTO);
        //return new ResponseEntity<>(saveCodeType, HttpStatus.CREATED);
        return ResponseEntity.ok("Code Types have been added successfully.");
    }


    // Build Get Code Type REST API

    @GetMapping("/key/{codeKey}/code/{codeType}")
    public ResponseEntity<CodeTypesDTO> getByCodeKeyId(@PathVariable String codeType, @PathVariable String codeKey){
        CodeTypesDTO saveCodeType = codeTypeService.getByCodeKeyId(codeKey, codeType);
        return ResponseEntity.ok(saveCodeType);
    }

    @GetMapping("/code/{codeKey}")
    public ResponseEntity<List<CodeTypesDTO>> getByCodeKey(@PathVariable String codeKey){
        //codeKeyID codeKeyID = new codeKeyID(codeType);
        List<CodeTypesDTO> codeTypeList = codeTypeService.getByCodeKey(codeKey);

        return ResponseEntity.ok(codeTypeList);
    }

    // Build code_type update API
    @PutMapping("/key/{codeKey}/code/{codeType}")
    public ResponseEntity<CodeTypesDTO> updateCodeType(@RequestBody @PathVariable String codeKey, @PathVariable String codeType,  CodeTypesDTO codeTypeDTO){
        CodeTypesDTO updatedCodeType = codeTypeService.updateCodeType(codeKey, codeType, codeTypeDTO);
        return  ResponseEntity.ok(updatedCodeType);
    }

    // Build code_type delete API
    @DeleteMapping("/key/{codeKey}/code/{codeType}")
    public ResponseEntity<String> deleteCodeType(@RequestBody @PathVariable String codeKey, @PathVariable String codeType){
        codeTypeService.deleteCodeType(codeKey, codeType);
        return  ResponseEntity.ok("Code Type: " + trim(codeType) + " and Code Key: " + trim(codeKey) + " deleted successfully.");
    }
}
