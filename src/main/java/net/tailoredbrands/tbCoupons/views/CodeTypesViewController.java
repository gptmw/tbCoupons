package net.tailoredbrands.tbCoupons.views;

import net.tailoredbrands.tbCoupons.service.CodeTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeTypesViewController {
    
    @Autowired
    private CodeTypesService codeTypesService;
    // display list of Code Types
    @GetMapping("/")
    public String viewCodeTypes(Model model){
        String codeKey = "CHANNEL";
        model.addAttribute("listByCodeKey", codeTypesService.getByCodeKey(codeKey));
        return "index";

    }
}
