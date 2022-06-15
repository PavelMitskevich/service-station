package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.SparePartPriceDTO;
import by.mitskevich.servicestation.service.SparePartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/spareParts")
public class SparePartController {

    private final SparePartService sparePartService;

    @PostMapping()
    public String createSpareParts(Model model, @ModelAttribute("sparePartPriceDTOS") List<SparePartPriceDTO> sparePartPriceDTOS) {
        model.addAttribute("spareParts", sparePartPriceDTOS);
        return "pages/infoOrders";
    }
}
