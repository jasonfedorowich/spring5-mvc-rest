package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void categoryToCategoryDTO() {
        Category category = new Category();
        category.setName("Jason");
        category.setId(1L);

        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Jason", categoryDTO.getName());
    }
}