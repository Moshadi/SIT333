package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("login view...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("login form...");
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        RedirectView redirectView = null;
        if (LoginService.login(username, password, dob)) {
            redirectView = new RedirectView("/q1", true);
        } else {
            redirectView = new RedirectView("/login", true);
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
        }

        return redirectView;
    }

    @GetMapping("/q1")
    public String q1View(Model model) {
        System.out.println("q1 view...");
        // Set numbers for question 1
        model.addAttribute("number1", 5);
        model.addAttribute("number2", 3);
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q1 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q1Addition(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;

        try {
            double userResult = Double.parseDouble(resultUser);

            if (Double.isNaN(calculatedResult)) {
                redirectView = new RedirectView("/q1", true);
                redirectAttributes.addFlashAttribute("message", "Invalid input numbers, try again.");
            } else if (Double.compare(calculatedResult, userResult) == 0) {
                redirectView = new RedirectView("/q2", true);
            } else {
                redirectView = new RedirectView("/q1", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (NumberFormatException e) {
            redirectView = new RedirectView("/q1", true);
            redirectAttributes.addFlashAttribute("message", "Invalid answer input, try again.");
        }

        return redirectView;
    }

    @GetMapping("/q2")
    public String q2View(Model model) {
        System.out.println("q2 view...");
        // Set numbers for question 2
        model.addAttribute("number1", 7);
        model.addAttribute("number2", 2);
        return "view-q2";
    }

    @PostMapping("/q2")
    public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q2 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;

        try {
            double userResult = Double.parseDouble(resultUser);

            if (Double.isNaN(calculatedResult)) {
                redirectView = new RedirectView("/q2", true);
                redirectAttributes.addFlashAttribute("message", "Invalid input numbers, try again.");
            } else if (Double.compare(calculatedResult, userResult) == 0) {
                redirectView = new RedirectView("/q3", true);
            } else {
                redirectView = new RedirectView("/q2", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (NumberFormatException e) {
            redirectView = new RedirectView("/q2", true);
            redirectAttributes.addFlashAttribute("message", "Invalid answer input, try again.");
        }

        return redirectView;
    }

    @GetMapping("/q3")
    public String q3View(Model model) {
        System.out.println("q3 view...");
        // Set numbers for question 3
        model.addAttribute("number1", 4);
        model.addAttribute("number2", 6);
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        System.out.println("q3 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;

        try {
            double userResult = Double.parseDouble(resultUser);

            if (Double.isNaN(calculatedResult)) {
                redirectView = new RedirectView("/q3", true);
                redirectAttributes.addFlashAttribute("message", "Invalid input numbers, try again.");
            } else if (Double.compare(calculatedResult, userResult) == 0) {
                redirectView = new RedirectView("/success", true);
            } else {
                redirectView = new RedirectView("/q3", true);
                redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
            }
        } catch (NumberFormatException e) {
            redirectView = new RedirectView("/q3", true);
            redirectAttributes.addFlashAttribute("message", "Invalid answer input, try again.");
        }

        return redirectView;
    }

    @GetMapping("/success")
    public String successView() {
        System.out.println("success view...");
        return "view-success";
    }
}
