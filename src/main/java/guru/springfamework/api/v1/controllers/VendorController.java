package guru.springfamework.api.v1.controllers;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1/vendors/"})
public class VendorController {

    private final VendorService vendorService;


    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors(){
        return new VendorListDTO(vendorService.getAllVendors());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendor(@PathVariable Long id){
       return vendorService.getVendorById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO createVendor(VendorDTO vendorDTO){
        return vendorService.createVendor(vendorDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, VendorDTO vendorDTO){
        return vendorService.updateVendor(vendorDTO, id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, VendorDTO vendorDTO){
        return vendorService.patchVendor(vendorDTO, id);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Void patchVendor(@PathVariable Long id){
        vendorService.deleteVendor(id);
        return null;
    }

}
