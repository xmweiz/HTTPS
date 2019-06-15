package controller;


import domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ItemsService;

@Controller
@RequestMapping("/itmes")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/showDetail")
    public String showDetail(Model model){
        Items items = itemsService.findById(1);
        model.addAttribute("item", items);
        return "itemDetail";
    }
}
