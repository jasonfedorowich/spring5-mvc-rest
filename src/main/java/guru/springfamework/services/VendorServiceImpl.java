package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final VendorMapper mapper;


    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper mapper) {

        this.vendorRepository = vendorRepository;
        this.mapper = mapper;
    }


    @Override
    public List<VendorDTO> getAllVendors() {
       return vendorRepository.findAll().stream().map(
                mapper::vendorToVendorDTO
        ).collect(Collectors.toList());

    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id).map(
                mapper::vendorToVendorDTO
        ).orElse(null);
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = mapper.vendorDTOtoVendor(vendorDTO);
        vendor = vendorRepository.save(vendor);
        return mapper.vendorToVendorDTO(vendor);
    }

    @Override
    public VendorDTO updateVendor(VendorDTO vendorDTO, Long id) {
        Vendor vendor = mapper.vendorDTOtoVendor(vendorDTO);
        vendor.setId(id);
        vendor = vendorRepository.save(vendor);
        return mapper.vendorToVendorDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
        return vendorRepository.findById(id).map(
               vendor -> {
                   vendor.setName(vendorDTO.getName());
                   return mapper.vendorToVendorDTO(vendorRepository.save(vendor));
               }
        ).orElse(null);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);

    }
}
