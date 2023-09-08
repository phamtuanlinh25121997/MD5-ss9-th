package ss5.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ss5.th.model.Customer;
import ss5.th.service.ICustomerService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView listCustomers() {
       return new ModelAndView("list","customers",customerService.findAll());
    }

    @GetMapping("/add")
    public ModelAndView showCreateForm() {
        return new ModelAndView("add","customer",new Customer());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            return new ModelAndView("edit","customer",customer.get());
        } else {
            return new ModelAndView("404");
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
       return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }



}

