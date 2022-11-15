package in.upcode.eShop.controller;

import in.upcode.eShop.model.Product;
import in.upcode.eShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String viewItemsPage(ModelMap model) {
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listItems", listProducts);
        return "products";
    }

    @RequestMapping("/new")
    public String showNewProductPage(ModelMap model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new-product";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("edit-product");
        Product product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @RequestMapping("/view/{id}")
    public ModelAndView showProduct(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("viewProduct");
        Product product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);

        return "redirect:/products";
    }

}
