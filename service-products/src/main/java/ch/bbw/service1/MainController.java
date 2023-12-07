package ch.bbw.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    @GetMapping("api/products")
    public List<Product> getProducts() {
        return null;
    }
}