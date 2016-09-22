package ua.nure.hasanov.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.hasanov.controller.AbstractPageController;
import ua.nure.hasanov.controller.ControllerConstants;

@Controller
@RequestMapping("/")
public class HomePageController extends AbstractPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return ControllerConstants.Views.Pages.HOMEPAGE;
    }

}
