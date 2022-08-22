package intern.sapo.be.controller;

import intern.sapo.be.dto.request.Product.OptionAdd;
import intern.sapo.be.dto.request.Product.ProductAdd;
import intern.sapo.be.entity.Product;
import intern.sapo.be.service.IProductService;
import intern.sapo.be.service.ISupplierService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/products/variants")
public class PController {

    private IProductService productService;

    public PController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity getPagination(@RequestParam(value = "pageNumber",required = false) Integer pageNumber,
                                        @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                        @RequestParam(value = "name",required = false) String name
    ){
        return ResponseEntity.ok(productService.findAllVariant(pageNumber,pageSize,name) );
    }


    @GetMapping("/findAll")
    public List<Product> list() {
        return productService.findAll();
    }

    @PostMapping
    public Product create(@RequestBody @Valid ProductAdd request, BindingResult bindingResult) {
        return productService.save(request,bindingResult);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }



    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        productService.deleteById(id);
    }


//update

    @PutMapping
    public Product update(@RequestBody @Valid Product entity,BindingResult bindingResult) {
        return productService.save(entity,bindingResult);
    }

    @DeleteMapping("/options/{id}")
    public ResponseEntity update (@PathVariable Integer id,@RequestBody OptionAdd[] options)
    {
        return  ResponseEntity.ok(options);
    }


}
