package com.example.ex1_managementapartmentbuilding;

import com.example.ex1_managementapartmentbuilding.model.Tenant;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.ex1_managementapartmentbuilding.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import org.junit.jupiter.api.Test;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TenantRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TenantRepository tenantRepository;

    @Test
    @Rollback(false)
    public void testCreateTenant() {
        Tenant savedTenant = tenantRepository.save(new Tenant(1, "Nguyen Van A", "026541235624", "a@gmail.com", "0325632541", "Cau Giay, Ha Noi"));

        assertThat(savedTenant.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(value = false)
    public void testGetAllTenant()
    {
        List<Tenant> tenantList = tenantRepository.findAll();

        assertThat(tenantList.size()).isGreaterThan(0);
    }

    @Test
    @Rollback(value = false)
    public void testFindTenantById()
    {

        Tenant tenant = tenantRepository.findById(1);
        assertThat(tenant.getId().equals(1));
    }


}
