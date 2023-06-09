package org.skillfactory;

import org.skillfactory.dto.StudentData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/student")
    public ModelAndView myData() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("myData", "Hello, student!");
        return mav;
    }

    @RequestMapping(value = "/greetings/{name}")
    public String greetingsByName(@PathVariable String name) {
        return "Hello, " + name;
    }

    @RequestMapping(value = "/student/submit", method = RequestMethod.POST)
    public String giveMeFeedbackAboutGrade(@RequestBody StudentData studentData) {
        return "You are greate with your grade "
                + studentData.getGrade() + "\n"
                + studentData.getFirstName() + "\n"
                + studentData.getLastName();
    }
}
