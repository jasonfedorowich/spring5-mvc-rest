package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorMapperTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void vendorToVendorDTO() {
    }

    @Test
    public void vendorDTOtoVendor() {

        Vendor vendor = new Vendor();
       vendor.setName("Jason");

        VendorDTO vendorDTO = VendorMapper.INSTANCE.vendorToVendorDTO(vendor);

        assertEquals(vendorDTO.getName(), vendor.getName());

    }
}